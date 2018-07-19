package colin.sort;

import colin.SortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

public class countSort {
   public void sort(int[] arr){
      int[] newarr = new int[arr.length];
      //区间
      int max = arr[0];
      int min = arr[0];
      for(int i=0;i<arr.length;i++){
         if(arr[i]>max){
            max = arr[i];
         }
         if(arr[i]<min){
            min = arr[i];
         }
      }
      int countArr[] = new int[max-min+1];
      //计数
      for(int i=0;i<arr.length;i++){
         countArr[arr[i]-min]++;
      }
      System.out.println(Arrays.toString(arr));
      System.out.println(Arrays.toString(countArr));
      //求前面元素个数
      for(int i=1;i<countArr.length;i++){
         countArr[i] = countArr[i]+countArr[i-1];
      }
      System.out.println(Arrays.toString(countArr));
      for(int i=0;i<newarr.length;i++){
         newarr[--countArr[arr[i]-min]] = arr[i];
      }
      System.out.println(Arrays.toString(newarr));
   }
   @Test
   public void test(){
      int arr[] = sortUtil.randArr(1,100,20);
      sort(arr);

   }
}
