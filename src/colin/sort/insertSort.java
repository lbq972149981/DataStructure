package colin.sort;

import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;
@Component("insertSort")
public class insertSort {
   /**
    * 插入排序
    * 数组容量小，排序快
    * 数组接近有序，排序快
    */
   public void sort(int[] arr){
      for(int i=1;i<arr.length;i++){
         for(int j=i;j>0;j--){
            if(arr[j]<arr[j-1]){
               sortUtil.switchArr(arr,j,j-1);
            }else {
               break;
            }
         }
      }
   }
   public void sort1(int[] arr){
      for(int i=1;i<arr.length;i++){
         int temp = arr[i];
         int j;
         for(j=i;j>0;j--){
            if(temp < arr[j-1]){
               arr[j] = arr[j-1];
            }else {
               break;
            }
         }
         arr[j] = temp;
      }
   }
}
