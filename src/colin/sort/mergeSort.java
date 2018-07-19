package colin.sort;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("mergeSort")
public class mergeSort {

   public void sort(int[] arr){
      sortMerge(arr,0,arr.length-1);
   }
   private void sortMerge(int[] arr,int left,int right){
      if(left<right){
         int mid = (left+right)/2;
         sortMerge(arr,left,mid);
         sortMerge(arr,mid+1,right);
         merge1(arr,left,mid,right);
      }
   }
   private void merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[arr.length];
        int L = left;
        int R = mid+1;
        int k = left;
        while(L<=mid&&R<=right){
           if(arr[L] <= arr[R]){
              temp[k++] = arr[L++];
           }else {
              temp[k++] = arr[R++];
           }
        }
        while(L<=mid){
           temp[k++] = arr[L++];
        }
        while(R<=right){
            temp[k++] = arr[R++];
        }
        while(left<=right){
         arr[left] = temp[left];
         left++;
        }
   }
   private void merge1(int[] arr,int left,int mid,int right){
      int[] leftarr = Arrays.copyOfRange(arr,left,mid+1);
      int[] rightarr = Arrays.copyOfRange(arr,mid+1,right+1);
      int li=0;
      int ri=0;
      for(int i=left;i<=right;i++){
         if(li>=leftarr.length){
            arr[i] = rightarr[ri++];
         }else if(ri>=rightarr.length){
            arr[i] = leftarr[li++];
         }else if(leftarr[li]>rightarr[ri]){
            arr[i] = rightarr[ri++];
         }else {
            arr[i] = leftarr[li++];
         }
      }
   }
}
