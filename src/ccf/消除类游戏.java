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
public class 消除类游戏{
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
   public static Set<List<Integer>> hang(int row,int line,int[][] arr,Set<List<Integer>> xy){
      List<Integer> list = null;
      int k = 0;
      int j=0;
      for(int i=0;i<row;i++){
         int count =0;
         k = 0;
         for(j=k;j<line;j++) {
            System.out.println("=========="+j);
            if (arr[i][k] == arr[i][j]) {
               count++;
            } else {
               if(count>2){
                  for(int m=0;m<count;m++){
                     list = new ArrayList<>();
                     list.add(i);
                     list.add(k+m);
                     xy.add(list);
                  }
                  System.out.println(xy.toString());
                  break;
               }else {
                  count=0;
               }
               k++;
               j=--k;
            }
         }
         if(j==line){
            k++;
         }
      }
      return xy;
   }

   public static Set<List<Integer>> lie(int row,int line,int[][] arr,Set<List<Integer>> xy){
      List<Integer> list = null;
      int index=0;
      int k = 0;
      for(int j=0;j<line;j++){
         int count =0;
         k = 0;
         for(int i=k;i<row;i++) {
            index = i+1;
            if (arr[k][j] == arr[i][j]) {
               count++;
            } else {
               if(count>2){
                  for(int m=0;m<count;m++){
                     list = new ArrayList<>();
                     list.add(k+m);
                     list.add(j);
                     xy.add(list);
                  }
                  System.out.println(xy.toString());
                  break;
               }else {
                  count=0;
               }
               k++;
            }
         }
         if(index==line){
            k++;
         }
      }
      return xy;
   }
}
