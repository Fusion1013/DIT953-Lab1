package modules;

import interfaces.IContainer;

public class CarFerry implements IContainer<Car> {

    @Override
    public void Load(Car loadable) {

    }

    @Override
    public Car Unload(int pos) {
        return null;
    }
}
