package parents;

import interfaces.IContainer;

import java.util.ArrayList;
import java.util.List;

/***
 * Container that holds objects of type T that extends Transportable.
 * Contains the basic implementation of the Load and Unload methods
 * @param <T> Specifies the objects the container can hold
 */
public class Container<T extends Transportable> implements IContainer<T> {
    private List<T> stored = new ArrayList<T>();
    private int capacity;

    /***
     * Instantiates the container with a max capacity
     * @param capacity The max number of objects the container can hold
     */
    public Container(int capacity){
        this.capacity = capacity;
    }

    /***
     * Loads the loadable if the capacity has not been reached
     * @param loadable Loadable to load
     */
    @Override
    public void Load(T loadable) {
        if (stored.size() < capacity){
            stored.add(loadable);
        }
        else{
            throw new IllegalArgumentException("Capacity Reached");
        }
    }

    /***
     * Unloads the loadable at the position
     * @param pos Position to remove at
     * @return Unloaded object
     */
    @Override
    public T Unload(int pos) {
        try{
            return stored.remove(pos);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /***
     * Returns a list of the stored loadables
     * @return Stored loadables
     */
    public List<T> GetStored(){
        return stored;
    }
}
