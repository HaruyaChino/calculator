
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.println("計算式を入力してください(演算子は +、-、＊、/ の中から入力してください)");
            System.out.print("式："); //入力式受け取り
            String calc = sc.nextLine();
            String[] values = calc.split(" ",0);
            int[] numbers = new int[values.length];
                for(int i = 0; i < values.length; i++) {
                    try{
                        numbers[i] =  Integer.parseInt(values[i]);
                    }catch(NumberFormatException e) {
                         System.out.println("正しい入力を行ってください");

                    }

                }


    }
}