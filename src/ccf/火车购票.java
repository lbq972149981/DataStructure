package ccf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 火车购票 {
   public static void main(String[] args) {
      /*
      4
      2 5 4 2
       */
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      List<List<Integer>> pers = new LinkedList<>();
      List<Integer> per = null;
      for(int j=0;j<20;j++){
         pers.add(new LinkedList<Integer>());
      }
      for(int i=0;i<100;i++){
         pers.get(i/5).add(i+1);
      }
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> rr = null;
      for(int i=0;i<T;i++){
         int m = sc.nextInt();
         for(List<Integer> p:pers){
            if(p.size()>=m){
               rr = new ArrayList<>();
               for(int k=0;k<m;k++){
                  rr.add(p.get(0));
                  p.remove(0);
               }
               result.add(rr);
               break;
            }
         }
      }
      for(List<Integer> l:result){
         int c=0;
         for(Integer v:l){
            c++;
            if(c<l.size()) {
               System.out.print(v + " ");
            }else {
               System.out.println(v);
            }
         }
      }
   }
}
