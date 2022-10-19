package org.bhavya.practice;

import static java.lang.Math.max;
import static java.util.List.of;

import java.util.LinkedList;
import java.util.List;

public class GameOfGenerals {

  public static Integer maximumPlayers(Integer k, LinkedList<List<Integer>> playerTimeList){
    var maxCount = 0;
    k = k-1;
    while (!playerTimeList.isEmpty()) {
      var player1Time = playerTimeList.getFirst();
      Integer start1 = player1Time.get(0);
      Integer end1 = player1Time.get(1);
      var count = 0;
      if(k > (end1 - start1)){
        playerTimeList.remove(player1Time);
        continue;
      }
      var i = 0;
      while(i < playerTimeList.size()) {
        var playerTime = playerTimeList.get(i);
        i++;
        var end = playerTime.get(1);
        var start = playerTime.get(0);
        if (k <= (end - start)) {
          if ((start1 >= start && start1 + k <= end) || (start1 <= start && start + k < end1)) {
            count++;
          }
        } else {
          playerTimeList.remove(playerTime);
          i--;
        }
      }
      playerTimeList.remove(player1Time);
      maxCount = max(count, maxCount);
      if(playerTimeList.size() <= maxCount){
        break;
      }
    }
    return maxCount;
  }


  public static void main(String[] args) {
    LinkedList<List<Integer>> inputList = new LinkedList<>();
    inputList.add(of(1,2));
    inputList.add(of(3,4));
    System.out.println(maximumPlayers(5, inputList));
    System.out.println(inputList.removeAll(inputList));
    inputList.add(of(1,3));
    inputList.add(of(6,7));
    inputList.add(of(1,5));
    System.out.println(maximumPlayers(3, inputList));
    System.out.println(inputList.removeAll(inputList));
    inputList.add(of(2,5));
    inputList.add(of(8,15));
    inputList.add(of(5,7));
    System.out.println(maximumPlayers(3, inputList));
    System.out.println(inputList.removeAll(inputList));
  }

}

/*
while (!playerTimeList.isEmpty()) {
      var player1Time = playerTimeList.getFirst();
      Integer start1 = null;
      Integer end1 = null;
      if(playerTimeList.size() == 1){
        playerTimeList.remove();
        break;
      }

      for (List<Integer> playerTime : playerTimeList) {

        var end = playerTime.get(1);
        var start = playerTime.get(0);
        if(player1Time.equals(playerTime)){
          start1 = start;
          end1 = end;
          continue;
        }
        if (k <= (end - start)) {
          //check this start end meets with the first start end
              // then increase the count
              // remove the element
          // remove first element`
          if(start1 != null){
            if ((start1 >= start && start1 + k <= end) || (start1 <= start && start + k < end1)){
              count++;
              start1 = null;
              end1 = null;
              playerTimeList.remove(playerTime);
              playerTimeList.remove(player1Time);
            }
          }
          else{
            player1Time = playerTime;
            start1 = start;
            end1 = end;
          }
        } else {
          playerTimeList.remove(playerTime);
        }
      }
    }
 */
