package org.bhavya.practice;

public class NumberOfIslands {

  public static void main(String[] args) {
    int mat[][] =  {{1, 1, 0, 0, 0},
                    {0, 1, 0, 0, 1},
                    {1, 0, 0, 1, 1},
                    {0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 1}};

    int result = findNumberOFIslands(mat);
    System.out.println(result);
  }

  private static int findNumberOFIslands(int[][] map) {
    int count = 0;
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] != 0) {
          move(map, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private static boolean canMove(int[][] map, int i, int j) {
    return i >= 0 && j >= 0 && i < map.length && j < map[0].length && map[i][j] == 1;
  }

  private static void move(int[][] map, int i, int j) {
    int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
    map[i][j] = 0;
    for (int k = 0; k < 8; k++) {
      if (canMove(map, i + rowNbr[k], j + colNbr[k])) {
        move(map, i + rowNbr[k], j + colNbr[k]);
      }
    }

  }

}
