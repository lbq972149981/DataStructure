package ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 除法 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      List<Integer> arr = new ArrayList();
      List<Integer> arr1 = new ArrayList();
      List<Integer> arr2 = new ArrayList();
      List<Integer> results = new ArrayList();
      List<Integer> flags = new ArrayList();

      int result = 0;
      for(int i=0;i<N;i++){
         arr.add(sc.nextInt());
      }
      for(int j=0;j<M;j++){
         result = 0;
         int flag = sc.nextInt();
         if(flag == 1){
            for(int i=0;i<3;i++){
               arr1.add(i,sc.nextInt());
            }
            for(int i=arr1.get(0)-1;i<arr1.get(1);i++){
               if(arr.get(i)%arr1.get(2)==0) {
                  arr.set(i, arr.get(i) / arr1.get(2));
               }
            }
         }else{
            for(int i=0;i<2;i++){
               arr2.add(i,sc.nextInt());
            }
            arr.toArray();

            for(int i=arr2.get(0)-1;i<arr2.get(1);i++){
               result += arr.get(i);

            }
            results.add(result);
         }
      }
      for(int re:results){
         System.out.println(re);
      }

   }
}
