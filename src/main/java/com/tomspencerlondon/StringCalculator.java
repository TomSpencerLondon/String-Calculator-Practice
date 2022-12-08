package com.tomspencerlondon;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

  private String delimiter;
  private String numbers;

  public StringCalculator(String delimiter, String numbers) {
    this.delimiter = delimiter;
    this.numbers = numbers;
  }

  public static int sum(String input) {
    StringCalculator calculator = parseInput(input);
    return calculator.sum();
  }

  private int sum() {
    checkForNegativeNumbers();
    return getNumber().sum();
  }

  private void checkForNegativeNumbers() {
    String negativeNumbers = getNumber().filter(n -> n < 0)
        .mapToObj(Integer::toString)
        .collect(Collectors.joining(", "));

    if (!negativeNumbers.isEmpty()) {
      throw new IllegalArgumentException("Number is negative: " + negativeNumbers);
    }
  }

  private IntStream getNumber() {
    if (numbers.isEmpty()) {
      return IntStream.empty();
    }
    return Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt)
        .map(n -> n % 1000);
  }

  private static StringCalculator parseInput(String input) {
    if (input.startsWith("//")) {
      String[] parts = input.split("\n", 2);
      return new StringCalculator(parts[0].substring(2), parts[1]);
    } else {
      return new StringCalculator(",|\n", input);
    }
  }
}
