import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private static double turnAngle = Math.PI / 6;
    private double currentAngle = 0;

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
        currentSpeed = amount;
    }

    /***
     * Decreases the current speed by amount
     * @param amount The amount to decrease the current speed by
     */
    public void decrementSpeed(double amount){
        currentSpeed = amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    /***
     * Moves the car in the direction by speed
     */
    public void move(){
        pos = new Vector2(direction.x * currentSpeed + pos.x, direction.y * currentSpeed + pos.x);
    }

    /***
     * Turns the car to the left by turn angle
     */
    public void turnLeft(){
        currentAngle += turnAngle;
        direction = CalculateDirection(currentAngle);
    }

    /***
     * Turns the car to the right by turn angle
     */
    public void turnRight(){
        currentAngle -= turnAngle;
        direction = CalculateDirection(currentAngle);
    }

    /***
     * Calculates the direction of the car by the given angle
     * @param angle the angle of which the car is travelling in
     * @return the direction of which the car is travelling in
     */
    private Vector2 CalculateDirection(double angle){
        double x = Math.cos(angle);
        double y = Math.sin(angle);

        return new Vector2(x, y);
    }
}
