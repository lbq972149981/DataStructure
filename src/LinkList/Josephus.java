package LinkList;

import org.junit.Test;

/**
 * 约瑟夫环
 */
public class Josephus {
   public class Node{
      public int data;
      public Node next;
      public Node(int data){
         this.data = data;
      }
   }
   public void init(){
      int m = 41;//总人数
      int n = 3; //出圈数字
      //声明第一个节点
      Node first = new Node(0);
      Node last = first;
      for(int i=1;i<m;i++){
         //形成一个链表
         last.next = new Node(i);
         last = last.next;
      }
      last.next = first; // 形成首尾相连的约瑟夫环
      while(last!=last.next){
         for(int i=1;i<n;i++){
            last = last.next;
         }
         System.out.println("出圈号："+last.next.data);
         last.next = last.next.next;//跳圈的人越过去
      }
      System.out.println("幸运者："+last.data);

   }
   @Test
   public void test(){
      this.init();
   }
}
