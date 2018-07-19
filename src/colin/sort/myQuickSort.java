package colin.sort;

import colin.SortUtil.sortUtil;
import org.omg.CORBA.OMGVMCID;
import org.springframework.stereotype.Component;

@Component("myQuickSort")
public class myQuickSort {
   public void sort(int[] arr){
      QuickSort(arr,0,arr.length-1);
   }
   private void QuickSort(int[] arr, int start, int end) {
      if(start>=end){
         return;
      }
      int index =  partition(arr,start,end);
      QuickSort(arr,start,index-1);
      QuickSort(arr,index+1,end);
   }
   private int partition(int[] arr, int start, int end) {
      int key = arr[start];
      int index = start;
      for(int i=start+1;i<arr.length;i++){
         if(arr[i]<key){
            sortUtil.switchArr(arr,i,index+1);
            index++;
         }
      }
      sortUtil.switchArr(arr,start,index);
      return index;
   }
}
