package org.bhavya.NPTEL.Java;

import java.util.Arrays;
import java.util.Scanner;

public class Week9Assignment3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = 5;
    int[][] mat = new int[n][n];
    for (int i = 0; i < n; i++) {
      String s = sc.nextLine();
      for (int j = 0; j < n; j++) {
        mat[i][j] = Integer.valueOf(s.substring(j,j+1));
      }
    }

    Arrays.stream(mat).forEach(integers -> {
      System.out.println();
      for (int integer : integers) {
        if (integer > 5) {
          System.out.print(integer + "\t");
        } else {
          System.out.print("0" + integer + "\t");
        }
      }
    });

    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = 4;
      }
    }
    Arrays.stream(res).forEach(integers -> {
      System.out.println();
      for (int integer : integers) {
        if (integer > 5) {
          System.out.print(integer + "\t");
        } else {
          System.out.print("0" + integer + "\t");
        }
      }
    });
    int x = n - 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i + j == x) {
          res[i][j] = mat[i][j];
        }
      }
      x--;
    }
    Arrays.stream(res).forEach(integers -> {
      System.out.println();
      for (int integer : integers) {
        if (integer > 5) {
          System.out.print(integer + "\t");
        } else {
          System.out.print("0" + integer + "\t");
        }
      }
    });
    x = n - 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i + j < x) {
          System.out.print(" ");
        } else {
          System.out.print(res[i][j] + " ");
        }
      }
      System.out.println();
      x--;
    }
    Arrays.stream(res).forEach(integers -> {
      System.out.println();
      for (int integer : integers) {
        if (integer > 5) {
          System.out.print(integer + "\t");
        } else {
          System.out.print("0" + integer + "\t");
        }
      }
    });
  }
}
  /*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer arr[][] = new Integer[5][5];
    for (int i = 0; i < 5; i++) {
      System.out.println();
      String s = sc.nextLine();
      for (int j = 0; j < 5; j++) {
//        arr[i][j] = Integer.parseInt("" + i + "" + j);

        arr[i][j] = Integer.valueOf(s.substring(j,j+1));
        System.out.print(arr[i][j] + " ");
      }

    }

    Integer[][] res = new Integer[5][5];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (i == j) {
          res[i][j] = arr[i + (arr.length / 2 - i)][j];
        }
        else if (j == arr.length / 2) {
          res[i][j] = arr[i][i];
        }
        else if ((i + j) == (arr.length - 1)) {
          res[i][j] = arr[i][i + (arr.length / 2 - i)];
        }
        else if (i == arr.length / 2) {
          res[i][j] = arr[arr.length - j - 1][j];
        }
        else if(i < arr.length / 2 && j < arr.length / 2){
          //1st quarter
          res[i][j] = arr[j][i];
          if(j==0){
            res[i][j] = arr[i+2][j];;
          }
        }
        else if(i < arr.length / 2 *//*&& j > arr.length / 2*//*){
          //arr.length / 2nd quarter
          if(j+1 >= arr.length){
            res[i][j] = arr[0][j-1];
          }else
          res[i][j] = arr[i][j-2];
        }
        else if(*//*i > arr.length / 2 &&*//* j > arr.length / 2){
          //3rd quarter
          if(i+1 >= arr.length){
            res[i][j] = arr[i-1][j+1];
          } else
          res[i][j] = arr[1][j];
        }
        else *//*if(i > arr.length / 2 && j < arr.length / 2)*//*{
          //4th quarter
          res[i][j] = arr[i][j+2];;
          if(j==0){
            res[i][j] = arr[i+1][j+1];;
          }
        }
      }
    }

    Arrays.stream(arr).forEach(integers -> {
      System.out.println();
      for (int i = 0; i < integers.length; i++) {
        if (integers[i] > 5) {
          System.out.print(integers[i] + "\t");
        } else {
          System.out.print("0" + integers[i] + "\t");
        }
      }
    });

    System.out.println(
        "\n**********************************************\n\t\tResult\n**********************************************\n");

    Arrays.stream(res).forEach(integers -> {
      System.out.println();
      for (int i = 0; i < integers.length; i++) {
        String s = integers[i] + "";
        if (integers[i] == null) {
          s = ("xx");
          if (i > 2) {
            s = (1 + integers[i - 1]) + "";
          }
        } else if (integers[i] < 5) {
          s = "0" + integers[i];
        }
        System.out.print(s + "\t");
      }
    });

    System.out.println(
        "\n**********************************************\n\t\tResult Final\n**********************************************\n");

    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        String s = res[i][j] + "";
        if (res[i][j] == null) {
          s = ("xx");
        } else if (res[i][j] < 5) {
          s = "0" + res[i][j];
        }
        System.out.print(s + "\t");
      }
      System.out.println();
    }
  }*/
/*
01234
10234
22034
33304
44440*/