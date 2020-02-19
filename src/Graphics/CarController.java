package Graphics;

import modules.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<Car>();

    Volvo240 volvo;
    Saab95 saab;
    Scania scania;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(new Vector2(0, 0)));
        cc.cars.add(new Saab95(new Vector2(0, 100)));
        cc.cars.add(new Scania(new Vector2(0, 200)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                double posX = car.GetPosition().x;
                double posY = car.GetPosition().y;

                double carWidth = frame.drawPanel.volvoImage.getWidth();
                double carHeight = frame.drawPanel.volvoImage.getHeight();

                // Collision
                if ((posX >= frame.getWidth() - carWidth || posX < 0) || (posY >= frame.getHeight() - carHeight || posY < 0)){
                    // Turns 180 degrees
                    car.turnLeft();
                    car.turnLeft();

                    car.move();

                    car.stopEngine();
                    car.startEngine();
                }

                car.move();
                int x = (int) Math.round(car.GetPosition().x);
                int y = (int) Math.round(car.GetPosition().y);

                if (car.getClass() == Volvo240.class) frame.drawPanel.moveVolvo(x, y);
                if (car.getClass() == Saab95.class) frame.drawPanel.moveSaab(x, y);
                if (car.getClass() == Scania.class) frame.drawPanel.moveScania(x, y);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
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
}
