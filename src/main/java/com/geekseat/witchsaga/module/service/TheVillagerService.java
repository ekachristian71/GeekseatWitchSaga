package com.geekseat.witchsaga.module.service;

import com.geekseat.witchsaga.module.controller.VillagersRequest;
import com.geekseat.witchsaga.module.controller.VillagersResponse;

public interface TheVillagerService {

  VillagersResponse getFinalResult(VillagersRequest request);

}

