package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class DefaultLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {

        if (!BadRegion(state)){
            throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
        }

        StringBuilder licensePlate= new StringBuilder("5");
        Random randomNumber= new Random();

        for(int i=1;i<8;i++){
            licensePlate.append(randomNumber.nextInt(10));
        }

        return licensePlate.toString();
    }

    private boolean BadRegion(String state) {
        return switch (state){
            case "AGU", "CMX", "DUR", "GUA", "HID", "MEX", "PUE", "QUE", "SLP", "TLA", "ZAC"->true;
            default -> false;
        };

    }
}
