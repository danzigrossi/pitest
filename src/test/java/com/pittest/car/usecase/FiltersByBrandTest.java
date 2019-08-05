package com.pittest.car.usecase;

import com.pittest.car.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { FiltersByBrandTest.class })
public class FiltersByBrandTest {

    @InjectMocks
    private FiltersByBrand filtersByBrand;

    @Mock
    private RegisterUnfoundBrand registerUnfoundBrand;

    @Test
    public void shouldFilterByBrand() {
        List fullCarList = new ArrayList<Car>();
        List processedList = filtersByBrand.process(createCars(), "audi");
        assertEquals(3,processedList.size());
        verify(registerUnfoundBrand, times(0)).process("audi");
    }

    @Test
    public void shouldFilterByBrandAndReturnEmptyList() {
        List fullCarList = new ArrayList<Car>();
        List processedList = filtersByBrand.process(createCars(), "renault");
        verify(registerUnfoundBrand, times(1)).process("renault");
        assertEquals(0,processedList.size());
    }

    @Test
    public void shouldFilterByBrandAndReturnListWithOneElement() {
        List fullCarList = new ArrayList<Car>();
        List processedList = filtersByBrand.process(createCars(), "Auadiq");
        verify(registerUnfoundBrand, times(0)).process("Auadiq");
        assertEquals(1,processedList.size());
    }


    private List<Car> createCars() {
        List cars = new ArrayList<Car>();

        Car audi1 = new Car();
        audi1.setMarca("Audi");
        cars.add(audi1);

        Car audi2 = new Car();
        audi2.setMarca("Audi");
        cars.add(audi2);

        Car audi3 = new Car();
        audi3.setMarca("Audi");
        cars.add(audi3);

        Car audi4 = new Car();
        audi4.setMarca("Audai");
        cars.add(audi4);

        Car audi5 = new Car();
        audi5.setMarca("Auadiq");
        cars.add(audi5);

        return cars;
    }

}
