package org.bhavya.NPTEL.Java;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Week9Assignment4 {
  public static void main(String args[]) throws ScriptException {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length()-1; i++) {
        if(input.charAt(i) == 'l'){
          sb.append("*");
        }else
          sb.append(gui_map(input.charAt(i)));
    }
    if(input.charAt(input.length()-1) == 'c') {
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("JavaScript");

      Integer u = (Integer) engine.eval(String.valueOf(sb));
      Double d = Double.valueOf(u);
      System.out.println(d);
    }

  }// The main() method ends here.

  // A method that takes a character as input and returns the corresponding GUI character
  static char gui_map(char in){
    char out = 'N';// N = Null/Empty
    char gm[][]={{'a','.'}
        ,{'b','0'}
        ,{'c','='}
        ,{'d','+'}
        ,{'e','1'}
        ,{'f','2'}
        ,{'g','3'}
        ,{'h','-'}
        ,{'i','4'}
        ,{'j','5'}
        ,{'k','6'}
        ,{'l','X'}
        ,{'m','7'}
        ,{'n','8'}
        ,{'o','9'}
        ,{'p','/'}};

    // Checking for maps
    for(int i=0; i<gm.length; i++){
      if(gm[i][0]==in){
        out=gm[i][1];
        break;
      }
    }
    return out;
  }
}
