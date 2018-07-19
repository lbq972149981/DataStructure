package ccf;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 学生排队 {
   public class Node {
      public int data;
      public Node next;
      public Node(int data) {
         this.data = data;
      }
   }
   public int size = 1;
   @Test
   public void test(){
      int N = 8;
      int count = 1;
      Node first = new Node(1);
      Node last = first;
      for(int i=2;i<=N;i++){
         last.next = new Node(i);
         last = last.next;
         size++;
      }
      for(int i=0;i<count;i++){
         Node temp = first;
         int StuNum = 3;
         int Pos = 2;
         for(int j=0;j<StuNum;j++){
            temp =temp.next;
         }
         if(Pos>0){
            for(int j=0;j<Math.abs(Pos);j++){
               temp = temp.next;
            }
         }
      }
      for(int i=0;i<size;i++){
         System.out.print(first.data);
         first = first.next;
      }
   }
}
