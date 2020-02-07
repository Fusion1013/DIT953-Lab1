package modules;

import java.awt.*;

public class Scania extends Car {

    private double truckbedAngle = 0;

    /***
     * Creates a new scania truck
     */
    public Scania() {
        super(2, Color.green, 20, "ScaniaVabis314");
    }

    public void IncreaseAngle(double amount){
        truckbedAngle += amount;
        NormalizeAngle();
    }

    public void DecreaseAngle(double amount){
        truckbedAngle -= amount;
        NormalizeAngle();
    }

    private void NormalizeAngle(){
        truckbedAngle = Math.min(truckbedAngle, 70);
        truckbedAngle = Math.max(truckbedAngle, 0);

        if (getCurrentSpeed() != 0) truckbedAngle = 0;
    }

    public double getAngle(){
        return truckbedAngle;
    }

    @Override
    public void startEngine(){
        if (truckbedAngle == 0){
            super.startEngine();
        }
    }

    @Override
    public void incrementSpeed(double amount){
        if (truckbedAngle == 0){
            super.incrementSpeed(amount);
        }
    }
}
