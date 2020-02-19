package Graphics;

import modules.Car;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CarVisual {
    public BufferedImage image;
    public Point position;
    public Car car;

    public CarVisual(BufferedImage image, Point position, Car car){
        this.image = image;
        this.position = position;
        this.car = car;
    }
}
