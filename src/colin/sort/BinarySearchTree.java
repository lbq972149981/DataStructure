package colin.sort;

public class BinarySearchTree<K extends Comparable<K>,V>{
   private Node root;
   private int size;
   public void add(K key,V value){
      root = addNode(root,key,value);
      size++;
   }
   private Node addNode(Node root, K key, V value) {
      if(null==root) {
         return new Node(key, value);
      }
      if(root.key.compareTo(key)==0){
         root = addNode(root,key,value);
      }else if(root.key.compareTo(key)>0){
         root.leftNode = addNode(root.leftNode,key,value);
      }else {
         root.rightNode = addNode(root.rightNode,key,value);
      }
      return root;
   }
   public V search(K key){
      if(size==0)return null;
      return search(root,key);
   }

   private V search(Node node, K key) {
      if(null==node){
         return null;
      }
      if(node.key.compareTo(key)==0){
         return node.value;
      }else if(node.key.compareTo(key)>0){
         return search(node.leftNode,key);
      }else {
         return search(node.rightNode,key);
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
      @Override
      public String toString() {
         return "Node{" +
               "key=" + key +
               ", value=" + value +
               '}';
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
      public Node(K key, V value) {
         this.key = key;
         this.value = value;
      }
   }
}
