package modules;

import interfaces.IContainer;
import parents.Container;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport<T extends Car> extends Car {

    private int maxCars;
    private boolean truckbedUp;

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

    @Override
    public void move(){
        super.move();

        for (T car : parent.GetStored()) {
            car.SetPosition(GetPosition());
        }
    }

    public void ToggleBed(){
        if (getCurrentSpeed() == 0) truckbedUp = !truckbedUp;
    }

    @Override
    public void startEngine(){
        if (truckbedUp) super.startEngine();
    }

    @Override
    public void incrementSpeed(double amount){
        if (truckbedUp){
            super.incrementSpeed(amount);
        }
    }

    public void Load(T car) {
        if (Vector2.Distance(car.GetPosition(), this.GetPosition()) > 3){
            return;
        }
        if (car.getClass() == CarTransport.class){
            return;
        }
        if (parent.GetStored().size() < maxCars && !truckbedUp){
            parent.Load(car);
        }
    }

    public T Unload() {
        if (!truckbedUp){
            T removed = parent.Unload(parent.GetStored().size() - 1);
            removed.SetPosition(Vector2.Add(removed.GetPosition(), Vector2.Scale(GetDirection(), -3)));
            return removed;
        }

        return null;
    }
}
