import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /***
     * Creates a new Volvo240
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    /***
     * Returns the speed factor of the car
     * @return speed factor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /***
     * Increases the current speed by amount
     * @param amount The amount to increase the current speed by
     */
    @Override
    public void incrementSpeed(double amount){
        super.incrementSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /***
     * Decreases the current speed by amount
     * @param amount The amount to decrease the current speed by
     */
    @Override
    public void decrementSpeed(double amount){
        super.decrementSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}
