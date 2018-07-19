package ccf;

import java.util.*;

public class 中间数 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      /* 1 5 5 6
         1 5 5 5 6
         1 2 5 5 5 5 6 7
         3 4 5 6 6 7
         3 3 6 7 7 8
         3 4 6 6 7
       */
      List<Integer> list = new ArrayList();
      while(N-->0){
         list.add(sc.nextInt());
      }
      Set<Integer> result = new HashSet<>();
      Collections.sort(list);
      for(int i=0;i<list.size();i++){
         result.add(results(list,i));
      }
      int size = result.size();
      int count = 0;
      if(size==1){
         for(Integer t:result){
            System.out.println(t);
         }
      }else {
         for(Integer t:result){
            count++;
            if(t!=-1){
               if(count<size){
                  System.out.print(t+" ");
               }else {
                  System.out.println(t);
               }
            }
         }
      }
   }
   public static int results(List<Integer> list,int index){
      int max = 0;
      int min = 0;
      for(int i=0;i<index;i++){
         if(list.get(index)>list.get(i)){
            min++;
         }
      }
      for(int i=index+1;i<list.size();i++){
         if(list.get(index)<list.get(i)){
            max++;
         }
      }
      if(max == min){
         return list.get(index);
      }
      return -1;
   }
}
