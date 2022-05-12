package Sensors;

public class SensorNotCompatibleException extends Exception {
    public SensorNotCompatibleException(String errorMessage) {
        super(errorMessage);
    }
}
