package org.bhavya.practice;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class One {
// long text paragraph, plindromes in the text and the largest palindrom in the text arora. 123454321 in t ni

  public Integer checkForPlindrome(String word){
    // check for plaindrme and return the length
    var size = word.length();
    for(int i = 0; i < size/2; i++){
      if(word.charAt(i) != word.charAt(size - (i+1))){
        return 0;
      }
    }
    return size;
  }

  public String findTheLongestPlaindrome(String paragraph){
    //Split the para with space
    // check if the last chraracter is not a punctuation
    // call check plindrome and check if thats the max length.
    String[] paraArr = paragraph.split(" ");
    Integer maxlenPlaindrom = 0;
    String maxPlaindrom = "";
    for(String para: paraArr) {
      var word = para.matches("(.|,|!).$") ? para.substring(0, para.length() - 2) : para;
      var plainLen = checkForPlindrome(word);

      if(plainLen > maxlenPlaindrom) {
        maxlenPlaindrom = plainLen;
        maxPlaindrom = word;
      }
    }

    return maxPlaindrom;
  }


// codeshare with in te et ni google meet at noon  in te et ni gooooogle


  public Integer checkPlaindromOutwords(int index, String paragraph){
    var j = index + 1;
    var plaindromLen = 0;
    for(int i = index-1; i >= 0; i--){// o d e s a

      if(j >= paragraph.length() || paragraph.charAt(i) != paragraph.charAt(j++)){// c != d o,e e,e t,t  ,  n,n i,i  ,  h,g
        break;
      }
      plaindromLen++;
    }
    return plaindromLen;
  }
}
