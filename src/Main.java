import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
            String calc = Objects.requireNonNull(inputString).replaceAll(" ", "");

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
            String[] numberString = calc.split("[^0-9]", 0);
            int[] numberInt = Stream.of(numberString).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> numList = (ArrayList<Integer>) Arrays.stream(numberInt).boxed().collect(Collectors.toList());
            if (numList.size() <= 1) {
                System.out.println("整数エラー");
                return;
            }

            //配列operatorに演算子部分を分割し格納
            String[] operator = calc.split("[0-9]+", 0);
            ArrayList<String> opList = new ArrayList<>(Arrays.asList(operator));
            //operator[0]に "" が格納されているためArrayListのremoveで削除
            opList.remove(0);
            opList.add("");
            if (opList.size() < 1 ) {
                //opの格納がない場合のエラー
                System.out.println("式エラー");
                return;
            }
            ArrayList<Integer> sumList = new ArrayList<>();
            for (int i = 0; i < opList.size(); ++i) {
                //opが + - * / 以外の場合のエラー
                if (!(opList.get(i).equals("*")) && !(opList.get(i).equals("/")) && !(opList.get(i).equals("+")) && !(opList.get(i).equals("-")) && !(opList.get(i).equals(""))) {
                    System.out.println("演算子エラー");
                    return;

                }


                switch (opList.get(i)) {
                    case "+":
                        sumList.add(numList.get(i));
                        break;
                    case "-":
                        sumList.add(numList.get(i));
                        numList.set(i + 1, -(numList.get(i + 1)));
                        break;
                    case "*" :

                        String result = priorityOperator(numList.get(i), numList.get(i + 1), opList.get(i));
                        numList.set(i + 1, Integer.parseInt(result));

                        break;

                    case "/" :

                        result = priorityOperator(numList.get(i), numList.get(i + 1), opList.get(i));
                        if (result.equals("0除算エラー")) {
                            System.out.println("0除算エラー");
                            return;
                        }
                        numList.set(i + 1, Integer.parseInt(result));

                        break;

                    case "":
                        sumList.add(numList.get(numList.size() - 1));
                        break;

                    default:
                        return;
                }
            }
            int total = 0;
            for(int i = 0; i < sumList.size(); i++){
                total += sumList.get(i);
            }
            System.out.println(total);
        }
    }


    private static String priorityOperator(int a, int b, String op) {
        String result = "";
        switch (op) {
            case "*":
                result = String.valueOf(a * b);
                break;

            case "/":
                if (b == 0) {
                    result = "0除算エラー";
                } else {
                    result = String.valueOf(a / b);
                }
                break;
            default:
                break;
        }
        return result;

    }



}