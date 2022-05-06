package Tests;
import Alarm.Room;
import Sensors.FireSensor;
import Sensors.GasSensor;
import Sensors.RadiationSensor;

public class TestBackend {
    public static void main(String[] args) {
        Room room0 = new Room("C200");
        Room room1 = new Room("C201");
        Room room2 = new Room("C202");
        Room room3 = new Room("C203");
        Room room4 = new Room("C204");
        Room room5 = new Room("C205");
        Room room6 = new Room("C206");
        Room room7 = new Room("C207");
        Room room8 = new Room("C208");
        Room room9 = new Room("C209");

        FireSensor fireSensor0 = new FireSensor("FireDectector0", room0);
        FireSensor fireSensor1 = new FireSensor("FireDectector1", room1);
        FireSensor fireSensor2 = new FireSensor("FireDectector2", room2);
        FireSensor fireSensor3 = new FireSensor("FireDectector3", room3);
        FireSensor fireSensor4 = new FireSensor("FireDectector4", room4);
        FireSensor fireSensor5 = new FireSensor("FireDectector5", room5);
        FireSensor fireSensor6 = new FireSensor("FireDectector6", room6);
        FireSensor fireSensor7 = new FireSensor("FireDectector7", room7);
        FireSensor fireSensor8 = new FireSensor("FireDectector8", room8);
        FireSensor fireSensor9 = new FireSensor("FireDectector9", room9);

        GasSensor gasSensor0 = new GasSensor("GasSensor0", room0);
        GasSensor gasSensor1 = new GasSensor("GasSensor1", room1);
        GasSensor gasSensor2 = new GasSensor("GasSensor2", room2);
        GasSensor gasSensor3 = new GasSensor("GasSensor3", room3);
        GasSensor gasSensor4 = new GasSensor("GasSensor4", room4);
        GasSensor gasSensor5 = new GasSensor("GasSensor5", room5);
        GasSensor gasSensor6 = new GasSensor("GasSensor6", room6);
        GasSensor gasSensor7 = new GasSensor("GasSensor7", room7);
        GasSensor gasSensor8 = new GasSensor("GasSensor8", room8);
        GasSensor gasSensor9 = new GasSensor("GasSensor9", room9);

        RadiationSensor radiationSensor0 = new RadiationSensor("RadiationSensor0", room0);
        RadiationSensor radiationSensor1 = new RadiationSensor("RadiationSensor1", room1);
        RadiationSensor radiationSensor2 = new RadiationSensor("RadiationSensor2", room2);
        RadiationSensor radiationSensor3 = new RadiationSensor("RadiationSensor3", room3);
        RadiationSensor radiationSensor4 = new RadiationSensor("RadiationSensor4", room4);
        RadiationSensor radiationSensor5 = new RadiationSensor("RadiationSensor5", room5);
        RadiationSensor radiationSensor6 = new RadiationSensor("RadiationSensor6", room6);
        RadiationSensor radiationSensor7 = new RadiationSensor("RadiationSensor7", room7);
        RadiationSensor radiationSensor8 = new RadiationSensor("RadiationSensor8", room8);
        RadiationSensor radiationSensor9 = new RadiationSensor("RadiationSensor9", room9);


    }
}
