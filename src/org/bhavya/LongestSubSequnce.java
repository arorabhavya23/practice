package org.bhavya;

import java.util.Arrays;
import java.util.List;

public class LongestSubSequnce {

  /**
   * 2 string
   * a z b h z o c o
   * a b h o z r p k    a
   *
   * skip but not come back
   * b h z
   * a b h o
   *
   WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS

   FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC

   length to be returned

   // split this to array to chars
   //
   */

  public static void main(String[] arg){
//    System.out.println(subsequnce("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
    System.out.println(subsequnce("azbhzoco","abhozrpk"));
  }

  public static int subsequnce(String s1, String s2){
    var maxSubSeq = 0;

    List<String> str1 = Arrays.asList(s1.split(""));
    List<String> str2 = Arrays.asList(s2.split(""));
    var seq = 0;
    while(str1.size()>0) {
      for (int i = 0; i < str1.size(); i++) {
        for (int j = i; j < str2.size(); j++) {
          if (str1.get(i).equals(str2.get(j))) {
            seq++;
            break;
          }
        }
      }
      if (seq > maxSubSeq) {
        maxSubSeq = seq;
      }
      str1 = str1.subList(1, str1.size());
      seq = 0;
    }



    return maxSubSeq;
  }



}
