package ch.bbw.df;

public class BinaryTree {
  private Node root;

  public void add(int value) {
    if(root == null) {
      root = new Node(value);
    } else {
      root.add(value);
    }
  }

  public void traversePreOrder() {
    if(root == null) return;
    root.traversePreOrder();
  }

  public void traverseInOrder() {
    if(root == null) return;
    root.traverseInOrder();
  }

  public void traversePostOrder() {
    if(root == null) return;
    root.traversePostOrder();
  }
}
