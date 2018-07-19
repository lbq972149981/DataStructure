package Search;

import org.junit.Test;

public class AVLTree {
   private static String[] str = new String[]{"3","2","1","4","5"};
   private AVLTreeNode mRoot;
   class AVLTreeNode{
      String key;
      int height;
      AVLTreeNode left;
      AVLTreeNode right;
      public AVLTreeNode(String key, AVLTreeNode left, AVLTreeNode right) {
         this.key = key;
         this.height = 0;
         this.left = left;
         this.right = right;
      }
   }
   @Test
   public void test(){
      AVLTree tree = new AVLTree();
      for(String s:str){
         tree.mRoot = insert(tree.mRoot,s);
         System.out.print(s+" ");
      }
      System.out.println();
      System.out.println("前序遍历：");
      this.preOrder(tree.mRoot);
      System.out.println();
      System.out.println("中序遍历：");
      this.inOrder(tree.mRoot);
      System.out.println();
      System.out.println("后序遍历：");
      this.suffixOrder(tree.mRoot);
      System.out.println();
   }
   private void suffixOrder(AVLTreeNode tree){
      if(tree!=null){
         suffixOrder(tree.left);
         suffixOrder(tree.right);
         System.out.print(tree.key+" ");
      }
   }
   /**
    * 中序遍历
    * @param tree
    */
   private void inOrder(AVLTreeNode tree){
      if(tree!=null){
         inOrder(tree.left);
         System.out.print(tree.key+" ");
         inOrder(tree.right);
      }
   }

   /**
    * 先序遍历
    * @param tree
    */
   private void preOrder(AVLTreeNode tree){
      if(tree!=null){
         System.out.print(tree.key+" ");
         preOrder(tree.left);
         preOrder(tree.right);
      }
   }
   /**
    *
    * @param tree
    * @param key
    * @return
    */
   public AVLTreeNode insert(AVLTreeNode tree,String key){
      if(tree == null){
         tree = new AVLTreeNode(key,null,null);
      }else {
         int cmp = key.compareTo(tree.key);
         if(cmp<0){
            tree.left = insert(tree.left,key);
            if(height(tree.left)-height(tree.right)==2){
               if(key.compareTo(tree.left.key)<0){
                  tree = leftLeftRotation(tree);
               }else {
                  tree = leftRightRotation(tree);
               }
            }
         }else if(cmp > 0){
            tree.right = insert(tree.right,key);
            if(height(tree.right)-height(tree.left)==2){
               if(key.compareTo(tree.right.key)>0){
                  tree = rightRightRotation(tree);
               }else {
                  tree = rightLeftRotation(tree);
               }
            }
         }else {
            System.out.println("不能添加相同节点 ！");
         }
      }
      tree.height = max(height(tree.left), height(tree.right)) + 1;
      return tree;
   }
   /**
    * RL LL-RR
    * @param ka
    * @return
    */
   public AVLTreeNode rightLeftRotation(AVLTreeNode ka){
      ka.right = this.leftLeftRotation(ka.right);
      return rightRightRotation(ka);
   }

   /**
    * LR RR-LL
    * @param ka
    * @return
    */
   public AVLTreeNode leftRightRotation(AVLTreeNode ka){
      ka.left = this.rightRightRotation(ka.left);
      return leftLeftRotation(ka);
   }
   /**
    * 右右旋转 逆时针
    *
    *  A           B
    *   \         / \
    *    B       A   X
    *   / \       \
    *  C   X       C
    * @param ka
    * @return
    */
   public AVLTreeNode rightRightRotation(AVLTreeNode ka){//k2是A
      AVLTreeNode kb = null;
      kb = ka.right;
      ka.right = kb.left;
      kb.left = ka;
      //计算新节点高度
      ka.height = max(height(ka.left),height(ka.right))+1;
      kb.height = max(ka.height,height(kb.right))+1;
      return kb;
   }
   /**
    * 左左旋转 顺时针
    *
    *      A       B
    *     /       / \
    *    B       X   A
    *   / \         /
    *  X   C       C
    *
    * @param ka
    * @return 旋转后的根节点
    */
   public AVLTreeNode leftLeftRotation(AVLTreeNode ka){//k2是A
      AVLTreeNode kb = null;
      kb = ka.left;
      ka.left = kb.right;
      kb.right = ka;
      //计算新节点高度
      ka.height = max(height(ka.left),height(ka.right))+1;
      kb.height = max(ka.height,height(kb.left))+1;
      return kb;

   }
   private int height(AVLTreeNode treeNode){
      if(treeNode!=null){
         return treeNode.height;
      }
      return 0;
   }
   private int max(int a,int b){
      return a>b?a:b;
   }
   private AVLTreeNode minimum(AVLTreeNode tree) {
      if (tree == null){
         return null;
      }

      while(tree.left != null){
         tree = tree.left;
      }
      return tree;
   }
   private AVLTreeNode maximum(AVLTreeNode tree) {
      if (tree == null){
         return null;
      }

      while(tree.right != null){
         tree = tree.right;
      }
      return tree;
   }

}
