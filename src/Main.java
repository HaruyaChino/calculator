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
        String inputString = null;
        try {
            inputString = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文字列中のスペース無視
        Objects.requireNonNull(inputString).replaceAll("　"," ").replaceAll(" ","");
        //"end"と入力するとプロセスを閉じる
        if(inputString.equals("end") || inputString.equals("END")) {
            try {
                br.close();
                isr.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
            System.out.println("計算を終了します");
            return;
        }

            String[] valuesString = inputString.split("[^0-9]",0);
                int[] valuesInt = Stream.of(valuesString).mapToInt(Integer::parseInt).toArray();
                  for(int i = 0; i > 0; i++){
                      try{
                          valuesInt[i] = Integer.parseInt(args[i]);
                      }catch(NumberFormatException e){
                          System.out.println("正しく数値が入力されていません");
                      }
                  }
            String[] operators = inputString.split("[0-9]",0);
                for(int i = 0; i > 0; i++ ){
                    if(valuesString[i].equals("+")){

                    }else if(valuesString[i].equals("-")) {

                    }else if(valuesString[i].equals("/")){

                    }else if(valuesString[i].equals("*")){

                    }else{
                        System.out.println("演算子が正しく入力されていません");
                    }
                }





    }
}