package Stack;

import java.util.Enumeration;
import java.util.Stack;

/**
 * JDK栈
 */
public class StackJDKTest {
   public static void main(String[] args) {
      Stack stack = new Stack();
      stack.push(new Integer(111));
      printStack(stack);
      stack.push(new String("aaa"));
      printStack(stack);
      stack.push(new String("bbb"));
      printStack(stack);
   }
   public static void printStack(Stack stack){
      if(stack.empty()){
         System.out.println("stack is empty");
      }else{
         Enumeration es = stack.elements();
         while(es.hasMoreElements()){
            System.out.print(es.nextElement()+" ");
         }
      }
      System.out.println();
   }
}
