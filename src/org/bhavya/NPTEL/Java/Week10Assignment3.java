package org.bhavya.NPTEL.Java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Week10Assignment3 {
  public static void main(String args[]) {
    try {
      Connection conn = null;
      Statement stmt = null;
      String DB_URL = "jdbc:sqlite:/tempfs/db";
      System.setProperty("org.sqlite.tmpdir", "/tempfs");
      conn = DriverManager.getConnection(DB_URL);
      System.out.print(conn.isValid(1));
      conn.close();
      System.out.print(conn.isClosed());
    }
    catch(Exception e){ System.out.println(e);}
  }
}
