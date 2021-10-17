package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.model.VillagerKilled;

public class TheVillagerGlobalFunction {

  public static Integer getTotalKilledVillager(int year) {
    if (year == 1) {
      return 1;
    } else if (year == 0) {
      return 0;
    } else {
      return getTotalKilledVillager(year - 1) + getTotalKilledVillager(year - 2) + 1;
    }
  }

  public static Double getAverage(VillagerKilled villager1,
      VillagerKilled villager2) {
    int resultVillager1 = villager1.getYearOfDeath() - villager1.getAgeOfDeath();
    int resultVillager2 = villager2.getYearOfDeath() - villager2.getAgeOfDeath();

    Double totalOfVillagersFromV1Year = getTotalKilledVillager(
        resultVillager1).doubleValue();
    Double totalOfVillagerFromV2Year = getTotalKilledVillager(
        resultVillager2).doubleValue();

    return (totalOfVillagersFromV1Year + totalOfVillagerFromV2Year) / 2;
  }

}
