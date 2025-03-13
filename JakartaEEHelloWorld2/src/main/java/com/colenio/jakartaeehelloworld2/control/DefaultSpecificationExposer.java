package com.colenio.jakartaeehelloworld2.control;

import com.colenio.jakartaeehelloworld2.entity.Color;
import com.colenio.jakartaeehelloworld2.entity.EngineType;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.enterprise.inject.Produces;

public class DefaultSpecificationExposer {

    @Produces
    public static final Specifcation blackElectricSuperCar = new Specifcation(Color.BLACK, EngineType.ELECTRIC);

    private DefaultSpecificationExposer() {
    }
}
