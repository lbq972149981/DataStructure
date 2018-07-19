package colin.sort;

import colin.SortUtil.sortUtil;

public class HeapTest {
   public static void main(String[] args) {
      int arr[] = sortUtil.randArr(1,100,20);
      Heap heap = new Heap(arr);
      PrintHeap.treePrint(heap);
   }
}
