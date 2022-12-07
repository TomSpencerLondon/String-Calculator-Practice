package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void sumEmptyString() {
    assertThat(StringCalculator.sum(""))
        .isZero();
  }

  @Test
  void sumSingleNumberToItself() {
    assertThat(StringCalculator.sum("5"))
        .isEqualTo(5);
    assertThat(StringCalculator.sum("42"))
        .isEqualTo(42);
  }

  @Test
  void sumsTwoNumbersSeparatedByComma() {
    assertThat(StringCalculator.sum("1,2"))
        .isEqualTo(3);
    assertThat(StringCalculator.sum("1,3"))
        .isEqualTo(4);
  }

  @Test
  void sumThreeNumbersSeparatedByComma() {
    assertThat(StringCalculator.sum("1,2,3"))
        .isEqualTo(6);
  }
}
