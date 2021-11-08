package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.model.VillagerKilled;
import java.math.BigInteger;

public class TheVillagerGlobalFunction {

  static int[] fib;

  public static BigInteger getTotalKilledVillager(int year) {
    if (year <= 0) {
      return BigInteger.valueOf(0);
    }

    BigInteger[] fibo = new BigInteger[year + 1];
    fibo[0] = BigInteger.valueOf(0L);
    fibo[1] = BigInteger.valueOf(1L);

    // Initialize result
    BigInteger sum = fibo[0].add(fibo[1]);

    // Add remaining terms
    for (int i = 2; i <= year; i++) {
      fibo[i] = fibo[i - 1].add(fibo[i - 2]);
      System.out.println("FIBO i : " + fibo[i]);
      sum = sum.add(fibo[i]);
    }

    return sum;
  }

  public static Float getAverage(VillagerKilled villager1,
      VillagerKilled villager2) {
    int resultVillager1 = villager1.getYearOfDeath() - villager1.getAgeOfDeath();
    int resultVillager2 = villager2.getYearOfDeath() - villager2.getAgeOfDeath();
    System.out.println("RESULT VILLAGER 1 : " + resultVillager1);
    System.out.println("RESULT VILLAGER 2 : " + resultVillager2);
    long preTime = System.currentTimeMillis();
    System.out.println("Waktu Mulai ->" + preTime);
    BigInteger totalOfVillagersFromV1Year = getTotalKilledVillager(
        resultVillager1);
    BigInteger totalOfVillagerFromV2Year = getTotalKilledVillager(
        resultVillager2);

    System.out.println("TOTAL RESULT VILLAGER 1 : " + totalOfVillagersFromV1Year);
    System.out.println("TOTAL RESULT VILLAGER 2 : " + totalOfVillagerFromV2Year);

    Float averageResult = (totalOfVillagersFromV1Year.add(totalOfVillagerFromV2Year)).floatValue() /
        BigInteger.valueOf(2).floatValue();

    System.out.println("AVG RESULT : " + averageResult);
    long postTime = System.currentTimeMillis();
    System.out.println("Waktu Akhir->" + (postTime - preTime));
    return averageResult;
  }

}
