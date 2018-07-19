package Queue;

import org.junit.Test;

/**
 * 链式单向队列
 */
public class LinkQueue {
   private class Node{
      //保存节点数据
      private String data;
      //指向下一个节点引用
      private Node next;
      public Node(String data,Node next){
         this.data = data;
         this.next = next;
      }
   }
   public LinkQueue(){

   }
   private Node front;
   private Node rear;
   private int size;
   @Test
   public void test(){
      add("AA");
      add("BB");
      add("CC");
      System.out.println(remove());
      System.out.println(remove());
   }
   public void add(String data){
      if(front == null){
         front = new Node(data,null);
         rear = front;
      }else {
         Node newNode = new Node(data,null);
         rear.next = newNode;
         rear = newNode;
      }
      size++;
   }
   public String remove(){
      Node oldNode = front;
      front = front.next;
      oldNode.next = null;
      size--;
      return oldNode.data;
   }
}
