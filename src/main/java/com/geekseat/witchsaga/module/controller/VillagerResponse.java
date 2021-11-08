package com.geekseat.witchsaga.module.controller;

import com.geekseat.witchsaga.module.model.VillagerKilled;
import java.math.BigInteger;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VillagerResponse extends VillagerKilled {

  private BigInteger totalKilledVillagerPerYear;
}
