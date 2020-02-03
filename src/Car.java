import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private Vector2 pos;
    private Vector2 direction;

    /***
     * Creates a new basic car, with no extra specifications
     * @param nrDoors the number of doors of the car
     * @param color the color of the car
     * @param enginePower the cars engine power
     * @param modelName the model name of the car
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        direction = new Vector2(1, 0);
        pos = new Vector2(0, 0);
        stopEngine();
    }

    /***
     * Returns the number of doors
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /***
     * Returns the cars engine power
     * @return engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /***
     * Returns the current speed of the car
     * @return current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /***
     * Returns the color of the car
     * @return color
     */
    public Color getColor(){
        return color;
    }

    /***
     * Sets the color of the car
     * @param clr color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /***
     * Starts the cars engine
     * Sets the current speed of the car to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /***
     * Stops the cars engine
     * Sets the current speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /***
     * Returns the speed factor of the car
     * @return speed factor
     */
    public double speedFactor(){
        return 0.0;
    }

    /***
     * Increases the current speed by amount
     * @param amount The amount to increase the current speed by
     */
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /***
     * Decreases the current speed by amount
     * @param amount The amount to decrease the current speed by
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() - speedFactor() * amount, getEnginePower());
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) return;
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) return;
        decrementSpeed(amount);
    }

    /***
     * Moves the car in the direction by speed
     */
    public void move(){
        pos = Vector2.Add(Vector2.Scale(direction, currentSpeed), pos);
    }

    /***
     * Turns the car to the left by 90 degrees
     */
    public void turnLeft(){
        if (direction.y != 0) direction = new Vector2(-direction.y, -direction.x);
        else direction = new Vector2(direction.y, direction.x);
    }

    /***
     * Turns the car to the right by 90 degrees
     */
    public void turnRight(){
        if (direction.x != 0) direction = new Vector2(-direction.y, -direction.x);
        else direction = new Vector2(direction.y, direction.x);
    }

    public Vector2 GetPosition(){
        return pos;
    }

    public Vector2 GetDirection(){
        return direction;
    }
}
