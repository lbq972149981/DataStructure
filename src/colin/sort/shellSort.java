package colin.sort;
import colin.SortUtil.sortUtil;
import org.springframework.stereotype.Component;
@Component("shellSort")
public class shellSort {
   /**
    * 希尔排序
    * 跨度为length/2的插入排序
    * 最后一次为简单插入排序
    */
   public void sort(int[] arr){
      for(int n = arr.length / 2;n>0;n = n / 2) {
         for (int i = n; i < arr.length; i++) {
            for (int j = i; j > 0; j-=n) {
               if(j-n>=0) {
                  if (arr[j] < arr[j - n]) {
                     sortUtil.switchArr(arr, j, j - n);
                  } else {
                     break;
                  }
               }
            }
         }
      }
   }
}
