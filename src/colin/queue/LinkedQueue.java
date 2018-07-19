package colin.queue;

import org.junit.Test;

public class LinkedQueue<E> {
   private Node top = null;
   private Node end = null;
   private int size = 0;
   public class Node{
      public E data;
      public Node next;

      public Node(E data) {
         this.data = data;
      }
   }
   @Test
   public void test(){
      LinkedQueue<String> linkedQueue = new LinkedQueue<>();
      linkedQueue.add("aaa");
      linkedQueue.add("bbb");
      linkedQueue.add("ccc");
      System.out.println(linkedQueue.get());System.out.println(linkedQueue.size());
      System.out.println(linkedQueue.get());System.out.println(linkedQueue.size());
      System.out.println(linkedQueue.get());System.out.println(linkedQueue.size());
      System.out.println(linkedQueue.get());System.out.println(linkedQueue.size());
   }
   public void add(E data){
      Node node = new Node(data);
      if(top==null){
         top = node;
      }else {
         end.next = node;
      }
      end = node;
      size++;
   }
   public E get(){
      if(!isEmpty()) {
         Node node = top;
         top = top.next;
         size--;
         return node.data;
      }
      return null;
   }
   public int size(){
      return size;
   }
   public boolean isEmpty(){
      return size==0;
   }
}
