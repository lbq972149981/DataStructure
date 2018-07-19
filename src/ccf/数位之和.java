package ccf;

import java.math.BigInteger;
import java.util.Scanner;

/*
样例输入

20151220

样例输出

13
 */
public class 数位之和 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      long num = sc.nextLong();
      int sum = 0;
      for(int i=0;i<(num+"").length();i++){
         String s = (num+"").charAt(i)+"";
         sum += Integer.parseInt(s);
      }
      System.out.println(sum);
   }
}
