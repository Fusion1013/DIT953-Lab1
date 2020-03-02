package modules;

import interfaces.ControllerListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarEditorController extends JFrame {

    private List<ControllerListener> controllerListeners = new ArrayList<>();

    private int X = 400;
    private int Y = 400;
    private int spawnY = 0;

    JPanel controlPanel = new JPanel();
    JButton addButton = new JButton("Add");
    JButton removeButton = new JButton("Remove");
    JSpinner spinner = new JSpinner();

    String[] carStrings = {"Volvo", "Saab", "Scania"};
    JComboBox carList = new JComboBox(carStrings);

    public CarEditorController(String framename){
        initComponents(framename);
    }

    public void addControllerListener(ControllerListener listener){
        controllerListeners.add(listener);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Adds Buttons
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        400, //max
                        1);//step
        spinner = new JSpinner(spinnerModel);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                spawnY = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(addButton, 0);
        controlPanel.add(removeButton, 1);
        controlPanel.add(carList, 2);
        controlPanel.add(spinner, 3);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerListener listener : controllerListeners){
                    if (carList.getSelectedIndex() == 0) listener.addVolvo(0, spawnY);
                    else if (carList.getSelectedIndex() == 1) listener.addSaab(0, spawnY);
                    else if (carList.getSelectedIndex() == 2) listener.addScania(0, spawnY);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllerListener listener : controllerListeners){
                    listener.removeCar(0);
                }
            }
        });

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
