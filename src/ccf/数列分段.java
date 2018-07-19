package ccf;

import java.util.Scanner;

public class 数列分段 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      int[] arr = new int[T];
      arr[0] = sc.nextInt();
      int count = 1;
      for(int i=1;i<T;i++){
         arr[i] = sc.nextInt();
         if(arr[i]!=arr[i-1]){
            count++;
         }
      }
      System.out.println(count);
   }
}
