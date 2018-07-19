package ccf;

import java.util.Scanner;

public class 打酱油 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int money = sc.nextInt();
      int sum = 0;
      int t1 = money/50;
      int t2 = (money-t1*50)/30;
      int t3 = (money-t1*50-t2*30)/10;
      sum = t1*7+t2*4+t3;
      System.out.println(sum);
   }
}
