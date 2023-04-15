package org.bhavya.NPTEL.Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Week10Assignment4 {

  public static void main(String args[]) {
    try {
      Connection conn = null;
      Statement stmt = null;
      String DB_URL = "jdbc:sqlite:/tempfs/db";
      System.setProperty("org.sqlite.tmpdir", "/tempfs");

      // Open a connection
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();

      String query = "create table PLAYERS("
          + "UID INTEGER, "
          + "First_Name VARCHAR(45), "
          + "Last_Name NUMBER(45), "
          + "Age INTEGER)";
      stmt.execute(query);

      //close connection
      stmt.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
