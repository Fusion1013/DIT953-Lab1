package modules;

import interfaces.IContainer;
import parents.Container;
public class Workshop<T extends Car> {

    private Container<T> parent;
    private String name;
    /***
     * creates a workshop
     * @param maxCars a specified int to assign max capacity to the workshop
     * @param name The name of the workshop
     */

    public Workshop(int maxCars, String name){
        this.name = name;
        parent = new Container<T>(maxCars) {};
    }

    /***
     * loads a car into the workshop by using .add to the list
     * @param car the car added to the workshop
     */
    public void Load(T car){
        parent.Load(car);
    }

    /***
     * removes a car at the specified position
     * @param pos a int to discern which car to return
     * @return return the car at the given position
     */
    public T Unload(int pos) {
        return parent.Unload(pos);
    }
}
