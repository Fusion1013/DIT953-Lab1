package interfaces;

public interface IMovable {
    /***
     * Moves the movable in the direction
     */
    void move();

    /***
     * Turns the movable to the left
     */
    void turnLeft();
    /***
     * Turns the movable to the right
     */
    void turnRight();

    /***
     * Increases the speed by amount
     * @param amount Amount of which to increase the speed by
     */
    void incrementSpeed(double amount);

    /***
     * Decreases the speed by amount
     * @param amount Amount of which to decrease the speed by
     */
    void decrementSpeed(double amount);
}
