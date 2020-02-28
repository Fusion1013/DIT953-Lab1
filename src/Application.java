import Graphics.CarModel;
import Graphics.CarController;
import Graphics.DrawView;
import modules.*;

public class Application {

    private static final int X = 800;
    private static final int Y = 800;

    public static void main(String[] args) {
        DrawView view = new DrawView(X, Y-240);

        CarController controller = new CarController("CarSim 1.01", view, X, Y);
        CarModel cc = new CarModel();

        cc.addUpdateListener(view);
        controller.addControllerListener(cc);

        cc.cars.add(new Volvo240(new Vector2(0, 0)));
        cc.cars.add(new Saab95(new Vector2(0, 100)));
        cc.cars.add(new Scania(new Vector2(0, 200)));

        // Start a new view and send a reference of self
    }
}
