package parents;

import interfaces.IContainer;

import java.util.ArrayList;
import java.util.List;

public class Container<T extends Transportable> implements IContainer<T> {
    private List<T> stored = new ArrayList<T>();
    private int capacity;

    public Container(int capacity){
        this.capacity = capacity;
    }

    @Override
    public void Load(T loadable) {
        if (stored.size() < capacity){
            stored.add(loadable);
        }
        else{
            throw new IllegalArgumentException("Capacity Reached");
        }
    }

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

    public List<T> GetStored(){
        return stored;
    }
}
