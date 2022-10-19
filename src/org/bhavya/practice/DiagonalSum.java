package org.bhavya.practice;

import com.sun.source.doctree.SeeTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DiagonalSum {


  static Integer rightDiagonalSum(List<List<Integer>> input) {
    Integer sum = 0;
    for (int i = input.size() - 1, j = 0; i >= 0; i--, j++) {
      sum += input.get(i).get(j); // intput.get(2).get(0) 5, -3, 9
    }
    return sum;
  }

  static List<Integer> findMissingNumber(List<Integer> input) {
    input = input.stream().sorted().collect(Collectors.toList());
    var i = 50;
    var index = input.size() - 1;
    List<Integer> output = new ArrayList<>();
    while (i > 0) {
      if (index >= 0 && i == input.get(index)) {
        index--;
      } else {
        output.add(i);
      }
    i--;
  }
    return output;
}
  //    i am a software engineer and i have done my engineering in pune and i am working in software industry in pune
static Set<String> findDubplicateWords(String input){
    String[] inputString = input.split(" ");
    String[] uniqueWords = new String[inputString.length];
    Set<String> output = new HashSet<>();
  uniqueWords[0] = inputString[0];
  for (int i = 1; i < inputString.length; i++) {
    var flag = false;
    int j = 0;
    for(; j < uniqueWords.length; j++){
      if(uniqueWords[j].equals(inputString[i])){
        flag = true;
        break;
      }
    }
    if(flag){
      output.add(inputString[i]);
    } else
    uniqueWords[j] = inputString[i];
  }
    return output;
}


  public static void main(String[] args) {
    List<List<Integer>> input = new ArrayList<>();

    input.add(Arrays.asList(2, 4, 5));
    input.add(Arrays.asList(6, -3, 8));
    input.add(Arrays.asList(9, 4, 5));

//    System.out.println(rightDiagonalSum(input));
    System.out.println(findMissingNumber(Arrays.asList(33, 27, 5, 8, 44, 24)));
  }

}

//{33,27,5,8,44,24}

//output missing numbers in decending order 1,2,3,4,6,7,9.....
//

//find missing number from 1-50
//arrage in decending order.

//--------------------------------------------------------
//--------------------------------------------------------
// [11:36 AM] ajit sandbhor
//    i am a software engineer and i have done my engineering in pune and i am working in software industry in pune


//  find dubplicate words for the same