package ccf;

import java.util.Scanner;

public class 竹青遍野 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n= sc.nextInt();
      for(int i=0;i<n;i++){
         int m = sc.nextInt();
         long sum = 0;
         for(int j=1;;j++){
            sum += j*j*j;
            if(sum>=m){
               System.out.println(j);
               break;
            }
         }
      }
   }
}
