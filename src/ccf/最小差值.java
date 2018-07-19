package ccf;

import java.util.*;

public class 最小差值 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<n;i++){
         list.add(sc.nextInt());
      }
      Collections.sort(list, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return o2-o1;
         }
      });
      int max = 10000;
      for(int i=0;i<n-1;i++){
         if(list.get(i)-list.get(i+1)<max){
            max = list.get(i)-list.get(i+1);
         }
      }
      System.out.println(max);
   }
}
