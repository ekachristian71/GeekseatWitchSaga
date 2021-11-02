package com.geekseat.witchsaga;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geekseat.witchsaga.module.controller.VillagerResponse;
import com.geekseat.witchsaga.module.controller.VillagersRequest;
import com.geekseat.witchsaga.module.controller.VillagersResponse;
import com.geekseat.witchsaga.module.model.VillagerKilled;
import com.geekseat.witchsaga.module.service.TheVillagerServiceImpl;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    expectedResponse.setResult(-1);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);

    assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

  @Test
  public void testNotValidInputAgeAndYearOfDeath() {
    VillagerKilled villagerKilled1 = buildVillagerKilled(10, 9);
    VillagerKilled villagerKilled2 = buildVillagerKilled(15, 10);

    VillagersRequest request = buildRequest(villagerKilled1, villagerKilled2);

    VillagersResponse expectedResponse = new VillagersResponse();
    expectedResponse.setResult(-1);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);

    assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

  @Test
  public void testSuccess() {
    VillagerKilled villagerKilled1 = buildVillagerKilled(10, 12);
    VillagerKilled villagerKilled2 = buildVillagerKilled(13, 17);

    VillagersRequest request = buildRequest(villagerKilled1, villagerKilled2);

    VillagersResponse expectedResponse = new VillagersResponse();
    expectedResponse.setResult(2.0F);

    VillagersResponse actualResponse = theVillagerServiceImpl.getFinalResult(request);
    System.out.println("Actual Response : " + actualResponse.getResult());
    System.out.println("Expected Response : " + expectedResponse.getResult());

    assertEquals(expectedResponse.getResult(), actualResponse.getResult());
  }

  @Test
  public void testEqualsObjectVillagersResponse() {
    EqualsVerifier.simple().forClass(VillagersResponse.class).verify();
  }

  @Test
  public void testEqualsObjectVillagersRequest() {
    EqualsVerifier.simple().forClass(VillagersRequest.class).verify();
  }

  @Test
  public void testEqualsObjectVillagesResponse() {
    EqualsVerifier.simple().forClass(VillagerResponse.class).verify();
  }

  @Test
  public void testEqualsObjectVillagerKilled() {
    EqualsVerifier.simple().forClass(VillagerKilled.class).verify();
  }

  @Test
  public void testToStringVillagersRequest() {
    VillagersRequest request1 = new VillagersRequest();
    VillagersRequest request2 = new VillagersRequest();
    assertEquals(request1.toString(), request2.toString());
  }

  @Test
  public void testToStringVillagersResponse() {
    VillagersResponse request1 = new VillagersResponse();
    VillagersResponse request2 = new VillagersResponse();
    assertEquals(request1.toString(), request2.toString());
  }

  @Test
  public void testToStringVillagerResponse() {
    VillagerResponse request1 = new VillagerResponse();
    VillagerResponse request2 = new VillagerResponse();
    assertEquals(request1.toString(), request2.toString());
  }

  @Test
  public void testToStringVillagerKilled() {
    VillagerKilled request1 = new VillagerKilled();
    VillagerKilled request2 = new VillagerKilled();
    assertEquals(request1.toString(), request2.toString());
  }

  @Test
  public void testSpringBootApp(){
    WitchsagaApplication.main(new String[] {});
  }

}
