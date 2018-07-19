package Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 二叉树 先(DLR)、中(FDR)、 后(LRD)序遍历
 * 深度广度优先遍历
 * 深度depthOrderTraversal java栈
 * 广度levelOrderTraversal java队列
 */
public class BinaryTree {
   private class TreeNode{
      private String data;
      private TreeNode leftNode;
      private TreeNode rightNode;
      public TreeNode(String data, TreeNode leftNode, TreeNode rightNode) {
         this.data = data;
         this.leftNode = leftNode;
         this.rightNode = rightNode;
      }
      public String getData(){
         return data;
      }

      public TreeNode getLeftNode() {
         return leftNode;
      }

      public TreeNode getRightNode() {
         return rightNode;
      }
   }
   /*
              A
          /       \
         B            C
      /     \      /     \
      D      E     F      G
           /   \    \    /
           H    I    J   P
    */
   @Test
   public void init(){
      TreeNode D = new TreeNode("D",null,null);
      TreeNode H = new TreeNode("H",null,null);
      TreeNode I = new TreeNode("I",null,null);
      TreeNode J = new TreeNode("J",null,null);
      TreeNode K = new TreeNode("K",null,null);
      TreeNode E = new TreeNode("E",H,I);
      TreeNode B = new TreeNode("B",D,E);
      TreeNode F = new TreeNode("F",null,J);
      TreeNode G = new TreeNode("G",K,null);
      TreeNode C = new TreeNode("C",F,G);
      TreeNode A = new TreeNode("A",B,C);
      this.root = A;
      depthOrderTraversal();
      System.out.println();
      levelOrderTraversal();
      System.out.println();
      System.out.println("先序优先遍历：");
      pre(A);
      System.out.println();
      System.out.println("中序优先遍历：");
      middle(A);
      System.out.println();
      System.out.println("后序优先遍历:");
      suffix(A);
      System.out.println();
   }
   private TreeNode root;
   /**
    * 深度优先遍历，实际上就是先序DLR
    */
   public void depthOrderTraversal(){
      if(this.root==null){
         System.out.println("不能深度，因为没有根节点");
         return;
      }
      Stack<TreeNode> stack = new Stack<>();
      System.out.println("深度优先遍历：");
      stack.push(this.root);
      while(!stack.isEmpty()){
         TreeNode node = stack.pop();
         System.out.print(node.data+" ");
         if(node.rightNode!=null){
            stack.push(node.rightNode);
         }
         if(node.leftNode!=null){
            stack.push(node.leftNode);
         }
      }
   }

   /**
    * 广度优先遍历
    */
   public void levelOrderTraversal(){
      if(this.root==null){
         System.out.println("不能深度，因为没有根节点");
         return;
      }
      System.out.println("广度优先遍历：");
      ArrayDeque<TreeNode> ad = new ArrayDeque<>();
      ad.add(this.root);
      while(!ad.isEmpty()){
         TreeNode node = ad.remove();
         System.out.print(node.data+" ");
         if(node.leftNode!=null){
            ad.add(node.leftNode);
         }
         if(node.rightNode!=null){
            ad.add(node.rightNode);
         }
      }
   }
   /**
    * 先序 DLR
    */
   public void pre(TreeNode node){
      System.out.print(node.data+" ");
      if (node.leftNode!=null){
         this.pre(node.leftNode);
      }
      if (node.rightNode!=null){
         this.pre(node.rightNode);
      }
   }
   /**
    * 中序 LDR
    */
   public void middle(TreeNode node){
      if (node.leftNode!=null){
         this.middle(node.leftNode);
      }
      System.out.print(node.data+" ");
      if (node.rightNode!=null){
         this.middle(node.rightNode);
      }
   }
   /**
    * 后序 LRD
    */
   public void suffix(TreeNode node){
      if (node.leftNode!=null){
         this.suffix(node.leftNode);
      }
      if (node.rightNode!=null){
         this.suffix(node.rightNode);
      }
      System.out.print(node.data+" ");
   }
}
