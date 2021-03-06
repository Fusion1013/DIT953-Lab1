package modules.car;

import modules.Vector2;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    /***
     * Creates a new modules.car.Saab95
     */
    public Saab95(){
        super(2, Color.red, 125, "modules.car.Saab95");
	    turboOn = false;
    }

    /***
     * Creates a new modules.car.Saab95
     */
    public Saab95(Vector2 startPos){
        super(2, Color.red, 125, "modules.car.Saab95", startPos);
        turboOn = false;
    }

    /***
     * Turns on the turbo
     */
    public void setTurboOn(){
	    turboOn = true;
        super.incrementSpeed(0);
    }

    /***
     * Turns off the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
        super.incrementSpeed(0);
    }

    /***
     * Returns the speed factor of the car
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
