package modules;

import interfaces.IContainer;

public class CarFerry implements IContainer<Car> {

    /***
     * Herro
     * @param loadable
     */
    @Override
    public void Load(Car loadable) {

    }

    @Override
    public Car Unload(int pos) {
        return null;
    }
}
