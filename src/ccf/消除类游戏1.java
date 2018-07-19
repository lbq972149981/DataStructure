package ccf;

import java.util.*;
/**
 4 5
 2 2 3 1 2
 3 4 5 1 4
 2 3 2 1 3
 2 2 2 4 4
 4 5
 2 2 3 1 2
 3 1 1 1 1
 2 3 2 1 3
 2 2 3 3 3
 */
public class 消除类游戏1 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int row = sc.nextInt();
      int line = sc.nextInt();
      Set<List<Integer>> xy = new HashSet<>();
      int[][] arr = new int[row][line];
      for(int i=0;i<row;i++){
         for(int j=0;j<line;j++){
            arr[i][j] = sc.nextInt();
         }
      }
      xy = hang(row,line,arr,xy);
      xy = lie(row,line,arr,xy);
      for(int i=0;i<row;i++){
         for(int j=0;j<line;j++){
            for(List<Integer> v:xy){
               if(i==v.get(0)&&j==v.get(1)){
                  arr[i][j] = 0;
               }
            }
         }
      }
      for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[i].length;j++){
            if(j<arr[i].length-1) {
               System.out.print(arr[i][j] + " ");
            }else {
               System.out.println(arr[i][j]);
            }
         }
      }
   }
   public static Set<List<Integer>> hang(int h,int l,int[][] arr,Set<List<Integer>> xy){
      List<Integer> list1 = null;
      List<Integer> list2 = null;
      List<Integer> list3 = null;
      for(int i=0;i<h;i++){
         for(int j=1;j<l-1;j++){
            if(arr[i][j]==arr[i][j+1]&&arr[i][j]==arr[i][j-1]){
               list1 = new ArrayList<>();
               list1.add(i);
               list1.add(j-1);
               xy.add(list1);
               list2 = new ArrayList<>();
               list2.add(i);
               list2.add(j);
               xy.add(list2);
               list3 = new ArrayList<>();
               list3.add(i);
               list3.add(j+1);
               xy.add(list3);
            }
         }
      }
      return xy;
   }
   public static Set<List<Integer>> lie(int row,int line,int[][] arr,Set<List<Integer>> xy){
      List<Integer> list1 = null;
      List<Integer> list2 = null;
      List<Integer> list3 = null;
      for(int j=0;j<line;j++){
         for(int i=1;i<row-1;i++){
            if(arr[i+1][j]==arr[i][j]&&arr[i][j]==arr[i-1][j]){
               list1 = new ArrayList<>();
               list1.add(i-1);
               list1.add(j);
               xy.add(list1);
               list2 = new ArrayList<>();
               list2.add(i);
               list2.add(j);
               xy.add(list2);
               list3 = new ArrayList<>();
               list3.add(i+1);
               list3.add(j);
               xy.add(list3);
            }
         }
      }
      return xy;
   }
}
