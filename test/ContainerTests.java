import modules.car.Car;
import modules.car.Volvo240;
import org.junit.Test;
import parents.Container;

import static org.junit.Assert.assertTrue;

public class ContainerTests {
    @Test
    public void TestContainer(){

        Volvo240 car = new Volvo240();
        Container<Car> container = new Container<Car>(10);

        // Loading Container
        container.Load(car);
        assertTrue(container.GetStored().size() == 1);

        container.Unload(100); // Should give error

        // Unloading Container
        Car car1 = container.Unload(0);
        assertTrue(car1 == car);
    }


}
