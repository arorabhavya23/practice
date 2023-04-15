package org.bhavya.NPTEL.Java;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Week9Assignment5 {

  public static void main(String[] args) throws ScriptException {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String[] s = input.split("[+\\-/*]");
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String infix = "3+2*(4+5)";
    infix = "6 * 3";
    System.out.println(engine.eval(infix));
    System.out.println(engine.eval(input));
  }

}
