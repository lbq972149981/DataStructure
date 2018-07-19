package Stack;

import org.junit.Test;

import java.util.Stack;

public class GetStackMin {
   private Stack<Integer> stack = new Stack<>();
   private Stack<Integer> minStack = new Stack<>();
   @Test
   public void Test(){
      push(6);
      push(21);
      push(1);
      push(0);
      System.out.println(getMin());
   }
   public void push(Integer data){
      if(minStack.isEmpty()){
         minStack.push(data);
      }else {
         if(data<minStack.peek()){
            minStack.push(data);
         }
      }
      stack.push(data);
   }
   public int getMin(){
      return minStack.peek();
   }
}
