package Queue;

import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStackQueue {
   private Stack stackPush = new Stack();
   private Stack stackPop = new Stack();
   @Test
   public void test(){
      add("AA");
      add("BB");
      add("CC");
      push();
      pop();
   }
   public void add(String data){
      stackPush.push(data);
   }
   public void push(){
      while(!stackPush.isEmpty()){
         stackPop.push(stackPush.pop());
      }
   }
   public void pop(){
         while(!stackPop.isEmpty()){
            System.out.println(stackPop.pop());
         }
   }
}
