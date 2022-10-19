package org.bhavya.practice;

public class MyPractice {

  private static String reverseMyString(String inputString) {
    StringBuilder sb = new StringBuilder();
    for (int i = inputString.length() - 1; i >= 0; i--) {
      sb.append(inputString.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverseMyString("THIS IS HELLO WORLD!!"));
    int i = 300, n = 150;
    int c = 0;
    while (i >= n) {
      i = i - 2;
      n = n + 1;
      c++;
    }
    System.out.println(c);
  }
}
