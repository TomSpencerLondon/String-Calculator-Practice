package com.tomspencerlondon;

import java.util.Arrays;

public class StringCalculator {

  private String delimiter;
  private String numbers;

  public StringCalculator(String delimiter, String numbers) {
    this.delimiter = delimiter;
    this.numbers = numbers;
  }

  public static int sum(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    StringCalculator calculator = createCalculatorFor(input);
    return Arrays.stream(calculator.numbers.split(calculator.delimiter))
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static StringCalculator createCalculatorFor(String input) {
    if (input.startsWith("//")) {
      String[] parts = input.split("\n", 2);
      return new StringCalculator(parts[0].substring(2), parts[1]);
    } else {
      return new StringCalculator(",|\n", input);
    }
  }
}
