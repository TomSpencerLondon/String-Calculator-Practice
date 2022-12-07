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
  }
}
