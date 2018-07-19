package colin.sort;

public class treeTest {
   public static void main(String[] args) {
      myBinarySearchTree<Integer,String> binarySearchTree = new myBinarySearchTree<>();
      binarySearchTree.add(11,"bnmuyi");
      binarySearchTree.add(2,"asdff");
      binarySearchTree.add(21,"aqwe");
      binarySearchTree.add(48,"xcv111111111");
      binarySearchTree.add(16,"asdf");
      binarySearchTree.add(55,"wetrt");
      binarySearchTree.add(14,"nbmhm");
      binarySearchTree.add(26,"sd");
      PrintTree.pirnt(binarySearchTree.getRoot());
      System.out.println(binarySearchTree.search(14));
      binarySearchTree.preOrder();
      binarySearchTree.sufOrder();
      binarySearchTree.postOrder();
      binarySearchTree.levelOrderTraversal();
   }
}
