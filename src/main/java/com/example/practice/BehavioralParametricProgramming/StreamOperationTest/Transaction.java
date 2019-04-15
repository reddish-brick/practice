package com.example.practice.BehavioralParametricProgramming.StreamOperationTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Transaction {

  private Trader trader;
  private int year;
  private int value;
}
