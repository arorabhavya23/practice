package org.bhavya;

import java.util.List;
import java.util.Scanner;

public class SolutionHackerRankD15 {

  public static Node insert(Node head, int data) {
    int x[] = new int[10];
    int[] u  = new int[10];
    float[] d = {1,2,3};
    int[] a = {1,2,3};
    int[] b;
    b = a;

    //Complete this method
    Node nextElement = new Node(data);
    if(head == null) {
      return nextElement;
    }
    Node last = head;
    while(last.next != null)
      last = last.next;
    last.next = nextElement;

    return head;
  }

  public static void display(Node head) {
    Node start = head;
    while (start != null) {
      System.out.print(start.data + " ");
      start = start.next;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Node head = null;
    int N = sc.nextInt();

    while (N-- > 0) {
      int ele = sc.nextInt();
      head = insert(head, ele);
    }
    display(head);
    sc.close();
  }
}

class Node {

  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

//Write your code here
class Calculator {
  public int power(int n,  int p) throws Exception{
    if(n < 0 || p < 0){
      throw new Exception("n and p should be non-negative");
    }
    return (int) Math.pow(n, p);
  }

  public Integer sumOfList(List<Integer> myList){
    Integer sum = 0;
    return myList.stream().mapToInt(value -> value).sum();
  }
}
class Solutions{

  public static void main(char args) {
    System.out.println("kjhjhbj");
  }
    public static void main (String[] args) {

//    Scanner in = new Scanner(System.in);
//    int t = in.nextInt();
//    while (t-- > 0) {
//
//      int n = in.nextInt();
//      int p = in.nextInt();
//      Calculator myCalculator = new Calculator();
//      try {
//        int ans = myCalculator.power(n, p);
//        System.out.println(ans);
//      }
//      catch (Exception e) {
//        System.out.println(e.getMessage());
//      }
//    }
//    in.close();
    one o = new two();
    o.foo();
  }
}
 class one{
   void foo() {
     System.out.println("one");
   }
}

class two extends one{
  void foo(){
    System.out.println("two");
  }
}


