import modules.car.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SubCarTests {

    @Test
    public void TestSpeed(){
        TestBrake(new Volvo240());
        TestGas(new Volvo240());

        TestBrake(new Saab95());
        TestGas(new Saab95());
    }

    private void TestGas(Car car){
        double speed = car.getCurrentSpeed();
        car.gas(0.1);
        assertTrue(speed < car.getCurrentSpeed() || car.getCurrentSpeed() == car.getEnginePower());

        speed = car.getCurrentSpeed();
        car.gas(-10);
        assertTrue(speed == car.getCurrentSpeed());
    }

    private void TestBrake(Car car){
        double speed = car.getCurrentSpeed();
        car.brake(0.1);
        assertTrue(speed > car.getCurrentSpeed() || car.getCurrentSpeed() == 0);

        speed = car.getCurrentSpeed();
        car.brake(-10);
        assertTrue(speed == car.getCurrentSpeed());
    }

    // --- modules.car.Scania Tests --- //

    @Test
    public void TestBed(){
        Scania scania = new Scania();

        scania.startEngine();
        scania.IncreaseAngle(10);

        assertTrue(scania.getAngle() == 0);

        scania = new Scania();
        scania.IncreaseAngle(10);
        scania.startEngine();

        assertTrue(scania.getCurrentSpeed() == 0);

        scania = new Scania();
        scania.DecreaseAngle(10);
        assertTrue(scania.getAngle() == 0);
        scania.IncreaseAngle(100);
        assertTrue(scania.getAngle() == 70);
    }
    @Test
    public void TestWorkshop() {
        Workshop<Volvo240> ws = new Workshop<Volvo240>(10, "Mekonomen");

        Volvo240 v = new Volvo240();
        ws.Load(v);

        ws.Unload(100);

        Saab95 s = new Saab95();
    }
}
