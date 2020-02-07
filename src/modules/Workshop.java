package modules;

import interfaces.IContainer;
import parents.Container;

public class Workshop<T extends Car> {

    private Container<T> parent;
    private String name;

    public Workshop(int maxCars, String name){
        this.name = name;
        parent = new Container<T>(maxCars) {};
    }

    public void Load(T car){
        parent.Load(car);
    }

    public T Unload(int pos) {
        return parent.Unload(pos);
    }
}
