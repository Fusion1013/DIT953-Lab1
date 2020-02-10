import modules.CarFerry;
import modules.Vector2;
import modules.Volvo240;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovableTests {

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
    @Test
    public void TestIncrement(){
        CarFerry ferry = new CarFerry(0);

        double speedbefore = ferry.getCurrentSpeed();
        ferry.incrementSpeed(1);
        double speedafter = ferry.getCurrentSpeed();

        assertTrue(speedafter > speedbefore);

        speedbefore = ferry.getCurrentSpeed();
        ferry.decrementSpeed(1);
        speedafter = ferry.getCurrentSpeed();

        assertTrue(speedafter < speedbefore);
    }

}
