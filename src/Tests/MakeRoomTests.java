package Tests;

import Alarm.Room;
import Listeners.MonitorA;
import Listeners.MonitorB;
import Sensors.FireSensor;
import Sensors.GasSensor;
import Sensors.RadiationSensor;
import Sensors.SensorNotCompatibleException;

import java.util.ArrayList;
import java.util.List;

public class MakeRoomTests {

    private List<Room> roomList                       ;
    private List<FireSensor> fireSensorList           ;
    private List<GasSensor> gasSensorList             ;
    private List<RadiationSensor> radiationSensorsList;
    private int nb_sensors = 10;
    private MonitorA monitorA;
    private MonitorB monitorB;

    public MonitorA getMonitorA() {
        return monitorA;
    }

    public MonitorB getMonitorB() {
        return monitorB;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<FireSensor> getFireSensorList() {
        return fireSensorList;
    }

    public List<GasSensor> getGasSensorList() {
        return gasSensorList;
    }

    public List<RadiationSensor> getRadiationSensorsList() {
        return radiationSensorsList;
    }

    public int getNb_sensors() {
        return nb_sensors;
    }

    public MakeRoomTests() {

        roomList = new ArrayList<>();
        fireSensorList = new ArrayList<>();
        gasSensorList = new ArrayList<>();
        radiationSensorsList = new ArrayList<>();

        MonitorA monitorA = new MonitorA();
        MonitorB monitorB = new MonitorB();

        for (int i = 0 ; i < nb_sensors ; i++) {
            roomList.add(new Room("C" + 200 + i));
            fireSensorList.add(new FireSensor("FireDetector" + i, roomList.get(i)));
            gasSensorList.add(new GasSensor("GasSensor" + i, roomList.get(i)));
            radiationSensorsList.add(new RadiationSensor("RadiationSensor" + i, roomList.get(i)));

            try {
                fireSensorList.get(i).addListener(monitorA);
                gasSensorList.get(i).addListener(monitorA);
                gasSensorList.get(i).addListener(monitorB);
                radiationSensorsList.get(i).addListener(monitorB);
            } catch (SensorNotCompatibleException e) {
                e.printStackTrace();
            }
        }
    }
}
