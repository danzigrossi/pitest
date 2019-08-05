package com.pittest.car.usecase;

import com.pittest.car.gateway.CarGateway;
import com.pittest.car.usecase.Exception.PlateOutOfPatternExeption;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidatePlate {

    private CarGateway carGateway;

    public boolean process(String plate) throws PlateOutOfPatternExeption {
        try  {
            String[] splitedPlate = plate.split("-");
            Integer.parseInt(splitedPlate[1]);
            String plateString = splitedPlate[0];
            Pattern pattern = Pattern.compile("[A-Z]{3}");

            if (!pattern.matcher(plateString).matches()) {
                throw new PlateOutOfPatternExeption("Os tres primeiro digitos devem ser letras");
            }
        }
        catch(IndexOutOfBoundsException iobe) {
            throw new PlateOutOfPatternExeption("A placa deve ter o formato SSS-NNNN");
        }
        catch(NumberFormatException nfe) {
            throw new PlateOutOfPatternExeption("Os quatro ultimos digitos devem ser numéricos");
        }
        return true;
    }


}
