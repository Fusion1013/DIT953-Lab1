package modules;

import interfaces.IContainer;
import parents.Container;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport<T extends Car> extends Car {

    private int maxCars;
    private boolean truckRampUp;

    private Container<T> parent;

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
        parent = new Container(maxCars);
    }

    /***
     * Moves the CarTransport and sets the position of the cars to the same value 
     */
    @Override
    public void move(){
        super.move();

        for (T car : parent.GetStored()) {
            car.SetPosition(GetPosition());
        }
    }

    /***
     * Raises and lowers the ramp only when the speed is 0
     */
    public void ToggleRamp(){
        if (getCurrentSpeed() == 0) truckRampUp = !truckRampUp;
    }

    /***
     * Only starts the engine if the truck ramp is up
     */
    @Override
    public void startEngine(){
        if (truckRampUp) super.startEngine();
    }

    /***
     * Only increments speed if the truck ramp is up
     * @param amount The amount to increase the current speed by
     */
    @Override
    public void incrementSpeed(double amount){
        if (truckRampUp){
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
        if (parent.GetStored().size() < maxCars && !truckRampUp){
            parent.Load(car);
        }
    }

    /***
     * Unloads the last car 3 coordinates behind the CarTransport
     * @return
     */
    public T Unload() {
        if (!truckRampUp){
            T removed = parent.Unload(parent.GetStored().size() - 1);
            removed.SetPosition(Vector2.Add(removed.GetPosition(), Vector2.Scale(GetDirection(), -3)));
            return removed;
        }

        return null;
    }
}
