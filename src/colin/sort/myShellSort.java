package colin.sort;

import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;

@Component("myShellSort")
public class myShellSort {
   public void sort(int[] arr){
      int len = arr.length/2;
      do{
         for (int i = len; i < arr.length; i++) {
            for (int j = i; j > 0&&j-len>=0; j-=len) {
               if (arr[j] < arr[j - len]) {
                  sortUtil.switchArr(arr, j, j - len);
               } else {
                  break;
               }
            }
         }
         len = len/2;
      }while (len!=0);
   }
}
