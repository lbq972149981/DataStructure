package ccf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 第二小整数 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      List<Integer> arr = null;
      int num = sc.nextInt();
      for(int i=0;i<num;i++){
         int n = sc.nextInt();
         arr = new ArrayList<>();
         for(int j=0;j<n;j++){
            arr.add(sc.nextInt());
         }
         Collections.sort(arr);
         System.out.println(arr.get(1));

      }
   }
}
