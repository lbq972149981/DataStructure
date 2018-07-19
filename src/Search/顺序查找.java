package Search;

/**
 * 顺序表查找
 */
public class 顺序查找 {
   /**
    * 顺序查找，平均时间复杂度O(n)
    * @param searchKey 要查找的值
    * @param arr 从该数组中查找
    * @return  返回找到的元素的index
    */
   public static int orderSearch(int searchKey,int ... arr){
      for(int i=0;i<arr.length;i++){
         if(arr[i]==searchKey){
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      int index = orderSearch(95,1,2,29,3,95,3,5,6,7,9,12);
      System.out.println("查找到元素的位置："+index);
   }
}
