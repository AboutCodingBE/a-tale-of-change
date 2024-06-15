package be.aboutcoding.change.processs;

import be.aboutcoding.change.api.CoffeeApi;
import be.aboutcoding.change.api.CoffeeCup;

import java.util.Random;

public class CoffeeMachine {

    public int amountOfCoffeeGrounds;

    public boolean hasFilter = false;

    public int boilingTemperatureInCelcius = 100;
    public int currentWaterTemperatureInCelcius;

    //This coffee machine runs on electricity
    public int netVoltage = 220;
    public int currentVoltage = 0;
    public final int boilerVoltage = 120;
    public boolean isOn = false;

    public int maximumVolumeOfWaterContainer = 150;

    public CoffeeApi coffeeApi;

    public CoffeeMachine(CoffeeApi coffeeApi) {
        this.coffeeApi = new CoffeeApi();
    }

    public void addFilter() {
        this.hasFilter = true;
    }

    public void addCoffeeGrounds(int amountPowder){
        this.amountOfCoffeeGrounds = amountPowder;
    }

    public void heatWater() {
        var volume =  coffeeApi.v;
        if(currentVoltage > boilerVoltage) {
            throw new RuntimeException("To high voltage! Boiler broke");
        }

        if(currentVoltage < boilerVoltage - 10) {
            throw new RuntimeException("To low voltage! Heating water will take forever");
        }

        if(volume > maximumVolumeOfWaterContainer) {
            throw new RuntimeException("Too much boiling water! This machine can currently handle " + maximumVolumeOfWaterContainer + " mililiters of water");
        }

        System.out.println("- ...boiling water...");
        this.currentWaterTemperatureInCelcius = getInitialWaterTemperature();
        while(currentWaterTemperatureInCelcius < boilingTemperatureInCelcius) {
            heatUp();
        }
    }

    /**
     * Realistically put somewhere between 10 and 20 degrees I guess
     */
    public int getInitialWaterTemperature() {
        var random = new Random();
        return random.nextInt(10)+10;
    }

    public void heatUp() {
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong when heating up the water!");
        }

        currentWaterTemperatureInCelcius ++;
    }

    public void transformElectricalCurrent() {
        currentVoltage = netVoltage - 100;
    }

    public void turnOn() {
        if(!isOn) {
            this.currentVoltage = netVoltage;
            transformElectricalCurrent();
        }
        else {
            System.out.println("Can't turn on, the machine is already on");
        }
    }

    public void turnOff() {
        if(isOn) {
            this.currentVoltage = 0;
        }
        else{
            System.out.println("Can't turn off, the machine is not turned on");
        }
    }

    //This is where you slowly pour the hot water over the coffee powder
    public CoffeeCup percolate() {
        var volume =  coffeeApi.v;
        System.out.println("percolating....");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong while percolating the coffee!");
        }
        if(volume > maximumVolumeOfWaterContainer) {
            throw new RuntimeException("Too much boiling water! This machine can currently handle " + maximumVolumeOfWaterContainer + " mililiters of water");
        }
        return new CoffeeCup(volume);
    }
}
