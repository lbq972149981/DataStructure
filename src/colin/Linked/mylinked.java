package colin.Linked;

import org.junit.Test;

public class mylinked<E> {

   public class Node{
      public E data;
      public Node next;
      public Node pre;

      public Node(E data) {
         this.data = data;
      }
   }

   public Node getTop() {
      return top;
   }

   @Test
   public void test(){
      mylinked<String> link = new mylinked<>();
      link.add("aaa");
      link.add("bbb");
      link.add("ccc");
      link.add("ddd");
      link.show();
      System.out.println(link.size());
      System.out.println(link.remove("ddd").data);
      System.out.println("-------------------");
      link.show();
      System.out.println(link.size());
   }
   @Test
   public void test1(){
      mylinked<String> link = new mylinked<>();
      System.out.println(link.insert(0,"aaa"));
      System.out.println(link.insert(0,"bbb"));
      System.out.println(link.insert(0,"ccc"));
      link.show();
   }
   private Node top = null;
   private Node end = null;
   private int size = 0;
   public void add(E data){
      Node node = new Node(data);
      if(top==null){
         top = node;
      }else {
         end.next = node;
         node.pre = end;
      }
      size++;
      end = node;
   }
   public Node remove(E data){
      Node del = top;
      while(del!=null) {
         if(del.data instanceof String) {
            if (del.data.equals(data)) {
              if(del==top){
                 top = top.next;
                 size--;
                 return del;
              }else if(del==end){
                 end = del.pre;
                 end.next= null;
                 size--;
                 return del;
              }else {
                 Node temp = del.next;
                 del.pre.next = del.next;
                 temp.pre = del.pre;
                 size--;
                 return del;
              }
            }
         }
         del = del.next;
      }
      return null;
   }
   public int insert(int index,E data){
      Node node = new Node(data);
      if(index>size||index<0){
         return 0;
      }else {
         if(top==null){
            add(data);
         }else {
            Node temppre = getCurrentNode(index-1);
            Node tempnext = getCurrentNode(index);
            temppre.next = node;
            tempnext.pre = node;
         }
      }
      return 1;
   }
   public Node getCurrentNode(int index){
      Node current = top;
      for(int i=0;i<size;i++){
         if(i==index){
            return current;
         }
         current = current.next;
      }
      return current;
   }
   public void show(){
      Node temp = top;
      while(temp!=null){
         System.out.println(temp.data);
         temp = temp.next;
      }
   }
   public int size(){
      return size;
   }
}
