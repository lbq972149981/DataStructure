package Queue;

import org.junit.Test;

/**
 * 链式双向队列
 */
public class DoublyQueue {
   public class Node{        //链节点
      private String data;
      private Node next;     //后继指针
      private Node previous; //前驱指针
      Node(String data){
         this.data =data;
      }
   }
   private Node front;
   private Node rear;
   @Test
   public void test(){
      insertFirst("AA");
      insertFirst("BB");
      insertLast("CC");
      insertFirst("DD");
      //DBAC
      System.out.println(deleteLast());
      System.out.println(deleteFront());
      System.out.println(deleteFront());
      System.out.println(deleteFront());
   }
   public boolean isEmpty(){
      return front == null;
   }
   public void insertFirst(String data){
      Node newNode = new Node(data);
      if(isEmpty()){
         rear = newNode;
      }else {
         front.previous = newNode;
      }
      newNode.next = front;
      front = newNode;
   }
   public void insertLast(String data){
      Node newNode = new Node(data);
      if(isEmpty()){
         front  = newNode;
      }else {
         rear.next = newNode;
      }
      newNode.previous = rear;
      rear = newNode;
   }
   public String deleteFront(){
      if (isEmpty()) {
         return null;
      }
      Node temp = front;
      front = front.next;
      if(front!=null){
         front.previous = null;
      }else {
         rear = null;
      }
      return temp.data;
   }
   public String deleteLast(){
      if (isEmpty()){
         return null;
      }
      Node temp = rear;
      rear = rear.previous;
      if(rear!=null){
         rear.next = null;
      }else {
         front = null;
      }
      return temp.data;
   }
}
