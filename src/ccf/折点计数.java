package ccf;

import java.util.Scanner;

public class 折点计数 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int[] arr = new int[num];
      int count = 0;
      for(int i=0;i<num;i++){
         arr[i] = sc.nextInt();
      }
      for(int i=1;i<arr.length-1;i++){
         if((arr[i]-arr[i-1])*(arr[i]-arr[i+1])>0){
            count++;
         }
      }
      System.out.println(count);
   }
}
