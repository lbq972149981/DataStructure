package LinkList;

import org.junit.Test;

/**
 * 单向链表
 */
public class LinkList {
   public class Node{
      private String data;
      private Node next;
      public Node(String data,Node next){
         this.data = data;
         this.next = next;
      }
   }
   private Node header;
   private Node tail;
   private int size;
   public LinkList(){
      header = null;
      tail = null;
   }
   @Test
   public void test(){
      this.addHeader("AA");
      this.addHeader("BB");
      this.addTail("CC");
      this.insert("DD",1);
      this.delete(2);
      System.out.println(this);
   }
   public void addTail(String data){
      //空链表
      if(header==null){
         //创建头结点，next为空
         header = new Node(data,null);
         tail = header;
      }else {

         Node newNode = new Node(data,null);
         //尾结点下一个是增加的新节点，再讲尾结点指向新加入的结点，新加入的结点成为新的尾结点
         tail.next = newNode;
         tail = newNode;
      }
      size++;
   }
   public void addHeader(String data){
      Node newNode = new Node(data,header);
      header = newNode;
      if(tail == null){
         tail = header;
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
            temp.next = new Node(data,temp.next);//计算机先看右边在赋值，插入到老节点的下一个节点的前一个位置；
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
      }
      del.next = null;
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
