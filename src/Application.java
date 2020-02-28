import Graphics.CarModel;
import Graphics.CarController;
import Graphics.DrawView;
import modules.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Application {

    private static final int X = 800;
    private static final int Y = 800;

    public static void main(String[] args) {
        DrawView view = new DrawView(X, Y-240);

        CarController controller = new CarController("CarSim 1.01", view, X, Y);
        CarModel cc = new CarModel();

        cc.addUpdateListener(view);
        controller.addControllerListener(cc);

        cc.addVolvo(0, 0);
        cc.addSaab(0, 100);
        cc.addScania(0, 200);

        // Start a new view and send a reference of self
    }
}
