package LinkList;

import org.junit.Test;

public class DuLinkList {
   public class Node{
      private String data;
      private Node next;
      private Node previous;
      public Node(String data,Node previous,Node next){
         this.data = data;
         this.next = next;
         this.previous = previous;
      }
   }
   private Node header;
   private Node tail;
   private int size;
   public DuLinkList(){
      header = null;
      tail = null;
   }
   @Test
   public void test(){
      this.addHeader("A");
      this.addTail("B");
      this.addHeader("C");
      this.insert("D",1);
      this.delete(2);
      this.insert("E",1);
      System.out.println(this);
   }
   public void addHeader(String data){
      Node newNode = new Node(data,null,header);
      header = newNode;
      if(tail == null){
         tail = header;
      }
      size++;
   }
   public void addTail(String data){
      //空链表
      if(header==null){
         //创建头结点，next为空
         header = new Node(data,null,null);
         tail = header;
      }else {

         Node newNode = new Node(data,tail,null);
         //尾结点下一个是增加的新节点，再讲尾结点指向新加入的结点，新加入的结点成为新的尾结点
         tail.next = newNode;
         tail = newNode;
      }
      size++;
   }
   /**
    * @param index:即将插入节点的索引号
    * @return 返回索引指定的那个节点
    */
   public Node getNodeByIndex(int index){
      Node currentNode = header;//代表从头找
      for(int i=0;i<size;i++){
         if(i==index){ //找到了
            return currentNode;
         }
         currentNode = currentNode.next;
      }
      return currentNode;
   }


   /**
    *
    * @param data 要插入的数据
    * @param index 在该索引处插入
    */
   public void insert(String data,int index){
      if(index<0||index>=size){
         System.out.println("越界");
      }
      if(header == null){//判断是否有节点
         this.addTail(data);
      }else {
         if(index == 0){
            this.addHeader(data);
         }else {
            Node temp = this.getNodeByIndex(index-1);
            Node current = new Node(data,temp,temp.next);
            temp.next.previous = current;
            temp.next = current;
         }
      }
      size++;
   }
   public String delete(int index){
      Node del = null;
      if(index == 0){//删除头节点或者只有一个节点
         del = header;
         header = header.next;
      }else {//该链表多于一个节点
         Node prev = this.getNodeByIndex(index-1);
         del = prev.next;
         prev.next = del.next;
         del.next.previous = del.previous;
      }
      del.next = null;
      del.previous = null;
      return del.data;
   }
   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();
      for(Node current = header;current!=null;current=current.next){
         sb.append(current.data);
      }
      return sb.toString();
   }
}
