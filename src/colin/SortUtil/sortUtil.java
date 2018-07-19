package colin.SortUtil;

import org.junit.Test;

import java.util.*;

public class sortUtil {
   @Test
   public void test(){
      int[] arr = randArr(1,100,7);
      System.out.println(Arrays.toString(arr));
      switchArr (arr,0,3);
      System.out.println(Arrays.toString(arr));
      switchBySort(arr,3);
      System.out.println(Arrays.toString(arr));
   }

   /**
    * 数组元素交换
    * @param arr
    * @param num
    * @return
    */
   public static int[] switchBySort(int[] arr,int num){
      Random random = new Random();
      int indexi = 0;
      int indexj = 0;
      for(int i=0;i<num;i++){
         indexi = random.nextInt(arr.length);
         indexj = random.nextInt(arr.length);
         System.out.println(indexi+"-----"+indexj);
         if(indexi!=indexj){
            arr = switchArr(arr,indexi,indexj);
         }else {
            i--;
         }
      }
      return arr;
   }

   /**
    * 交换
    * @param arr
    * @param indexi
    * @param indexj
    * @return
    */
   public static int[] switchArr(int[] arr,int indexi,int indexj){
      int temp = arr[indexi];
      arr[indexi] = arr[indexj];
      arr[indexj] = temp;
      return arr;
   }

   public static int[] getArr(int begin,int end,int arrLength,int num){
      int[] arr = randArr(begin,end,arrLength);
      Arrays.sort(arr);
      Random random = new Random();
      int indexi = 0;
      int indexj = 0;
      for(int i=0;i<num;i++){
         indexi = random.nextInt(arr.length);
         indexj = random.nextInt(arr.length);
         if(indexi!=indexj){
            arr = switchArr(arr,indexi,indexj);
         }else {
            i--;
         }
      }
      return arr;
   }
   /**
    * 随机生成指定范围的数组
    * @param begin
    * @param end
    * @param arrLength
    * @return
    */
   public static int[] randArr(int begin,int end,int arrLength){
      int[] arr = new int[arrLength];
      Random random = new Random();
      for(int i=0;i<arrLength;i++){
         arr[i]=random.nextInt(end-begin)+begin;
      }
      return arr;
   }
}
