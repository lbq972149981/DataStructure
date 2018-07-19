package colin.sort;

import colin.SortUtil.sortUtil;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component("quickSort")
public class quickSort {
   public void sort(int[] arr){
      QuickSort(arr,0,arr.length-1);
   }
   // 5 2 1 8 7 3
   // 2 1 5 8 7 3
   //单路
   private int partition1(int[] arr,int low,int high){
      Random random = new Random();
//      sortUtil.switchArr(arr,low,random.nextInt(high-low)+low);
      int key = arr[low];
      int index = low;
      for(int i=low+1;i<=high;i++){
         if(arr[i]<key){
            sortUtil.switchArr(arr,i,index+1);
            index++;
         }
      }
      sortUtil.switchArr(arr,low,index);
      return index;
   }
   //二路
   private int partition(int[] arr,int low,int high){
      int key = arr[low];
      while(low<high) {
         while (key <= arr[high] && low < high) {
            high--;
         }
         sortUtil.switchArr(arr,high,low);
         while (key >= arr[low] && low < high) {
            low++;
         }
         sortUtil.switchArr(arr,high,low);
      }
         arr[high] = key;
      return high;
   }
   private void QuickSort(int[] arr,int low,int high){
      if(low>=high){
         return;
      }
//      int index = partition3(arr,low,high);
//      QuickSort(arr,low,index-1);
//      QuickSort(arr,index+1,high);
      int[] index = partition3(arr,low,high);
      QuickSort(arr,low,index[0]);
      QuickSort(arr,index[1],high);

   }
   //三路
   public int[] partition3(int[] arr,int low,int high){
     int key = arr[low];
     int l = low;
     int r = high+1;
     int i = low+1;
     while(i<r){
        if(arr[i]<key){
           sortUtil.switchArr(arr,i,l+1);
           l++;
           i++;
        }else if(arr[i]>key){
           sortUtil.switchArr(arr,i,r-1);
           r--;
        }else {
           i++;
        }
     }
     sortUtil.switchArr(arr,low,l);
     return new int[]{l,r};
   }
}
