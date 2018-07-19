package Sort;

import java.util.Arrays;

public class 直接选择排序 {
   public static void main(String[] args) {
      int[] arr = {3,1,4,1,5,9,10};
      arr = selectSort(arr);
      System.out.println(Arrays.toString(arr));
   }
   public static int[] selectSort(int[] arr){
      for(int i=0;i<arr.length-1;i++){
         for(int j=i+1;j<arr.length;j++){
            int temp = 0;
            if(arr[i]>arr[j]){
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
      return arr;
   }
}
