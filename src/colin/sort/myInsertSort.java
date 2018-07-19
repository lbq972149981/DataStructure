package colin.sort;

import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;

@Component("myInsertSort")
public class myInsertSort {
    /** 数组容量小，排序快
     *  数组接近有序，排序快*/
   /**
    * 从第2个元素开始arr[i],i=1;
    * 遍历i之前的元素arr[j]
    * 只要arr[j]<arr[j-1]就进行交换，反之，退出内层循环。
    * @param arr
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
   }//改进，减少交换次数

   /**
    * 从第2个元素开始arr[i],i=1;
    * 遍历i之前的元素arr[j]
    * arr[i] 前面元素大于arr[i] ，向右串
    * 否则arr[i]与arr[j]值交换
    *
    * @param arr
    * @param f
    */
   public void sort(int[] arr,boolean f){
      for(int i=1;i<arr.length;i++){
         int temp = arr[i];
         int j = 0;
         for(j=i;j>0;j--){
            if(temp<arr[j-1]){
               arr[j] = arr[j-1];
            }else {
               break;
            }
         }
         arr[j] = temp;
      }
   }
}
