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
}
