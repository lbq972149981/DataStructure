package colin.queue;

import org.junit.Test;

import java.util.Arrays;

public class ArrayQueue<E> {
      private E[] elements ;
      private int size = 0;
      private static final int newSize = 3;
      public ArrayQueue(){
         elements = (E[])new Object[newSize];
      }
      @Test
      public void test(){
         //canvas
         ArrayQueue<String> arrayStack = new ArrayQueue<>();
         arrayStack.add("aaa");
         arrayStack.add("bbb");
         arrayStack.add("ccc");
         arrayStack.add("ddd");
         System.out.println(arrayStack.get());System.out.println(arrayStack.size());
         System.out.println(arrayStack.get());System.out.println(arrayStack.size());
         System.out.println(arrayStack.get());System.out.println(arrayStack.size());
         System.out.println(arrayStack.get());System.out.println(arrayStack.size());
         System.out.println(arrayStack.get());System.out.println(arrayStack.size());
      }
      public void add(E data){
         elements[size] = data;
         size++;
         if(size==newSize){
            elements = Arrays.copyOf(elements,newSize*2);
         }
      }
      public E get(){
         if(size==0){
            return null;
         }
         E element = elements[0];
         size--;
         for(int i =0;i<size;i++){
            elements[i] = elements[i+1];
         }
         return element;
      }
      public boolean isEmpty(){
         return size==0;
      }

      public int size() {
         return size;
      }
   }