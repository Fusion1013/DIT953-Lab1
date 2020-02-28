package Graphics;

import interfaces.ControllerListener;
import interfaces.UpdateListener;
import modules.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel implements ActionListener, ControllerListener {
    // member fields:

    // A list of cars, modify if needed
    private ArrayList<Car> cars = new ArrayList<Car>();

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, this);

    List<UpdateListener> updateListeners = new ArrayList<>();

    //methods:

    public CarModel(){
        timer.start();
    }

    public void addVolvo(int x, int y){
        Volvo240 volvo = new Volvo240(new Vector2(x, y));
        cars.add(volvo);
        notifyObjectAdded(getImage("Volvo240"), new Point(x, y), volvo.getModelName());
    }
    public void addSaab(int x, int y){
        Saab95 saab = new Saab95(new Vector2(x, y));
        cars.add(saab);
        notifyObjectAdded(getImage("Saab95"), new Point(x, y), saab.getModelName());
    }
    public void addScania(int x, int y){
        Scania scania = new Scania(new Vector2(x, y));
        cars.add(scania);
        notifyObjectAdded(getImage("Scania"), new Point(x, y), scania.getModelName());
    }

    private void notifyObjectAdded(BufferedImage image, Point point, String id){
        for (UpdateListener listener : updateListeners){
            listener.objectAdded(image, point, id);
        }
    }

    private static BufferedImage getImage(String image){
        try {
            BufferedImage img = ImageIO.read(DrawView.class.getResourceAsStream("pics/" + image +".jpg"));
            return img;
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public void addUpdateListener(UpdateListener listener){
        updateListeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (Car car : cars) {
            car.move();
            int x = (int) Math.round(car.GetPosition().x);
            int y = (int) Math.round(car.GetPosition().y);

            // Updates Listeners
            for (UpdateListener listener : updateListeners){
                listener.objectMoved(new Point(x, y), car.getModelName());
            }
        }
    }

    // Calls the gas method for each car once
    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    // Calls the startEngine method for each car once
    @Override
    public void startEngines() {
        for (Car car : cars){
            car.startEngine();
        }
    }

    // Calls the stopEngine method for each car once
    void stopEngines() {
        for (Car car : cars){
            car.stopEngine();
        }
    }

    // Calls the turboOn method for each saab once
    void turboOn() {
        for (Car car : cars){
            if (car.getClass() == Saab95.class){
                Saab95 saab = (Saab95)car;
                saab.setTurboOn();
            }
        }
    }

    // Calls the turboOff method for each saab once
    void turboOff() {
        for (Car car : cars){
            if (car.getClass() == Saab95.class){
                Saab95 saab = (Saab95)car;
                saab.setTurboOff();
            }
        }
    }

    // Calls the DecreaseAngle method for each scania once
    void lowerBed() {
        for (Car car : cars){
            if (car.getClass() == Scania.class){
                Scania scania = (Scania)car;
                scania.DecreaseAngle(70);
            }
        }
    }

    // Calls the IncreaseAngle method for each scania once
    void liftBed() {
        for (Car car : cars){
            if (car.getClass() == Scania.class){
                Scania scania = (Scania)car;
                scania.IncreaseAngle(70);
            }
        }
    }
}
