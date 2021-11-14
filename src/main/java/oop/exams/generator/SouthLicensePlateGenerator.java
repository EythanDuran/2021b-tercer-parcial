package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        if (!BadRegion(state)){
            throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
        }

        StringBuilder licensePlate= new StringBuilder("4");
        Random randomNumber= new Random();

        licensePlate.append(state);

        while(licensePlate.length()<7){
            licensePlate.append(randomNumber.nextInt(10));
        }

        return licensePlate.toString();
    }

    private boolean BadRegion(String state) {
        return switch (state){
            case "CHP", "GRO", "MIC", "OAX"->true;
            default -> false;
        };
    }
}


