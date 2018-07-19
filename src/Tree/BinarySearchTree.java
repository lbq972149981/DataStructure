package Tree;

import org.junit.Test;

/**
 * 二叉排序树
    1.若他的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
    2.若他的右子树不空，则右子树上所有节点的值均大于它的根节点的值。
    3.它的左、右子树也分别为排序二叉树。
*/
 /*  如果x没有左孩子，则x有以下两种可能：
      1.x是一个右孩子，则x的前驱节点为它的父节点
      2.x是一个左孩子，则查找x的最低的父节点，并且该节点要具有右孩子(因为都比他大)，
      找到的这个最低的父节点就是x的前驱节点
      其实就是，该节点左子树为空, 则其前驱为：其祖先节点(递归), 且该祖先节点的右孩子也是其祖先节点
      通俗的说，一直往上找找到最后出现左拐那次后的祖先节点;
*/
public class BinarySearchTree {
   public BSNode root;
   @Test
   public void test(){
      int[] arr = {1,5,4,3,2,6};
      /*
                1
                 \
                  5
                /   \
               4     6
              /
             3
            /
           2
       */
      for(int i=0;i<arr.length;i++){
         BSNode bsNode = new BSNode(arr[i]+"",null,null,null);
         this.insert(bsNode);
      }
      BSNode node = this.search(this.root,arr[1]+"");
      this.dele(this,node);
      this.postOrder(this.root);
      System.out.println();
      this.preOrder(this.root);
      System.out.println();
      this.inOrder(this.root);
   }
   public void preOrder(BSNode bsNode){
      if(bsNode!=null){
         System.out.print(bsNode.key+" ");
         preOrder(bsNode.left);
         preOrder(bsNode.right);
      }
   }
   public void inOrder(BSNode bsNode){
      if(bsNode!=null){
         inOrder(bsNode.left);
         System.out.print(bsNode.key+" ");
         inOrder(bsNode.right);
      }
   }
   public void postOrder(BSNode bsNode){
      if(bsNode!=null){
         postOrder(bsNode.left);
         postOrder(bsNode.right);
         System.out.print(bsNode.key+" ");
      }
   }
   public BSNode search(BSNode x,String key){
      if(x == null){
         return null;
      }
      int r = key.compareTo(x.key);
      if(r>0){
        return search(x.right,key);
      }else if(r<0){
        return search(x.left,key);
      }else {
         return x;
      }
   }
   /*
	 * 删除节点z，并返回被删除的节点
	 * bst：二叉树
	 * z删除的节点
	 * 1.没有儿子，即为叶结点。直接把父结点的对应儿子指针设为NULL，就OK了。
	   2.只有一个儿子。那么把父结点的相应儿子指针指向儿子的独生子，删除儿子结点也OK了。
	   3.有两个儿子。这是最麻烦的情况，因为你删除节点之后，还要保证满足搜索二叉树的结构。其实也比较容易，
	   我们可以选择左儿子中的最大元素或者右儿子中的最小元素放到待删除节点的位置，就可以保证结构的不变。
	   当然，你要记得调整子树，毕竟又出现了节点删除。习惯上大家选择左儿子中的最大元素，其实选择右儿子的最小元素也一样，
	   没有任何差别，只是人们习惯从左向右。这里咱们也选择左儿子的最大元素，将它放到待删结点的位置。
	   左儿子的最大元素其实很好找，只要顺着左儿子不断的去搜索右子树就可以了，直到找到一个没有右子树的结点。那就是最大的了。
	 */
   /**
    *
    * @param binarySearchTree 要删除的节点所在的树
    * @param bsNode 要删除的节点
    * @return 返回被删除的节点
    */
   public BSNode dele(BinarySearchTree binarySearchTree,BSNode bsNode){
      BSNode x = null;
      BSNode y = null;
      if(bsNode.left==null||bsNode.right ==null){//没有左子或没有右子
         y = bsNode;
      }else { //既有左子又有右子
         y = this.suf(bsNode); //找到后继节点
      }
      if(y.left!=null){
         x = y.left;
      }
      if(y.right!=null){
         x = y.right;
      }
      if(x!=null){   //有左子或右子
         x.parent = y.parent;
      }
      if(y.parent==null){  //y就是根节点
         this.root = x;    //y就是根节点，那么y没了 ，直接替补的就是x
      }else if(y == y.parent.left){//y是否是y的父节点的左子节点，如果为真，y为被删除节点的后继节点。
         y.parent.left = x;
      }else {
         y.parent.right = x;
      }
      if(y!=bsNode){
         bsNode.key = y.key;
      }
      return y;
   }
   /**
    *
    * @param bsNode 要插入的节点
    */
   public void insert(BSNode bsNode){
      BSNode x = this.root;
      BSNode y = null;
      while(x!=null){ //已经有根节点
         y = x; //y为退出循环的叶子节点，即为新节点的父亲节点
         int r = bsNode.key.compareTo(x.key);
         if(r>0){
            x = x.right;
         }else if(r<0){
            x = x.left;
         }else {
            System.out.println("二叉排序树不可以有相同的值");
            return;
         }
      }
      bsNode.parent = y;
      if(y==null){
         this.root = bsNode;
      }else {
         int r = bsNode.key.compareTo(y.key);
         if(r>0){
            y.right = bsNode;
         }else if(r<0){
            y.left = bsNode;
         }else {
            System.out.println("二叉排序树不可以有相同的值");
            return;
         }
      }
   }
   /**
    *
    * @param bsNode 要查的节点
    * @return 返回该节点后继节点
    */
   public BSNode suf(BSNode bsNode){
      if(bsNode.right!=null){
         return this.minimum(bsNode.right);
      }
      BSNode bsNodeparent = bsNode.parent;
      while(bsNodeparent!=null&&bsNode==bsNodeparent.right){
         bsNode = bsNodeparent;
         bsNodeparent = bsNodeparent.parent;
      }
      return bsNodeparent;
   }
   /**
    * 查找该节点(x)的前驱节点，即查找二叉树中数据值小于该节点的最大节点
    * @param bsNode 该节点
    * @return 返回该节点的前驱节点
    */
   public BSNode pre(BSNode bsNode){
      //如果x存在左孩子，则x的前驱节点为-以其左孩子为根的子树的最大节点
      if(bsNode.left!=null){
         maximum(bsNode.left);
      }
      if(bsNode.left==null&&bsNode.parent==null){
         System.out.println("没有前驱节点");
         return null;
      }
      BSNode bsNodeparent=bsNode.parent;//把父亲取出来，如果不是左孩子，就是右孩子(y就是其前驱)，
      while((bsNodeparent!=null)&&(bsNode==bsNodeparent.left)){//x是左孩子
         bsNode=bsNodeparent;
         bsNodeparent=bsNodeparent.parent;
      }
      return bsNodeparent;
   }
   /**
    *
    * @param bsNode 当前节点
    * @return  返回当前子节点下的最小节点
    */
   public BSNode minimum(BSNode bsNode){
      if(bsNode==null){
         return null;
      }
      while(bsNode.left!=null){
         bsNode = bsNode.left;
      }
      return bsNode;
   }
   /**
    *
    * @param bsNode 当前节点
    * @return  返回当前子节点下的最大节点
    */
   public BSNode maximum(BSNode bsNode){
      if(bsNode==null){
         return null;
      }
      while(bsNode.right!=null){
         bsNode = bsNode.right;
      }
      return bsNode;
   }
   public class BSNode{
      String key;
      BSNode left;
      BSNode right;
      BSNode parent;
      public BSNode(String key, BSNode left, BSNode right, BSNode parent) {
         this.key = key;
         this.left = left;
         this.right = right;
         this.parent = parent;
      }
   }
}
