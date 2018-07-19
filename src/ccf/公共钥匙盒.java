package ccf;

import java.util.*;

public class 公共钥匙盒 {
   public static void main(String[] args) {
      Scanner sc =new Scanner(System.in);
      int N = sc.nextInt();
      int K = sc.nextInt();
      List<List<Integer>> teachers = new ArrayList<>();
      List<Integer> teacher = null;
      int[] keys = new int[N];
      for(int i=0;i<N;i++){
         keys[i] = i+1;
      }
      for(int i=0;i<K;i++){
         int keynum = sc.nextInt();
         int start = sc.nextInt();
         int time = sc.nextInt();
         teacher = new ArrayList<>();
         teacher.add(keynum);
         teacher.add(start);
         teacher.add(start+time);
         teachers.add(teacher);
      }
      int max = maxtime(teachers);
      int min = mintime(teachers);
      Collections.sort(teachers, new Comparator<List<Integer>>() {
         @Override
         public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(0)-o2.get(0);
         }
      });
//      System.out.println(Arrays.toString(teachers.toArray()));
      for(int j=1;j<=max;j++) {
         for (List<Integer> t : teachers) {
            if(j<min){
               break;
            }
            if (t.get(2) == j) {
               for (int k = 0; k < N; k++) {
                  if (keys[k] == 0) {
                     keys[k] = t.get(0);
                     break;
                  }
               }
            }
            if (t.get(1) == j) {
               for (int i = 0; i < N; i++) {
                  if (t.get(0) == keys[i]) {
                     keys[i] = 0;
                     break;
                  }
               }
            }
         }
//         System.out.println("j="+j+Arrays.toString(keys));
      }
      for(int m=0;m<N;m++){
         if(m!=N-1) {
            System.out.print(keys[m] + " ");
         }else {
            System.out.println(keys[m]);
         }
      }
   }
   public static int maxtime(List<List<Integer>> list){
      Collections.sort(list, new Comparator<List<Integer>>() {
         @Override
         public int compare(List<Integer> o1, List<Integer> o2) {
            return o2.get(2)-o1.get(2);
         }
      });
      return list.get(0).get(2);
   }
   public static int mintime(List<List<Integer>> list){
      Collections.sort(list, new Comparator<List<Integer>>() {
         @Override
         public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(2)-o2.get(2);
         }
      });
      return list.get(0).get(2);
   }
}
