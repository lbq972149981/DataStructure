package Search;

/**
 * 插值查找
 * 时间复杂度O(logn)
 * 对于表较长较大，关键字分布比较均匀性能好于折半
 */
public class 插值查找 {
   public static int rank(int key,int[] arr){
      int low = 0;
      int high = arr.length-1;
      while(low <= high){
         int mid = low+(high-low)*(key-arr[low])/(arr[high]-arr[low]); //记录中间index
         if(key > arr[mid]){
            low = mid+1;
         }else if(key < arr[mid]){
            high = mid -1;
         }else {
            return mid;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      int[] arr = new int[]{0,1,2,3,4,5,6,7};
      int index = rank(2,arr);
      System.out.println("查找到元素的位置："+index);
   }
}
