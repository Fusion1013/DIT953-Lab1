import modules.Saab95;
import modules.Vector2;
import modules.Volvo240;
import modules.Workshop;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CarTests {

    @Test
    public void TestWorkshop() {
        Workshop<Volvo240> ws = new Workshop<Volvo240>(10, "Mekonomen");

        Volvo240 v = new Volvo240();
        ws.Load(v);

        ws.Unload(100);

        Saab95 s = new Saab95();
    }

    @Test
    public void TestTurn(){
        Volvo240 car = new Volvo240();

        car.turnRight();
        assertTrue(car.GetDirection().x == 0 && car.GetDirection().y == -1);

        car = new Volvo240();

        car.turnLeft();
        assertTrue(car.GetDirection().x == 0 && car.GetDirection().y == 1);
    }

    @Test
    public void TestMove(){
        Volvo240 car = new Volvo240();

        Vector2 pos = car.GetPosition();
        car.startEngine();
        car.move();

        assertTrue(car.GetPosition().x == pos.x + car.getCurrentSpeed());
    }
}
