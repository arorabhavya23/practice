package org.bhavya;

public class BinaryTree {
  public Integer value;
  public BinaryTree leftNode;
  public BinaryTree rightNode;

  public BinaryTree(Integer value){
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }
  static int COUNT = 10;

  public static void printTree(BinaryTree root, int space)
  {
    // Base case
    if (root == null)
      return;

    // Increase distance between levels
    space += COUNT;

    // Process right child first
    printTree(root.rightNode, space);

    // Print current node after space
    // count
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
      System.out.print(" ");
    System.out.print(root.value + "\n");

    // Process left child
    printTree(root.leftNode, space);
  }

}
