package Tree;

import org.junit.Test;

/**
 * 二叉树--二叉链表存储
 */
public class TwoLinkBinTree {
   public static class TreeNode{
      private String data;
      private TreeNode left;
      private TreeNode right;
      public TreeNode(){

      }
      public TreeNode(String data){
         this.data = data;
      }
      public TreeNode(String data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
      }
   }
   private TreeNode root;

   /**
    *
    * @param parent
    * @param data
    * @param isLeft
    * @return
    */
   public TreeNode addNode(TreeNode parent,String data,boolean isLeft){
      if(parent==null){
         System.out.println("无该父节点，不能增加子节点");
         return null;
      }
      if(isLeft&&parent.left!=null){
         System.out.println("左子节点已经存在,不能再添加左孩子");
         return null;
      }
      if(!isLeft&&parent.right!=null){
         System.out.println("右子节点已经存在,不能再添加右孩子");
         return null;
      }
      TreeNode node = new TreeNode(data);
      if(isLeft){
         parent.left = node;
      }else {
         parent.right = node;
      }
      return node;
   }

   /**
    *
    * @param parent 要查询的父节点
    * @return 返回其左子节点
    */
   public String leftChild(TreeNode parent){
      if(parent==null){
         System.out.println("该父节点不存在");
         return null;
      }
      if(parent.left!=null){
         return parent.left.data;
      }
      return null;
   }
   /**
    *
    * @param parent 要查询的父节点
    * @return 返回其右子节点
    */
   public String rightChild(TreeNode parent){
      if(parent==null){
         System.out.println("该父节点不存在");
         return null;
      }
      if(parent.right!=null){
         return parent.right.data;
      }
      return null;
   }

   public int deep(TreeNode node){
      if(node==null){
         return 0;
      }
      if(node.left==null&&node.right==null){
         return 1;
      }
   /*
           root
           / \
          A   B
         / \
        C   D
   */
      else {
         int leftDeep = deep(node.left);
         int rightDeep = deep(node.right);
         int max = 0;
         max = leftDeep>rightDeep?leftDeep:rightDeep;
         return ++max;
      }
   }
   public TreeNode init(String data){
      this.root = new TreeNode(data);
      return this.root;
   }
   /*
            root
            / \
           A   B
          / \
         C   D
    */
   @Test
   public void test(){
      TreeNode root = init("root");
      TreeNode A = this.addNode(root,"A",true);
      TreeNode B = this.addNode(root,"B",false);
      TreeNode C = this.addNode(A,"C",true);
      TreeNode D = this.addNode(A,"D",false);
      System.out.println(this.leftChild(A));
      System.out.println(this.rightChild(A));
      System.out.println(this.deep(A));

   }
}
