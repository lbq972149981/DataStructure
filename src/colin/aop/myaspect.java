package colin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class myaspect {
   @Around("execution(* colin.sort.selectSort.sort(..))")
   public void selectSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("选择排序:"+(end-start)+"ms");
   }
   @Around("execution(* colin.sort.insertSort.sort(..))")
   public void insertSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("插入排序:"+(end-start)+"ms");
   }
   @Around("execution(* colin.sort.insertSort.sort1(..))")
   public void insertSort1(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("插入排序改进:"+(end-start)+"ms");
   }
   @Around("execution(* colin.sort.shellSort.sort(..))")
   public void shellSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("希尔排序:"+(end-start)+"ms");
   }
   @Around("execution(* colin.sort.mergeSort.sort(..))")
   public void mergeSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("归并排序:"+(end-start)+"ms");
   }
   @Around("execution(* colin.sort.quickSort.sort(..))")
   public void quickSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("快速排序:"+(end-start)+"ms");
   }
  /* @Around("execution(* colin.sort.bubbleSort.sort(..))")
   public void bubbleSort(ProceedingJoinPoint ProceedingJoinPoint){
      long start = System.currentTimeMillis();
      try {
         ProceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      long end = System.currentTimeMillis();
      System.out.println("冒泡排序:"+(end-start)+"ms");
   }*/
   @After("execution(* colin.sort.bubbleSort.sort(..))")
   public void bubbleSort(){
      System.out.println("冒泡排序AAAAAAAAAAA");
   }
}
