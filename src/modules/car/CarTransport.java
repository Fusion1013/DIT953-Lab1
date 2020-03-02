package modules.car;

import interfaces.IContainer;
import interfaces.ITruckbed;
import modules.Vector2;
import parents.Container;
import parents.TruckBed;

import java.awt.*;

public class CarTransport<T extends Car> extends Car implements IContainer<T>, ITruckbed {

    private int maxCars;
    private double truckRampUp;

    private Container<T> containerParent;
    private TruckBed truckBedParent;

    /***
     * Creates a new truck
     * @param nrDoors the number of doors of the car
     * @param color the color of the car
     * @param enginePower the cars engine power
     * @param modelName the model name of the car
     */
    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        maxCars = 4;
        containerParent = new Container(maxCars);
    }

    /***
     * Moves the CarTransport and sets the position of the cars to the same value 
     */
    @Override
    public void move(){
        super.move();

        for (T car : containerParent.GetStored()) {
            car.SetPosition(GetPosition());
        }
    }

    /***
     * increases the angle of the truckbed by the specified amount
     * @param amount the double amount to increase the truckbed
     */
    @Override
    public void IncreaseAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            truckBedParent.IncreaseAngle(amount);
        }
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
     * Only starts the engine if the truck ramp is up
     */
    @Override
    public void startEngine(){
        if (truckRampUp == 0) super.startEngine();
    }

    /***
     * Only increments speed if the truck ramp is up
     * @param amount The amount to increase the current speed by
     */
    @Override
    public void incrementSpeed(double amount){
        if (truckRampUp == 0){
            super.incrementSpeed(amount);
        }
    }

    /***
     * Only loads the vehicle if it is within 3 coordinates, is transportable,
     * the capacity is not full and truck ramp is down
     * @param car
     */
    public void Load(T car) {
        if (Vector2.Distance(car.GetPosition(), this.GetPosition()) > 3){
            return;
        }
        if (car.getClass() == CarTransport.class){
            return;
        }
        if (containerParent.GetStored().size() < maxCars && truckRampUp != 0){
            containerParent.Load(car);
        }
    }

    public T Unload(){
        return Unload(0);
    }

    /***
     * Unloads the last car 3 coordinates behind the CarTransport
     * @return
     */
    public T Unload(int pos) {
        if (truckRampUp != 0){
            T removed = containerParent.Unload(containerParent.GetStored().size() - 1);
            removed.SetPosition(Vector2.Add(removed.GetPosition(), Vector2.Scale(GetDirection(), -3)));
            return removed;
        }

        return null;
    }
}
