package Graphics;

import interfaces.UpdateListener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawView extends JPanel implements UpdateListener {

    private List<MovableImage> images = new ArrayList<>();

    // TODO: Make this general for all cars
    void moveImage(Point newPoint, String imageId){
        for (MovableImage image : images){
            if (image.getId().equals(imageId)){
                image.setPoint(newPoint);
                return;
            }
        }
    }

    // Initializes the panel and reads the images
    public DrawView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
    }

    // Adds an image
    private void addImage(BufferedImage image, Point point, String id){
        images.add(new MovableImage(image, point, id));
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MovableImage image : images){
            g.drawImage(image.getImage(), image.getPoint().x, image.getPoint().y, null);
        }
    }

    @Override
    public void objectMoved(Point newPoint, String id) {
        moveImage(newPoint, id);
        repaint();
    }

    @Override
    public void objectAdded(BufferedImage image, Point point, String id){
        addImage(image, new Point(point), id);
    }
}
