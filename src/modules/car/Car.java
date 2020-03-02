package modules.car;

import interfaces.IMovable;
import modules.Vector2;
import parents.Movable;
import parents.Transportable;

import java.awt.*;

public abstract class Car extends Transportable implements IMovable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private Movable parent = new Movable();

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
        parent.direction = new Vector2(1, 0);
        parent.position = new Vector2(0, 0);
        stopEngine();
    }

    /***
     * Creates a new basic car, with no extra specifications
     * @param nrDoors the number of doors of the car
     * @param color the color of the car
     * @param enginePower the cars engine power
     * @param modelName the model name of the car
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName, Vector2 startPos){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        parent.direction = new Vector2(1, 0);
        parent.position = startPos;
        stopEngine();
    }

    public String getModelName(){
        return modelName;
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
        return parent.speed;
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
         parent.speed = 0.1;
    }

    /***
     * Stops the cars engine
     * Sets the current speed to 0
     */
    public void stopEngine(){
        parent.speed = 0;
    }

    /***
     * Returns the speed factor of the car
     * @return speed factor
     */
    public double speedFactor(){
        return 1.0;
    }

    /***
     * Increases the current speed by amount
     * @param amount The amount to increase the current speed by
     */
    public void incrementSpeed(double amount){
        parent.setSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /***
     * Decreases the current speed by amount
     * @param amount The amount to decrease the current speed by
     */
    public void decrementSpeed(double amount){
        parent.setSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    /***
     * Makes sure the car doesn't accelerate to fast
     * @param amount
     */
    public void gas(double amount){
        if (amount < 0 || amount > 1) return;
        incrementSpeed(amount);
    }

    /***
     * Makes sure the car doesn't decelerate to fast
     * @param amount
     */
    public void brake(double amount){
        if (amount < 0 || amount > 1) return;
        decrementSpeed(amount);
    }

    /***
     * Moves the car in the direction by speed
     */
    public void move(){
        parent.move();
    }

    /***
     * Turns the car to the left by 90 degrees
     */
    public void turnLeft(){
        parent.turnLeft();
    }

    /***
     * Turns the car to the right by 90 degrees
     */
    public void turnRight(){
        parent.turnRight();
    }

    // ---- Getters/Setters ---- //

    /***
     * Gets the position of the car
     * @return
     */
    public Vector2 GetPosition(){
        return parent.position;
    }

    /***
     * Gets the direction of the car
     * @return
     */
    public Vector2 GetDirection(){
        return parent.direction;
    }

    /***
     * Sets the position of the car
     * @param pos
     */
    public void SetPosition(Vector2 pos){
        parent.position = pos;
    }
}
