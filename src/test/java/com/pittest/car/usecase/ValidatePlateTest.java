package com.pittest.car.usecase;


import com.pittest.car.usecase.Exception.PlateOutOfPatternExeption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnit44Runner.class)
@ContextConfiguration(classes = { FiltersByBrandTest.class })
public class ValidatePlateTest {

    @InjectMocks
    private ValidatePlate validatePlate;

    @Test
    public void shouldFilterByBrand() throws PlateOutOfPatternExeption {
        assertTrue(validatePlate.process("ASD-1234"));
    }
}
