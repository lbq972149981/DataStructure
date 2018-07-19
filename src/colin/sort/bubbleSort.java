package colin.sort;

import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;

@Component("bubbleSort")
public class bubbleSort {
   public void sort(int[] arr){
      for(int i=0;i<arr.length;i++){
         for(int j=1;j<arr.length-i;j++){
            if(arr[j]<arr[j-1]){
               sortUtil.switchArr(arr,j,j-1);
            }
         }
      }
   }
}
