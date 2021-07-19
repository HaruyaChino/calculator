import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import static java.lang.System.out;



public class Main {
    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            out.println("計算式を入力してください(演算子は +、-、＊、/ の中から入力してください)");
            out.print("式："); //入力式受け取り
            String inputString = null;
                try {
                    inputString = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //文字列中のスペース無視
            String calc = Objects.requireNonNull(inputString).replaceAll(" ","");
                System.out.println(calc);
                //"end"と入力するとプロセスを閉じる
                if (inputString.equals("end") || inputString.equals("END")) {
                    try {
                        br.close();
                        isr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out.println("計算を終了します");
                    return;

                }

            //配列numberに整数部分を分割し格納
            String[] number = calc.split("[^0-9]",0);
                if(number.length != 2){
                    System.out.println("整数は二つだけ入力してください");
                    return;
                }
            //配列operatorに演算子部分を分割し格納
            //このときoperator[0]="" operator[1]="入力した四則演算子" の順で格納される
            String[] operator = calc.split("[0-9]+",0);
                if(operator.length != 2||!(operator[0].equals(""))){
                    System.out.println("式エラー");
                    return;
                }

            //operatorの条件分岐
                int total ;
                int remainder;
                switch (operator[1]) {
                    case "+":
                      total = Integer.parseInt(number[0]) + Integer.parseInt(number[1]);
                      System.out.println(total);
                      break;

                    case "-":
                        total = Integer.parseInt(number[0]) - Integer.parseInt(number[1]);
                        System.out.println(total);
                        break;

                    case "*":
                        total = Integer.parseInt(number[0]) * Integer.parseInt(number[1]);
                        System.out.println(total);
                        break;
                    case "/":

                        if(number[1].equals("0")){
                            out.println("除算エラー");
                            return;
                        }

                        total = Integer.parseInt(number[0]) / Integer.parseInt(number[1]);
                        remainder = Integer.parseInt(number[0]) % Integer.parseInt(number[1]);
                        System.out.println(total + "余り" + remainder);
                        break;

                    default:
                        System.out.println("演算子エラー");
                        return;
                    }


        }
    }
}