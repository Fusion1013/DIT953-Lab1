package interfaces;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface UpdateListener {
    public void objectMoved(Point newPoint, String id);

    public void objectAdded(BufferedImage image, Point point, String id);
}
