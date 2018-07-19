package Tree;

import org.junit.Test;

/**
 * 二叉树的顺序存储
 */
public class ArrayBinTree {
   private Object[] datas;
   private int DEFAULT_DEEP = 8;
   private int deep;
   private int arraySize;
   public void init(String data){
      this.deep = DEFAULT_DEEP;
      this.arraySize = (int)Math.pow(2,deep)-1;
      datas = new Object[arraySize];
      datas[0] = data;
   }
   public ArrayBinTree(){

   }

   /**
    *
    * @param index 需要添加子节点的父节点的索引
    * @param data  新子节点的数据
    * @param left  是否为左节点
    */
   public void add(int index,String data,boolean left){
      if(datas[index] == null){
         System.out.println("没有父节点");
         return;
      }
      if(2*index+1>=this.arraySize){//左子越界
         System.out.println("满了，无法添加");
      }
      if(left){
         datas[2*index+1] = data;
      }else {
         datas[2*index+2] = data;
      }
   }

   /**
    *
    * @param index 父节点
    * @return 返回左子
    */
   public String left(int index){
      return datas[2*index+1].toString();
   }

   /**
    *
    * @param index
    * @return
    */
   public String right(int index){
      return datas[2*index+2].toString();
   }
   @Test
   public void test(){
      init("root");
      this.add(0,"1",true);
      this.add(0,"2",false);
      System.out.println(left(0));
      System.out.println(right(0));
   }
}
