package colin.sort;

import java.util.ArrayDeque;

public class myBinarySearchTree<K extends Comparable<K>,V>{
   private Node root;
   private int size;

   public void add(K key,V value){
      root = add(root,key,value);
      size++;
   }

   /**
    * 添加
    * @param root
    * @param key
    * @param value
    * @return
    */
   private Node add(Node root, K key, V value) {
      if(null==root){
         return new Node(key,value);
      }
      if(root.key.compareTo(key)==0){
         root = add(root,key,value);
      }else if(root.key.compareTo(key)>0){
         root.leftNode = add(root.leftNode,key,value);
      }else {
         root.rightNode = add(root.rightNode,key,value);
      }
      return root;
   }
   /**
    * 搜索
    * @param key
    * @return
    */
   public V search(K key){
      if(size==0) return null;
      return search(root,key);
   }
   private V search(Node root, K key) {
      if(null == root){
         return null;
      }
      if(root.key.compareTo(key)==0){
         return root.value;
      }else if(root.key.compareTo(key)>0){
         return search(root.leftNode,key);
      }else {
         return search(root.rightNode,key);
      }
   }
   /**
    * 广度优先遍历
    */
   public void levelOrderTraversal(){
      System.out.println("广度优先遍历：");
      levelOrderTraversal(root);
      System.out.println();
   }

   private void levelOrderTraversal(Node root) {
      ArrayDeque<Node> nodes = new ArrayDeque<>();
      nodes.add(root);
      while(!nodes.isEmpty()){
         Node node = nodes.remove();
         System.out.print(node.key+" ");
         if(node.leftNode!=null){
            nodes.add(node.leftNode);
         }
         if(node.rightNode!=null){
            nodes.add(node.rightNode);
         }
      }
   }

   /**
    * 先序遍历
    */
   public void preOrder(){
      System.out.println("先序遍历:");
      preOrder(root);
      System.out.println();
   }
   public void preOrder(Node node){
      if (node!=null){
         System.out.print(node.key+" ");
         preOrder(node.leftNode);
         preOrder(node.rightNode);
      }
   }

   /**
    * 中序遍历
    */
   public void sufOrder(){
      System.out.println("中序遍历:");
      sufOrder(root);
      System.out.println();
   }
   public void sufOrder(Node node){
      if (node!=null){
         sufOrder(node.leftNode);
         System.out.print(node.key+" ");
         sufOrder(node.rightNode);
      }
   }

   /**
    * 后序遍历
    */
   public void postOrder(){
      System.out.println("后序遍历:");
      postOrder(root);
      System.out.println();
   }
   public void postOrder(Node node){
      if (node!=null){
         postOrder(node.leftNode);
         postOrder(node.rightNode);
         System.out.print(node.key+" ");
      }
   }
   public Node getRoot() {
      return root;
   }
   public int size() {
      return size;
   }
   public class Node{
      private K key;
      private V value;
      private Node leftNode;
      private Node rightNode;

      public Node(K key, V value) {
         this.key = key;
         this.value = value;
      }

      @Override
      public String toString() {
         return key.toString();
      }

      public K getKey() {
         return key;
      }

      public void setKey(K key) {
         this.key = key;
      }

      public V getValue() {
         return value;
      }

      public void setValue(V value) {
         this.value = value;
      }

      public Node getLeftNode() {
         return leftNode;
      }

      public void setLeftNode(Node leftNode) {
         this.leftNode = leftNode;
      }

      public Node getRightNode() {
         return rightNode;
      }

      public void setRightNode(Node rightNode) {
         this.rightNode = rightNode;
      }
   }
}
