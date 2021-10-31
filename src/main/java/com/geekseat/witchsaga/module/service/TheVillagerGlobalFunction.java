package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.model.VillagerKilled;
import java.util.HashMap;
import java.util.Map;

public class TheVillagerGlobalFunction {

  private static final Map<Integer, Integer> memo = new HashMap<>();

  public static Integer getTotalKilledVillager(int year) {
    if (year == 0 || year == 1) {
      return year;
    }

    if (memo.containsKey(year)) {
      System.out.printf("Ambil memo hashmap [%d]\n", year);
      return memo.get(year);
    }

    System.out.printf("Hitung ulang fibonacci (%d)\n",year);
    int result = getTotalKilledVillager(year - 1) + getTotalKilledVillager(year - 2);

    // memoize
    memo.put(year, result);
    return result;
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
