package colin.sort;

import colin.SortUtil.sortUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("selectSort")
public class selectSort {
   public void sort(int[] arr){
      for(int i=0;i<arr.length-1;i++){
         for(int j=i+1;j<arr.length;j++){
            int temp = 0;
            if(arr[i]>arr[j]){
               sortUtil.switchArr(arr,i,j);
            }
         }
      }
   }
}
