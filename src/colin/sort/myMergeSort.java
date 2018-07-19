package colin.sort;
import org.springframework.stereotype.Component;
import java.util.Arrays;
@Component("myMergeSort")
public class myMergeSort {
   public void sort(int[] arr){
      MergeSort(arr,0,arr.length-1);
   }
   private void MergeSort(int[] arr, int start, int end) {
      if(start>=end){
         return;
      }
      int mid = (start+end)/2;
      MergeSort(arr,start,mid);
      MergeSort(arr,mid+1,end);
      merge1(arr,start,mid,end);
   }
   private void merge(int[] arr, int start, int mid, int end) {
      int[] temp = new int[arr.length];
      int k = start;
      int index = k;
      int lstart = start;
      int rstart = mid+1;
      while(lstart<=mid&&rstart<=end){
         if(arr[lstart]<=arr[rstart]){
            temp[index++] = arr[lstart++];
         }else {
            temp[index++] = arr[rstart++];
         }
      }
      while(lstart<=mid){
        temp[index++]  = arr[lstart++];
      }
      while(rstart<=end){
         temp[index++]  = arr[rstart++];
      }
      while(start<=end){
         arr[start] = temp[start];
         start++;
      }
   }
   public void merge1(int[] arr,int start,int mid,int end){
      int[] Larr = Arrays.copyOfRange(arr,start,mid+1);
      int[] Rarr = Arrays.copyOfRange(arr,mid+1,end+1);
      int li=0;
      int ri=0;
      for(int i=start;i<=end;i++){
         if(ri>=Rarr.length){
            arr[i] = Larr[li++];
         }else if(li>=Larr.length){
            arr[i] = Rarr[ri++];
         }else if(Larr[li]>Rarr[ri]){
            arr[i] = Rarr[ri++];
         }else {
            arr[i] = Larr[li++];
         }
      }
   }
}
