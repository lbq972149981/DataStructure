package Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现哈夫曼树
 */
public class HuffmanTree {
   /**
    * 对哈夫曼进行初始化
    */
   public void init(){
      List<Node> list = new ArrayList<>();
      list.add(new Node("A",9));
      list.add(new Node("B",4));
      list.add(new Node("C",5));
      list.add(new Node("D",2));
      this.createTree(list);
   }
   @Test
   public void test(){
      List<Node> list = new ArrayList<>();
      list.add(new Node("A",6));
      list.add(new Node("B",7));
      list.add(new Node("C",13));
      list.add(new Node("D",16));
      list.add(new Node("C",18));
      list.add(new Node("D",30));
      levelOrderTraversal(this.createTree(list));
   }
   /**
    *
    * @param list 所有节点列表
    * @return 返回经过哈夫曼计算后的剩余的那个节点
    */
   public Node createTree(List<Node> list){
      while(list.size()>1){
         Collections.sort(list);
         Node left = list.get(0);//获取左子
         Node right = list.get(1);//获取右子
         Node parent = new Node(left.data+right.data,left.getWeight()+right.getWeight());
         parent.left = left;
         parent.right =right;
         list.remove(left);
         list.remove(right);
         list.add(parent);
      }
      return list.get(0);
   }
   /**
    *
    * @param nodes 所有节点的集合
    */
   public void levelOrderTraversal(Node nodes){
      ArrayDeque<Node> ad = new ArrayDeque<>();
      if(nodes==null){
         System.out.println("不能深度，因为没有根节点");
         return;
      }
      System.out.println("广度优先遍历：");
      ad.add(nodes);
      while(!ad.isEmpty()){
         Node node = ad.remove();
         System.out.println(node.data+"-->"+node.weight);
         if(node.left!=null){
            ad.add(node.left);
         }
         if(node.right!=null){
            ad.add(node.right);
         }
      }
   }
   private class Node implements Comparable<Node>{
      private String data;
      private double weight;   //权重
      private Node left;
      private Node right;
      public Node(String data,double weight){
         this.data = data;
         this.weight = weight;
      }

      public String getData() {
         return data;
      }

      public void setData(String data) {
         this.data = data;
      }

      public double getWeight() {
         return weight;
      }

      public void setWeight(double weight) {
         this.weight = weight;
      }

      public Node getLeft() {
         return left;
      }

      public void setLeft(Node left) {
         this.left = left;
      }

      public Node getRight() {
         return right;
      }

      public void setRight(Node right) {
         this.right = right;
      }

      @Override
      public int compareTo(Node other) {
         if(this.getWeight()>other.getWeight()){
            return 1;
         }
         if(this.getWeight()<other.getWeight()){
            return -1;
         }
         return 0;
      }
   }
}
