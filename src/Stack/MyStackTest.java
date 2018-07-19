package Stack;

import org.junit.Test;
public class MyStackTest<T> {
   private Object[] objects = new Object[16];
   private int size = 0;
   @Test
   public void Test(){
      push("A");
      push("B");
      push("C");
      System.out.println(pop());
//      System.out.println(pop());
      System.out.println(peek());
      System.out.println(this.length());
   }
   public boolean push(Object t){
      if(size>=objects.length){
         Object[] temp = new Object[objects.length*3];
         for(int i=0;i<objects.length;i++){
            temp[i] = objects[i];
            objects[i] = null;
         }
         objects = temp;
      }
      objects[size++] = t;
      return false;
   }
   public T pop(){
      T t = (T)objects[size-1];
      objects[--size] = null;
      return t;
   }
   public T peek(){
      return (T)objects[size-1];
   }
   public int length(){
      return size;
   }
   public boolean isEmpty(){
      return size == 0;
   }
}
