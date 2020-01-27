package ch.bbw.df;

public class Main {

    public static void main(String[] args) {
      var tree = new BinaryTree();
      tree.add(10);
      tree.add(2);
      tree.add(1);
      tree.add(0);
      tree.add(3);
      tree.add(5);
      tree.add(12);
      tree.add(11);
      tree.add(13);
      tree.add(14);

      tree.traverseInOrder();
    }
}
