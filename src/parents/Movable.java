package parents;

import interfaces.IMovable;
import modules.Vector2;

/***
 * Creates a new Movable object
 * Contains basic implementation for turning and moving by direction and speed
 */
public class Movable implements IMovable {

    /***
     * @param speed The speed of the object
     */
    public double speed = 0;

    /***
     * @param position The position of the object
     */
    public Vector2 position = new Vector2(0, 0);

    /***
     * @param direction The direction of the object
     */
    public Vector2 direction = new Vector2(1, 0);

    /***
     * Moves the Movable in the direction and speed of the object
     */
    @Override
    public void move() {
        position = Vector2.Add(Vector2.Scale(direction, speed), position);
    }

    /***
     * Turns the Movable to the left by 90 degrees
     */
    @Override
    public void turnLeft() {
        if (direction.y != 0) direction = new Vector2(-direction.y, -direction.x);
        else direction = new Vector2(direction.y, direction.x);
    }

    /***
     * Turns the Movable to the right by 90 degrees
     */
    @Override
    public void turnRight() {
        if (direction.x != 0) direction = new Vector2(-direction.y, -direction.x);
        else direction = new Vector2(direction.y, direction.x);
    }

    @Override
    public void incrementSpeed(double amount) {
        speed += amount;
    }

    @Override
    public void decrementSpeed(double amount) {
        speed -= amount;
    }

    public void setSpeed(double amount) {
        speed = amount;
    }
}
