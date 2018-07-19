package Queue;

import org.junit.Before;
import org.junit.Test;

/**
 * 实现循环队列 允许覆盖
 */
public class LoopQueue {
   //默认长度
   private int DEFAULT_SIZE = 10;
   //队列长度
   private int capacity;
   private String[] elementData;
   private int front = 0; //出++
   private int rear = 0;  //进++
   @Test
   public void test(){
      add("AA");
      add("AA");

      System.out.println(isEmpty());

   }
   @Before
   public void init(){
      elementData = new String[3];
      capacity = elementData.length;
   }
   public void add(String data){
      elementData[rear++] = data;
      rear = rear == capacity ? 0 : rear;
   }
   public String remove(){
      String s = elementData[front];
      elementData[front++] = null;
      front = front == capacity ? 0 : front;
      return s;
   }
   public boolean isEmpty(){
      return rear == front && elementData[front] ==null;
   }
   public int length(){
      if(rear == 1 &&elementData[front]!=null){
         return elementData.length;
      }
      return rear-front;
   }
}
