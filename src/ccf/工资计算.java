package ccf;

import java.util.Scanner;

public class 工资计算 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int sum = sc.nextInt();
      double result = 0;
      if(sum<=3500){
         System.out.println(sum);
      }else {
         for (int i = 3600; i <= 100000; i += 100) {
            int t = i - 3500;
            if(t<1500&&i-t*0.03==sum){
               System.out.println(i);
            }else if(t>1500&&t<4500&&i-(t-1500)*0.1-1500*0.03==sum){
               System.out.println(i);
            }
         }
      }
   }
}
