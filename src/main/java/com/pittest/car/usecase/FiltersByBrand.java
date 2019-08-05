package com.pittest.car.usecase;

import com.pittest.Starter;
import com.pittest.car.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltersByBrand {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    @Autowired
    private RegisterUnfoundBrand registerUnfoundBrand;

    public List process(List<Car> cars, String brand){
        LOGGER.info("Filtering cars by brand");
        List filteredCars = new ArrayList();
        for (Car car : cars) {
            if (brand.equalsIgnoreCase(car.getMarca())) {
                filteredCars.add(car);
            }
        }
        if (!(filteredCars.size() >= 1)) {
            registerUnfoundBrand.process(brand);
        }

        LOGGER.info("Filtering finish");
        return filteredCars;

    }
}
