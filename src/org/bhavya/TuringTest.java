package org.bhavya;

import java.util.Scanner;
import java.util.Stack;

public class TuringTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    if (isValid(s)) {
      System.out.println("valid");
    } else {
      System.out.println("invalid");
    }
  }

  public static boolean isValid(String s) {
    int size = s.length();
    Stack<Character> brackets = new Stack<>();
    if (size % 2 != 0) {
      return false;
    }
    while (size > 0) {
      size--;
      var bracket = s.charAt(size);
      switch (bracket) {
        case ')':
        case '}':
        case ']':
          brackets.push(bracket);
          break;
        case '(':
          if (brackets.pop() != ')')
            return false;
          break;
        case '{':
          if (brackets.pop() != '}')
            return false;
          break;
        case '[':
          if (brackets.pop() != ']')
            return false;
          break;
      }
    }
    return true;
  }
}
