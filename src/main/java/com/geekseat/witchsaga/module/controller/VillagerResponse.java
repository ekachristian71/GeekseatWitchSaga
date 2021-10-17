package com.geekseat.witchsaga.module.controller;

import com.geekseat.witchsaga.module.model.VillagerKilled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VillagerResponse extends VillagerKilled {

  private Integer totalKilledVillagerPerYear;
}
