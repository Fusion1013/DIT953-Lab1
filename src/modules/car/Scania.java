package modules.car;

import modules.Vector2;

import java.awt.*;

public class Scania extends Car {
    private double truckbedAngle = 0;

    /***
     * Creates a new scania truck
     */
    public Scania() {
        super(2, Color.green, 20, "ScaniaVabis314");
    }

    /***
     * Creates a new scania truck
     */
    public Scania(Vector2 startPos) {
        super(2, Color.green, 20, "ScaniaVabis314", startPos);
    }

    /***
     * increases the angle of the truckbed by the specified amount
     * @param amount the double amount to increase the truckbed
     */
    public void IncreaseAngle(double amount){
        truckbedAngle += amount;
        NormalizeAngle();
    }
    /***
     * decreases the angle of the truckbed by the specified amount
     * @param amount the double amount to decrease the truckbed
     */

    @Override
    public void DecreaseAngle(double amount) {
        if (getCurrentSpeed() != 0) {
            truckBedParent.DecreaseAngle(amount);
        }
    }

    /***
     *
     * @return returns the angle of the truckbed
     */
    public double getAngle(){
        return truckbedAngle;
    }

    /***
     * starts the engine
     */

    @Override
    public void startEngine(){
        if (truckbedAngle == 0){
            super.startEngine();
        }
    }

    /***
     * increases the speed by the specified amount
     * @param amount The amount to increase the current speed by
     */

    @Override
    public void incrementSpeed(double amount){
        if (truckbedAngle == 0){
            super.incrementSpeed(amount);
        }
    }
}
