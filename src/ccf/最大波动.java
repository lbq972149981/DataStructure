package ccf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 最大波动 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      List<Integer> list = new ArrayList<>();
      while(T-->0){
         list.add(sc.nextInt());
      }
      /*
      6
      2 5 5 7 3 5
       */
      int max = 0;
      for(int i=0;i<list.size()-1;i++){
         if(Math.abs(list.get(i+1)-list.get(i))>max){
            max = Math.abs(list.get(i+1)-list.get(i));
         }
      }
      System.out.println(max);
   }
}
