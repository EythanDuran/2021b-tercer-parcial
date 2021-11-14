package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        if (!BadRegion(state)){
            throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
        }

        StringBuilder licensePlate= new StringBuilder("1");
        Random randomNumber= new Random();

        licensePlate.append(state);

        while(licensePlate.length()<6){
            licensePlate.append(randomNumber.nextInt(10));
        }

        return licensePlate.toString();
    }

    private boolean BadRegion(String state) {
        return switch (state){
            case "BCN", "BCS", "CHH", "COA", "NLE", "SON", "TAM"->true;
            default -> false;
        };

    }
}


