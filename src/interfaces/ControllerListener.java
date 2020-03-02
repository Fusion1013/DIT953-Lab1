package interfaces;

public interface ControllerListener {
    public void startEngines();

    public void gas(int amount);

    public void brake(int amount);

    public void stopEngines();

    public void turboOn();

    public void turboOff();

    public void liftBed();

    public void lowerBed();

    public void addVolvo(int x, int y);

    public void addSaab(int x, int y);

    public void addScania(int x, int y);

    public void removeCar(int pos);
}
