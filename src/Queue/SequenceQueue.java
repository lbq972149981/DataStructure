package Queue;
import org.junit.Before;
import org.junit.Test;

/**
 * 实现顺序队列
 */
public class SequenceQueue {
   //默认长度
   private int DEFAULT_SIZE = 10;
   //队列长度
   private int capacity;
   private String[] elementData;
   private int front = 0; //出++
   private int rear = 0;  //进++
   @Test
   public void test(){

      add("CC");
      add("CC"); add("AA");
      add("BB");
      add("CC");
      add("CC");
      add("CC");
      add("CC");
      add("CC");
      add("CC");
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
      System.out.println(remove());
   }
   @Before
   public void init(){
      elementData = new String[10];
      capacity = elementData.length;
   }
   public void add(String data){
      if(rear >= capacity){
         try {
            throw new Exception();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      elementData[rear++] = data;
   }
   public String remove(){
      String s = elementData[front];
      elementData[front++] = null;
      return s;
   }
}
