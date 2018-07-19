package colin.stack;

import org.junit.Test;

public class LinkedStack<E> {
   private Node top = null;
   private int size = -1;
   public class Node{
      public E data;
      public Node pre;
      public Node(E data) {
         this.data = data;
      }
   }
   @Test
   public void test(){
      LinkedStack<String> linkedStack = new LinkedStack<>();
      linkedStack.push("aaa");
      linkedStack.push("bbb");
      linkedStack.push("ccc");
      linkedStack.push("ddd");
      System.out.println(linkedStack.pop());System.out.println(linkedStack.size());
      System.out.println(linkedStack.pop());System.out.println(linkedStack.size());
      System.out.println(linkedStack.pop());System.out.println(linkedStack.size());
      System.out.println(linkedStack.pop());System.out.println(linkedStack.size());
      System.out.println(linkedStack.pop());System.out.println(linkedStack.size());
   }
   public void push(E data){
      Node node = new Node(data);
      if(top==null){
         top = node;
         size=0;
      }else {
         node.pre = top;
         top = node;
      }
      size++;
   }
   public E pop(){
      if(isEmpty())
         return null;
      Node del = top;
      top = top.pre;
      size--;
      return del.data;
   }
   public int size(){
      return size;
   }
   public boolean isEmpty(){
      return top==null;
   }
}
