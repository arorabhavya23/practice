package org.bhavya.practice;

class some{
  public void display(String a){
    String b = "yash";
    String c = "yash";
    System.out.println(Integer.toHexString(System.identityHashCode(a)));      //6a5fc7f7
    System.out.println(Integer.toHexString(System.identityHashCode(b)));      //3b6eb2ec
    System.out.println(Integer.toHexString(System.identityHashCode(c)));      //3b6eb2ec
    System.out.println("yash".equals("yash"));    //  true
    System.out.println(a.equals(b));              //  true
    System.out.println("yash" == "yash");         //  true
    System.out.println(a == b);                   //  true


  }
}
