import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    /***
     * Creates a new Saab95
     */
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
	    turboOn = false;
    }

    /***
     * Turns on the turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /***
     * Turns off the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
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
