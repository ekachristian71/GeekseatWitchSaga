package com.geekseat.witchsaga;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekseat.witchsaga.module.controller.VillagerController;
import com.geekseat.witchsaga.module.controller.VillagersRequest;
import com.geekseat.witchsaga.module.model.VillagerKilled;
import com.geekseat.witchsaga.module.service.TheVillagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = VillagerController.class)
@ActiveProfiles("test")
public class WitchsagaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  TheVillagerService theVillagerService;

  @Test
  void getResult() throws Exception {
    VillagersRequest request = new VillagersRequest();
    VillagerKilled killed1 = new VillagerKilled();
    killed1.setAgeOfDeath(10);
    killed1.setYearOfDeath(12);

    VillagerKilled killed2 = new VillagerKilled();
    killed2.setAgeOfDeath(10);
    killed2.setYearOfDeath(12);
    request.setVillager1(killed1);
    request.setVillager2(killed2);
    ObjectMapper objectMapper = new ObjectMapper();
    this.mockMvc.perform(post("/villager/result")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request))
    ).andExpect(status().isOk()).andReturn();

  }

}
