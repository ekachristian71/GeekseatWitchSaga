package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.controller.VillagerResponse;
import com.geekseat.witchsaga.module.controller.VillagersRequest;
import com.geekseat.witchsaga.module.controller.VillagersResponse;
import com.geekseat.witchsaga.module.model.VillagerKilled;
import org.springframework.stereotype.Service;

@Service
public class TheVillagerServiceImpl implements TheVillagerService {

  @Override
  public VillagersResponse getFinalResult(VillagersRequest request) {
    VillagersResponse response = new VillagersResponse();

    if (isNullInputAgeAndYearOfDeath(request) && isValidAgeAndYearOfDeath(request)) {
      VillagerResponse villager1 = buildVillagerMortalityData(request.getVillager1());
      VillagerResponse villager2 = buildVillagerMortalityData(request.getVillager2());

      buildAverageResultSuccessResponse(request, response, villager1, villager2);
    } else {
      response.setResult(-1D);
    }
    return response;
  }

  private boolean isValidAgeAndYearOfDeath(VillagersRequest request) {
    return validateAgeAndYearOfDeath(request.getVillager1()) && validateAgeAndYearOfDeath(
        request.getVillager2());
  }

  public static Boolean validateAgeAndYearOfDeath(VillagerKilled villager) {
    return villager.getAgeOfDeath() >= 0 && villager.getYearOfDeath() >= 0
        && villager.getAgeOfDeath() <= villager.getYearOfDeath();
  }

  private boolean isNullInputAgeAndYearOfDeath(VillagersRequest request) {
    return validateNullInputAgeAndYearOfDeath(request.getVillager1())
        && validateNullInputAgeAndYearOfDeath(request.getVillager2());
  }

  public static Boolean validateNullInputAgeAndYearOfDeath(VillagerKilled villager) {
    return villager.getAgeOfDeath() != null && villager.getYearOfDeath() != null;
  }

  private VillagerResponse buildVillagerMortalityData(VillagerKilled villagerKilled) {
    VillagerResponse personResponse = new VillagerResponse();
    personResponse.setAgeOfDeath(villagerKilled.getAgeOfDeath());
    personResponse.setYearOfDeath(villagerKilled.getYearOfDeath());

    Integer totalKilled = TheVillagerGlobalFunction.getTotalKilledVillager(
        villagerKilled.getYearOfDeath() - villagerKilled.getAgeOfDeath());

    personResponse.setTotalKilledVillagerPerYear(totalKilled);
    return personResponse;

  }

  private void buildAverageResultSuccessResponse(VillagersRequest request,
      VillagersResponse response,
      VillagerResponse villager1, VillagerResponse villager2) {
    response.setVillager1(villager1);
    response.setVillager2(villager2);
    response.setResult(
        TheVillagerGlobalFunction.getAverage(request.getVillager1(), request.getVillager2()));
  }
}
