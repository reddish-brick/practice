package com.example.practice.BehavioralParametricProgramming.StreamOperationTest;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class Test {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
    //(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。
    System.out.println(transactions.stream()
        .filter(transaction -> 2011 == transaction.getYear())
        .sorted(comparing(Transaction::getValue))
        .collect(Collectors.toList()));
    //(2) 交易员都在哪些不同的􏶔市工作过?
    System.out.println(transactions.stream()
        .map(transaction -> transaction.getTrader())
        .map(trader -> trader.getCity())
        .distinct()
        .collect(Collectors.toList()));
    //(3) 查找所有来自于􏷣􏷤􏷣􏷤􏷣􏷤剑桥􏷣􏷤的交易员，并按􏷥姓名排序。
    System.out.println(transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> "Cambridge".equals(trader.getCity()))
        .sorted(comparing(Trader::getName))
        .distinct()
        .collect(Collectors.toList()));
    //(4) 返回所有交易员的􏷥姓名字符串，按字母顺序排序。
    System.out.println(transactions.stream()
        .map(transaction -> transaction.getTrader())
        .map(trader -> trader.getName())
        .distinct()
        .sorted()
        .collect(Collectors.toList()));
    //(5) 有没有交易员是在􏷦兰工作的?
    System.out.println(transactions.stream()
        .map(transaction -> transaction.getTrader())
        .filter(trader -> "Milan".equals(trader.getCity()))
        .count() > 0);
    //(6) 打印生活在剑桥􏷣􏷤的交易员的所有交易额。
    System.out.println(transactions.stream()
        .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
        .map(transaction -> transaction.getValue())
        .reduce(0, (a, b) -> a + b));
    //(7) 所有交易中，最高的交易额是多少?
    System.out.println(transactions.stream()
        .map(transaction -> transaction.getValue())
        .reduce(0, (a, b) -> a > b ? a : b));
    //(8) 找到交易额最小的交易。
    System.out.println(
        transactions.stream()
            .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2));
  }


}
