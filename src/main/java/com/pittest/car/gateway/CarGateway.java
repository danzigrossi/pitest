package com.pittest.car.gateway;

import com.pittest.car.domain.Car;

public interface CarGateway {

    public Car findByPlate(String plate);
}
