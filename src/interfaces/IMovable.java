package interfaces;

public interface IMovable {
    /***
     * Moves the car in the direction
     */
    void move();

    /***
     * Turns the car to the left by the angle
     */
    void turnLeft();
    /***
     * Turns the moveable to the right by the angle
     */
    void turnRight();

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);
}
