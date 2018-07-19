package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 子节点链表示法
 */
public class TreeChild {

   //子节点
   private static class SonNode{
      private int pos;  //当前节点的位置
      private SonNode next; //下一个子节点对象
      public SonNode(int pos,SonNode next){
         this.pos = pos;
         this.next = next;
      }
   }
   //子节点号
   private static class Node{
      private String data;
      private SonNode first;
      public Node(String data){
         this.data = data;
         this.first = null;
      }
   }
   private int treeSize = 100;
   private Node[] nodes = new Node[this.treeSize];
   private int nodeNums;
   public Node root(String data){
      nodes[0] = new Node(data);
      this.nodeNums++;
      return nodes[0];
   }
   public Node addNode(String data,Node parent){
       for(int i=0;i<this.treeSize;i++){
          if(nodes[i] == null){
             nodes[i] = new Node(data);
             if(parent.first == null){//如果没有孩子链
                parent.first = new SonNode(i,null);//parent儿子的第一个节点
             }else {//父节点有子节点串到最后，在连接
                SonNode next = parent.first;
                while(next.next!=null){
                   next = next.next;
                }
                next.next = new SonNode(i,null);
             }
             nodeNums++;
             return nodes[i];
          }

       }
       return null;
   }
   public int deep(Node node){

      if(node.first==null){
         return 1;
      }else {
         int max = 0;
         SonNode sonNode = node.first;
         while(sonNode!=null){
            int tem = deep(nodes[sonNode.pos]);
            if(tem>max){
               max = tem;
            }
            sonNode = sonNode.next;
         }
         return ++max;
      }
   }
   public List getChildren(Node parent){
      List list = new ArrayList();
      SonNode sonNode = parent.first;
      while(sonNode!=null){
         list.add(nodes[sonNode.pos]);
         sonNode = sonNode.next;
      }
      return list;
   }

   @Test
   public void test(){
      Node root = this.root("A");
      Node B = this.addNode("B",root);
      Node C = this.addNode("C",root);
      Node D = this.addNode("D",B);
      System.out.println(this.deep(B));
      List<Node> list = this.getChildren(root);
      for(Node node:list){
         System.out.println(node.data);
      }
   }
}
