package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        if (!BadRegion(state)){
            throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
        }

        StringBuilder licensePlate= new StringBuilder("3");
        Random randomNumber= new Random();

            licensePlate.append(randomNumber.nextInt(10)); //espacios que faltan
            licensePlate.append(randomNumber.nextInt(10));


        licensePlate.append("Z");

        return licensePlate.toString();
    }

    private boolean BadRegion(String state) {
        return switch (state){
            case "CAM", "ROO", "TAB", "VER", "YUC"->true;
            default -> false;
        };

    }

    }

