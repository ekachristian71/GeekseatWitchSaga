package com.geekseat.witchsaga;

import com.geekseat.witchsaga.module.controller.VillagersRequest;
import com.geekseat.witchsaga.module.controller.VillagersResponse;
import com.geekseat.witchsaga.module.model.VillagerKilled;
import com.geekseat.witchsaga.module.service.TheVillagerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WitchsagaApplicationTests {

  @InjectMocks
  TheVillagerServiceImpl theVillagerServiceImpl;

  VillagersRequest buildRequest(VillagerKilled villager1, VillagerKilled villager2) {
    VillagersRequest villagersRequest = new VillagersRequest();
    villagersRequest.setVillager1(villager1);
    villagersRequest.setVillager2(villager2);
    return villagersRequest;
  }

  VillagerKilled buildVillagerKilled(Integer ageOfDeath, Integer yearOfDeath) {
    VillagerKilled villagerKilled = new VillagerKilled();
    villagerKilled.setAgeOfDeath(ageOfDeath);
    villagerKilled.setYearOfDeath(yearOfDeath);
    return villagerKilled;
  }

  @Test
  public void testNullInputAgeAndYearOfDeath() {
    VillagerKilled villagerKilled1 = buildVillagerKilled(null, null);
    VillagerKilled villagerKilled2 = buildVillagerKilled(null, null);

    VillagersRequest request = buildRequest(villagerKilled1, villagerKilled2);

    VillagersResponse expectedResponse = new VillagersResponse();
    expectedResponse.setResult(-1D);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);

    Assertions.assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

  @Test
  public void testNotValidInputAgeAndYearOfDeath() {
    VillagerKilled villagerKilled1 = buildVillagerKilled(10, 9);
    VillagerKilled villagerKilled2 = buildVillagerKilled(15, 10);

    VillagersRequest request = buildRequest(villagerKilled1, villagerKilled2);

    VillagersResponse expectedResponse = new VillagersResponse();
    expectedResponse.setResult(-1D);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);

    Assertions.assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

  @Test
  public void testSuccess() {
    VillagerKilled villagerKilled1 = buildVillagerKilled(10, 12);
    VillagerKilled villagerKilled2 = buildVillagerKilled(13, 17);

    VillagersRequest request = buildRequest(villagerKilled1, villagerKilled2);

    VillagersResponse expectedResponse = new VillagersResponse();
    expectedResponse.setResult(4.5);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);
    System.out.println("Actual : " + actualResponse.getResult());
    System.out.println("Expected : " + expectedResponse.getResult());

    Assertions.assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

}
