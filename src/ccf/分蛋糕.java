package ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 分蛋糕 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int sum = 0;
      int count = 0;
      List<Integer> arr = new ArrayList<>();
      for(int i=0;i<n;i++){
         arr.add(sc.nextInt());
      }
      //2 6 5 6 3 5
      //7 11
      //4 9 1 4 7 5 6
      for(int i=0;i<n;i++){
         sum = sum + arr.get(i);
         if(sum >= k){
            count++;
            sum = 0;
         }
         else if(sum < k && i==n-1){
            count++;
         }
      }
      System.out.println(count);
   }
}
