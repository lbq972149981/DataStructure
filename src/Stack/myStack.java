package Stack;

import org.junit.Test;

/**
 * 自己写栈
 * @param <T>
 */
public class myStack<T> {
   private Object[] objs = new Object[16];
   private int size = 0;
   @Test
   public void Test(){
      push("A");
      push("B");
      push("C");
      System.out.println(pop());
      System.out.println(pop());
      System.out.println(peek());
   }
   public boolean isEmpty(){
      return size == 0;
   }
   public void clear(){
      for(int i=0;i<objs.length;i++){
         objs[i] = null;
      }
   }
   public int length(){
      return size;
   }
   public boolean push(Object date){
      if(size>=objs.length){
         resize();
      }
      objs[size++] = date;
      return false;
   }
   public void resize(){
      Object[] temp = new Object[objs.length*3];
      for(int i=0;i<objs.length;i++){
         temp[i] = objs[i];
         objs[i] = null;
      }
      objs = temp;
   }
   public Object pop(){
      Object oldvalue = objs[size-1];
      objs[--size] = null;
      return oldvalue;
   }
   public Object peek(){
      Object o = objs[size-1];
      return o;
   }

}
