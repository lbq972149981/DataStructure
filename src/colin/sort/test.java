package colin.sort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import colin.SortUtil.sortUtil;
import java.util.Arrays;
public class test {
   public static void main(String[] args) {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
      int[] arr = sortUtil.randArr(1,100,20);
      int[] arrSort = sortUtil.getArr(1,30000,20000,10000);
      int[] arr1 = Arrays.copyOf(arr,arr.length);
      int[] arr2 = Arrays.copyOf(arr,arr.length);
      int[] arr3 = Arrays.copyOf(arr,arr.length);
      int[] arr4 = Arrays.copyOf(arr,arr.length);
      insertSort insertSort = (insertSort)applicationContext.getBean("insertSort");
      selectSort selectSort  = (selectSort)applicationContext.getBean("selectSort");
      shellSort shellSort  = (shellSort)applicationContext.getBean("shellSort");
      mergeSort mergeSort  = (mergeSort)applicationContext.getBean("mergeSort");
      quickSort quickSort  = (quickSort)applicationContext.getBean("quickSort");
      bubbleSort bubbleSort  = (bubbleSort)applicationContext.getBean("bubbleSort");
      myQuickSort myQuickSort  = (myQuickSort)applicationContext.getBean("myQuickSort");
      myInsertSort myInsertSort  = (myInsertSort)applicationContext.getBean("myInsertSort");
      myShellSort myShellSort  = (myShellSort)applicationContext.getBean("myShellSort");
      mySelectSort mySelectSort  = (mySelectSort)applicationContext.getBean("mySelectSort");
      myMergeSort myMergeSort  = (myMergeSort)applicationContext.getBean("myMergeSort");
      System.gc();
      quickSort.sort(arr);
      System.gc();
      System.out.println(Arrays.toString(arr));

   }
}
