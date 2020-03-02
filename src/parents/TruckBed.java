package parents;

import interfaces.ITruckbed;

public class TruckBed implements ITruckbed {
    public double truckbedAngle = 0;
    private double maxAngle = 70;
    private double minAngle = 0;

    @Override
    public void IncreaseAngle(double amount){
        truckbedAngle += amount;
        truckbedAngle = Math.min(truckbedAngle, maxAngle);
    }
    /***
     * decreases the angle of the truckbed by the specified amount
     * @param amount the double amount to decrease the truckbed
     */
    @Override
    public void DecreaseAngle(double amount){
        truckbedAngle -= amount;
        truckbedAngle = Math.max(truckbedAngle, minAngle);
    }
}
