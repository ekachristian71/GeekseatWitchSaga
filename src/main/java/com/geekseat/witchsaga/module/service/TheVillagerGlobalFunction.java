package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.model.VillagerKilled;
import java.util.HashMap;
import java.util.Map;

public class TheVillagerGlobalFunction {

  static int[] fib;

  public static Integer getTotalKilledVillager(int year) {
    fib = new int[year + 1];
    fib[0] = 1;
    fib[1] = 1;

    for(int i = 2; i <= year; i++) {
      fib[i] = fib[i-1] + fib[i-2];
    }
    return fib[year];
  }

  public static Double getAverage(VillagerKilled villager1,
      VillagerKilled villager2) {
    int resultVillager1 = villager1.getYearOfDeath() - villager1.getAgeOfDeath();
    int resultVillager2 = villager2.getYearOfDeath() - villager2.getAgeOfDeath();

    long preTime = System.currentTimeMillis();
    System.out.println("Waktu Mulai ->" + preTime);
    Double totalOfVillagersFromV1Year = getTotalKilledVillager(
        resultVillager1).doubleValue();
    Double totalOfVillagerFromV2Year = getTotalKilledVillager(
        resultVillager2).doubleValue();

    Double averageResult = (totalOfVillagersFromV1Year + totalOfVillagerFromV2Year) / 2;
    long postTime = System.currentTimeMillis();
    System.out.println("Waktu Akhir->" + (postTime - preTime));
    return averageResult;
  }

}
