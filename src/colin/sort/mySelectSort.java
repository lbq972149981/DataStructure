package colin.sort;

import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;

/**
 * 设置第一个为初始最大元素
 * 遍历，将倒数第i+1个元素 与 max 交换
 */
@Component("mySelectSort")
public class mySelectSort {
   public void sort(int[] arr){
      for(int i=0;i<arr.length;i++){
         int max = arr[0];
         int index = 0;
         int j=0;
         for(j=0 ;j<arr.length-i;j++){
            if(arr[j]>=max){
               max = arr[j];
               index = j;
            }
         }
         sortUtil.switchArr(arr,index,j-1);
      }
   }
}
