package ch.bbw.df;

public class Node {
  public Node(int value) {
    this.value = value;
  }

  private Node left;
  private Node right;
  private final int value;

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public int getValue() {
    return value;
  }

  public void add(int value) {
    if(value <= this.value) {
      if(left == null) {
        left = new Node(value);
      } else {
        left.add(value);
      }
    } else {
      if(right == null) {
        right = new Node(value);
      } else {
        right.add(value);
      }
    }
  }

  public void traversePreOrder() {
    System.out.println(value);
    if(left != null) {
      left.traversePreOrder();
    }
    if(right != null) {
      right.traversePreOrder();
    }
  }

  public void traverseInOrder() {
    if(left != null) {
      left.traverseInOrder();
    }
    System.out.println(value);
    if(right != null) {
      right.traverseInOrder();
    }
  }

  public void traversePostOrder() {
    if(left != null) {
      left.traversePostOrder();
    }
    if(right != null) {
      right.traversePostOrder();
    }
    System.out.println(value);
  }
}
