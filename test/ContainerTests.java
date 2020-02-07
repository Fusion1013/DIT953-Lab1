import modules.*;

import java.awt.*;

public class ContainerTests {
    public void TestContainer(){
        Volvo240 car = new Volvo240();

        TestFerry(car);
        TestCarTransport(car);
        TestWorkshop(car);
    }

    private void TestFerry(Car car){
        CarFerry ferry = new CarFerry(16);

        ferry.Load(car);
    }

    private void TestCarTransport(Car car){
        CarTransport transport = new CarTransport(2, Color.green, 100, "TestModel");

        transport.Load(car);
    }

    private void TestWorkshop(Car car){
        Workshop workshop = new Workshop(10, "Mekonomen");

        workshop.Load(car);
    }
}
