package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 父节点表示法
 * 表示一棵树
 */
public class TreeParent {
   public Node root(String data){
      nodes[0] = new Node(data,-1);
      this.nodeNums++;
      return nodes[0];
   }
   @Test
   public void test(){
      Node root = this.root("root");
      Node B = this.addNode("B",root);
      Node C = this.addNode("C",B);
      Node D = this.addNode("D",root);
      Node E = this.addNode("E",D);
      System.out.println(this.deep());
      for(Node node :this.getChildren(root)){
         System.out.println(node.data);
      }
   }
   public static class Node{
      public String data;
      public int parent;
      public Node(String data,int parent){
         this.data = data;
         this.parent = parent;
      }
   }
   private int treeSize = 100; //记录树的总量
   private Node[] nodes = new Node[this.treeSize];       //节点数组
   private int nodeNums;       //记录节点数
   public TreeParent(){

   }
   /**
    *
    * @param data 当前节点数据
    * @param parent 该节点的父节点
    */
   public Node addNode(String data,Node parent){
      for(int i=0;i<this.treeSize;i++){
         if(nodes[i]==null){
            nodes[i] = new Node(data,getPos(parent));
            nodeNums++;
            return nodes[i];
         }
      }
      return null;
   }

   /**
    *
    * @param node 要查找的节点
    * @return 该节点在树中的索引号
    */
   public int getPos(Node node){
      for(int i=0;i<this.treeSize;i++){
         if(nodes[i]==node){
            return i;
         }
      }
      return -1;
   }

   /**
    *
    * @return 返回该树的最大深度
    */
   public int deep(){
      int max = 0;
      for(int i=0;i<this.treeSize&&nodes[i]!=null;i++){
         int def = 1;
         int m = nodes[i].parent;
         while (m!=-1&&nodes[m]!=null){
            m = nodes[m].parent;//一直往上找父节点 直到找到根节点为止
            def++;
         }
         if(def > max) {
            max = def;
         }
      }
      return max;
   }

   /**
    *
    * @param parent 指定父节点
    * @return 当前父节点下的儿子
    */
   public List<Node> getChildren(Node parent){
      List<Node> list = new ArrayList<>();
      for(int i=0;i<this.treeSize;i++){
         if(nodes[i]!=null&&nodes[i].parent==getPos(parent)){
            list.add(nodes[i]);
         }
      }
      return list;
   }
}
