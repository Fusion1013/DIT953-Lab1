import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {

    private List<T> storedCars = new ArrayList<T>();
    private int maxCars;
    private String name;

    public Workshop(int maxCars, String name){
        this.maxCars = maxCars;
        this.name = name;
    }

    public void LoadCar(T car){
        if (storedCars.size() < maxCars){
            storedCars.add(car);
        }
    }

    public T UnloadCar(int pos){
        try{
            return storedCars.remove(pos);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
