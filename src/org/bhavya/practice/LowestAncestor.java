package org.bhavya.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bhavya.BinaryTree;

/*
        1
    2        3
 4  5      6     7
         8  9
 */

public class LowestAncestor {

  private static List<BinaryTree> binTree = new ArrayList<>();
  private static List<String> binTreePos = new ArrayList<>();

  private static BinaryTree findLowestAncestor(BinaryTree root,
      Integer one, Integer two) {
    BinaryTree lowestAncestor = null;
    getInorderList(root, "root");
    for (int i = 0; i < binTreePos.size(); i++) {
      System.out.println(binTree.get(i).value + " " + binTreePos.get(i));
    }

    var found = 0;

    for (int i = 0; i < binTree.size(); i++) {
      if (found == 1 && binTreePos.get(i).equals("root")) {
        lowestAncestor = binTree.get(i);
        break;
      }
      if (one.equals(binTree.get(i).value) || two.equals(binTree.get(i).value)) {
        found++;
        if (binTreePos.get(i).equals("left")) {
          //find its parent ahead of it
          for (int j = i + 1; j < binTree.size(); j++) {
            if (binTree.get(j).value < binTree.get(i).value) {
              var curr = binTree.get(j);
              lowestAncestor = lowestAncestor == null ? curr
                  : curr.value < lowestAncestor.value ? curr : lowestAncestor;
              break;
            }
          }
        } else if (binTreePos.get(i).equals("right")) {
          //find its parent behind it
          for (int j = i - 1; j >= 0; j--) {
            if (binTree.get(j).value > binTree.get(i).value) {
              var curr = binTree.get(j);
              lowestAncestor = lowestAncestor == null ? curr
                  : curr.value < lowestAncestor.value ? curr : lowestAncestor;
              break;
            }
          }
        }
      }
      if (found == 2) {
        break;
      }
      if (found == 1 && binTreePos.get(i).equals("root")) {
        lowestAncestor = binTree.get(i);
        break;
      }

    }
    return lowestAncestor;
  }

  private static void getInorderList(BinaryTree root, String side) {
    if (root == null) {
      return;
    }
    getInorderList(root.leftNode, "left");
    binTree.add(root);
    binTreePos.add(side);
//    System.out.println(root.value + " " + side);
    getInorderList(root.rightNode, "right");
  }


  public static BinaryTree insert(BinaryTree root, int data) {
    if (root == null) {
      return new BinaryTree(data);
    } else {
      BinaryTree cur;
      if (data <= root.value) {
        cur = insert(root.leftNode, data);
        root.leftNode = cur;
      } else {
        cur = insert(root.rightNode, data);
        root.rightNode = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    BinaryTree root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    BinaryTree.printTree(root, 0);
    BinaryTree ans = findLowestAncestor(root, v1, v2);
    System.out.println(ans.value);
  }	

  /*public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1);
    root.leftNode = new BinaryTree(2);
    root.rightNode = new BinaryTree(3);

    root.leftNode.leftNode = new BinaryTree(4);
    root.leftNode.rightNode = new BinaryTree(5);
    root.rightNode.leftNode = new BinaryTree(6);
    root.rightNode.rightNode = new BinaryTree(7);

    root.rightNode.leftNode.leftNode = new BinaryTree(8);
    root.rightNode.leftNode.rightNode = new BinaryTree(9);
//    BinaryTree.printTree(root, 0);
//    findLowestAncestor(root, 4, 5);
    System.out.println(
        findLowestAncestor(root, 6, 1).value);
  }*/

  //ds algo
  // lld


}
