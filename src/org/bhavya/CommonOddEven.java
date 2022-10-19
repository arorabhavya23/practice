package org.bhavya;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonOddEven {

  public static void main(String[] args) {
    var a = List.of(1, 2, 3, 4, 5, 6);
    var b = List.of(2, 5, 6, 8, 9, 0);
    System.out.println(common(a, b));
    System.out.println(odd(a, b));
    System.out.println(even(a, b));
  }

  private static List<Integer> common(List<Integer> a, List<Integer> b) {
    return a.stream().filter(b::contains).collect(Collectors.toCollection(ArrayList::new));
  }

  private static Set<Integer> odd(List<Integer> a, List<Integer> b) {
    var odd = a.stream().filter(o -> o % 2 != 0).collect(Collectors.toSet());
    odd.addAll(b.stream().filter(o -> o % 2 != 0).collect(Collectors.toSet()));
    return odd;
  }

  private static Set<Integer> even(List<Integer> a, List<Integer> b) {
    var odd = a.stream().filter(o -> o % 2 == 0).collect(Collectors.toSet());
    odd.addAll(b.stream().filter(o -> o % 2 == 0).collect(Collectors.toSet()));
    return odd;
  }
}
