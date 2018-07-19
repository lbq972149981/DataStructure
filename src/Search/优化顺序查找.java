package Search;

/**
 * 顺序表查找
 */
public class 优化顺序查找{
   /**
    * 顺序查找，平均时间复杂度O(n)
    * @param searchKey 要查找的值
    * @param arr 从该数组中查找
    * @return  返回找到的元素的index
    */
   /*
   优化版
   不需要if判断
   设置哨兵，不需要判断越界
    */
   public static int orderSearch(int searchKey,int n,int[] arr){
      arr[0] = searchKey; //设置a[0]为哨兵
      int i = n;
      while(arr[i]!=searchKey){
         i--;
      }
      return i;
   }

   public static void main(String[] args) {
      int[] arr = new int[]{9,2,29,3,95,3,5,6,7,9,12};
      int index = orderSearch(95,arr.length-1,arr);
      System.out.println("查找到元素的位置："+index);
   }
}
