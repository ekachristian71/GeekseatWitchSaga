package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.model.VillagerKilled;

public class TheVillagerGlobalFunction {

  static int[] fib;

  public static Integer getTotalKilledVillager(int year) {
//    int containerA = 0;
//    int containerB = 1;
//    int containerC;
//    if (year == 0 || year == 1) {
//      return year;
//    }
//    for (int i = 1; i <= year; i++) {
//      containerC = containerA + containerB;
//      containerA = containerB;
//      containerB = containerC;
//    }
//    return containerB;
    if (year <= 0) {
      return 0;
    }

    int[] fibo = new int[year + 1];
    fibo[0] = 0;
    fibo[1] = 1;

    // Initialize result
    int sum = fibo[0] + fibo[1];

    // Add remaining terms
    for (int i = 2; i <= year; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
      sum += fibo[i];
    }

    return sum;
  }

  public static float getAverage(VillagerKilled villager1,
      VillagerKilled villager2) {
    int resultVillager1 = villager1.getYearOfDeath() - villager1.getAgeOfDeath();
    int resultVillager2 = villager2.getYearOfDeath() - villager2.getAgeOfDeath();
    System.out.println("RESULT VILLAGER 1 : " + resultVillager1);
    System.out.println("RESULT VILLAGER 2 : " + resultVillager2);
    long preTime = System.currentTimeMillis();
    System.out.println("Waktu Mulai ->" + preTime);
    int totalOfVillagersFromV1Year = getTotalKilledVillager(
        resultVillager1);
    int totalOfVillagerFromV2Year = getTotalKilledVillager(
        resultVillager2);

    System.out.println("TOTAL RESULT VILLAGER 1 : " + totalOfVillagersFromV1Year);
    System.out.println("TOTAL RESULT VILLAGER 2 : " + totalOfVillagerFromV2Year);

    float averageResult = (totalOfVillagersFromV1Year + totalOfVillagerFromV2Year) / (float) 2;

    System.out.println("AVG RESULT : " + averageResult);
    long postTime = System.currentTimeMillis();
    System.out.println("Waktu Akhir->" + (postTime - preTime));
    return averageResult;
  }

}
