package Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MovableImage {
    private BufferedImage image;
    private Point point;
    private String id;

    public MovableImage(BufferedImage image, Point point, String id){
        this.image = image;
        this.point = point;
        this.id = id;
    }

    public BufferedImage getImage(){
        return image;
    }

    public Point getPoint(){
        return new Point(point);
    }

    public void setPoint(Point point){
        this.point = new Point(point);
    }

    public String getId(){
        return id;
    }
}
