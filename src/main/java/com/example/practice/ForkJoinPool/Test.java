package com.example.practice.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

  public static void main(String[] args) {
    // 创建随机数组成的数组:
    long[] array = LongStream.rangeClosed(1, 400).toArray();
    // fork/join task:
    ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
    ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
    long startTime = System.currentTimeMillis();
    Long result = fjp.invoke(task);
    long endTime = System.currentTimeMillis();
    System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
  }
}
