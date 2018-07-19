package colin.stack;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
public class ArrayStack<E> {
   private E[] elements ;
   private int size = 0;
   private static final int newSize = 3;
   public ArrayStack(){
      elements = (E[])new Object[newSize];
   }
   @Test
   public void test(){
      ArrayStack<String> arrayStack = new ArrayStack<>();
      arrayStack.push("aaa");
      arrayStack.push("bbb");
      arrayStack.push("ccc");
      arrayStack.push("ddd");
      System.out.println(arrayStack.pop());System.out.println(arrayStack.size());
      System.out.println(arrayStack.pop());System.out.println(arrayStack.size());
      System.out.println(arrayStack.pop());System.out.println(arrayStack.size());
      System.out.println(arrayStack.pop());System.out.println(arrayStack.size());
      System.out.println(arrayStack.pop());System.out.println(arrayStack.size());
   }
   public void push(E data){
      elements[size] = data;
      size++;
      if(size==newSize){
         elements = Arrays.copyOf(elements,newSize*2);
      }
   }
   public E pop(){
      return !isEmpty()?elements[--size]:null;
   }
   public boolean isEmpty(){
      return size==0;
   }

   public int size() {
      return size;
   }
}
