package com.tomspencerlondon;

import java.util.Arrays;

public class StringCalculator {

  public static int sum(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    return Arrays.stream(input.split(",|\n"))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
