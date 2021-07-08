import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

          InputStreamReader isr = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(isr);
          System.out.println("計算式を入力してください(演算子は +、-、＊、/ の中から入力してください)");
          System.out.print("式："); //入力式受け取り
        while(true) {
          String inputString = null;
          try {
              inputString = br.readLine();
          } catch (IOException e) {
              e.printStackTrace();
          }
          //文字列中のスペース無視
          Objects.requireNonNull(inputString).replaceAll("　", " ").replaceAll(" ", "");
          //"end"と入力するとプロセスを閉じる
          if (inputString.equals("end") || inputString.equals("END")) {
              try {
                  br.close();
                  isr.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
              System.out.println("計算を終了します");
              return;
          }

          String[] valuesString = inputString.split("[^0-9]", 0);

          int total = 0;
          if(valuesString.length < 2 || ((valuesString.length != 3) && (valuesString.length % 3 != 2))){
             System.out.println("入力式が正しくありません");
             return;
          }else{
              String[] operators = inputString.split("[0-9]",0);
                total = Integer.parseInt(valuesString[0]);
                    for(int i = 0; i < valuesString.length;i++){

                            if(operators.equals("*")){
                                total = total * Integer.parseInt(valuesString[i+1]);
                            }else if(operators.equals("/")){
                                total = total / Integer.parseInt(valuesString[i+1]);
                            }else if (operators.equals("+")){
                                total = total + Integer.parseInt(valuesString[i+1]);
                            }else if (operators.equals("-")){
                                total = total - Integer.parseInt(valuesString[i+1]);
                            }else{
                                System.out.println("error");
                                return;
                }
            }
                System.out.println(total);



          }
      }
    }
}