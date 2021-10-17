package com.geekseat.witchsaga.module.controller;

import com.geekseat.witchsaga.module.service.TheVillagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villager")
public class VillagerController {

  @Autowired
  TheVillagerService theVillagerService;

  @PostMapping("/result")
  public ResponseEntity<VillagersResponse> getFinalResult(@RequestBody VillagersRequest request) {
    VillagersResponse villagersResponse = theVillagerService.getFinalResult(request);
    return ResponseEntity.ok(villagersResponse);
  }

}
