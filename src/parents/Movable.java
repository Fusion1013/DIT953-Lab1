package parents;

import interfaces.IMovable;
import modules.Vector2;

public class Movable implements IMovable {

    public double speed = 0;
    public Vector2 position = new Vector2(0, 0);
    public Vector2 direction = new Vector2(1, 0);

    @Override
    public void move() {
        position = Vector2.Add(Vector2.Scale(direction, speed), position);
    }

    @Override
    public void turnLeft() {
        if (direction.y != 0) direction = new Vector2(-direction.y, -direction.x);
        else direction = new Vector2(direction.y, direction.x);
    }

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
}
