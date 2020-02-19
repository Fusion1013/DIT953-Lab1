package modules;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /***
     * Creates a new modules.Volvo240
     */
    public Volvo240(){
        super(4, Color.black, 100, "modules.Volvo240");
    }

    /***
     * Creates a new modules.Volvo240
     */
    public Volvo240(Vector2 startPos){
        super(4, Color.black, 100, "modules.Volvo240", startPos);
    }

    /***
     * Returns the speed factor of the car
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
