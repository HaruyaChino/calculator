
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


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

            String[] values = inputString.split("[^0-9]",0);
               int nums = Integer.parseInt(String.valueOf(values));

            String[] operators = inputString.split("[0-9]",0);






    }
}