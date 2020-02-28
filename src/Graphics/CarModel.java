package Graphics;

import interfaces.ControllerListener;
import interfaces.UpdateListener;
import modules.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public ArrayList<Car> cars = new ArrayList<Car>();

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

    public void addUpdateListener(UpdateListener listener){
        updateListeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (Car car : cars) {
            double posX = car.GetPosition().x;
            double posY = car.GetPosition().y;

            // double carWidth = frame.drawPanel.volvoImage.getWidth();
            // double carHeight = frame.drawPanel.volvoImage.getHeight();

            /*
            // Collision
            if ((posX >= frame.getWidth() - carWidth || posX < 0) || (posY >= frame.getHeight() - carHeight || posY < 0)){
                // Turns 180 degrees
                car.turnLeft();
                car.turnLeft();

                car.move();

                car.stopEngine();
                car.startEngine();
            }

             */

            car.move();
            int x = (int) Math.round(car.GetPosition().x);
            int y = (int) Math.round(car.GetPosition().y);
/*
            if (car.getClass() == Volvo240.class) frame.drawPanel.moveVolvo(x, y);
            if (car.getClass() == Saab95.class) frame.drawPanel.moveSaab(x, y);
            if (car.getClass() == Scania.class) frame.drawPanel.moveScania(x, y);

 */

            // repaint() calls the paintComponent method of the panel
            // frame.drawPanel.repaint();
        }

        for (UpdateListener listener : updateListeners){
            listener.updateView();
        }
    }

    @Override
    public void gas(double amount) {
        for (Car car : cars){
            car.gas(amount);
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ap1");
            /*
             */
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
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
    void startEngines() {
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
