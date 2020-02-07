package modules;

import interfaces.IMovable;
import parents.Container;
import parents.Movable;

public class CarFerry<T extends Car> implements IMovable {

    Container<T> parentContainer;
    Movable parentMovable;

    public CarFerry(int capacity){
        parentContainer = new Container(capacity);
        parentMovable = new Movable();
    }

    public void Load(T car) {
        parentContainer.Load(car);
    }

    public T Unload() {
        return parentContainer.Unload(0);
    }

    @Override
    public void move() {
        parentMovable.move();
    }

    @Override
    public void turnLeft() {
        parentMovable.turnLeft();
    }

    @Override
    public void turnRight() {
        parentMovable.turnRight();
    }

    @Override
    public void incrementSpeed(double amount) {
        parentMovable.incrementSpeed(amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        parentMovable.decrementSpeed(amount);
    }
}
