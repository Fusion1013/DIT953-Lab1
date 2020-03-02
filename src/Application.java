import modules.car.CarModel;
import modules.CarController;
import Graphics.DrawView;

public class Application {

    private static final int X = 800;
    private static final int Y = 800;

    public static void main(String[] args) {
        DrawView view = new DrawView(X, Y-240);
        CarController controller = new CarController("CarSim 1.01", view, X, Y);
        CarModel model = new CarModel();

        model.addUpdateListener(view);
        controller.addControllerListener(model);

        model.addVolvo(0, 0);
        model.addSaab(0, 100);
        model.addScania(0, 200);
    }
}
