package Sort;

import java.util.Arrays;

/**
 * 堆是具有下列性质的完全二叉树
 * 1.每个节点的值都大于或等于其左右孩子的节点的值，称为大顶堆
 * 2.每个节点的值都小于或等于其左右孩子的节点的值，称为小顶堆
 */
public class 堆排序 {

   public static void main(String[] args) {
      int[] arr = {9,79,46,30,58,49};
      arr = heapSort(arr);
      System.out.println(Arrays.toString(arr));

   }
   public static int[] heapSort(int[] arr){
      int arrlen = arr.length;
      for(int i=0;i<arrlen-1;i++){
         buildMaxHeap(arrlen-1-i,arr);
         arr = swap(0,arrlen-1-i,arr);
      }
      return arr;
   }
   public static int[] swap(int i,int j,int[] arr){
      int temp = 0;
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      return arr;
   }
   public static void buildMaxHeap(int lastIndex,int[] arr){
      //找到lastIndex父节点的索引号
      for(int i=(lastIndex-1)/2;i>=0;i--){
         int k = i;
         //判断当前父节点的子节点
         while(2*k+1<=lastIndex){
            //k的左子节点
            int biggerIndex = 2*k+1;
            //代表k节点的右节点存在
            if(biggerIndex<lastIndex){//防止溢出
               if(arr[biggerIndex]<arr[biggerIndex+1]){
                  biggerIndex++;
               }
            }
            //否则biggerIndex就是最大的那个子节点，无右节，在和父节点比较
            if(arr[k]<arr[biggerIndex]){
              arr = swap(k,biggerIndex,arr);
            }else {
               break;
            }
         }
      }
   }
}
