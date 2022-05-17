package Tests;

import java.time.LocalDateTime;

import Alarm.FireAlarm;
import Alarm.GasAlarm;
import Alarm.RadiationAlarm;
import Alarm.Room;
import Listeners.MonitorA;
import Listeners.MonitorB;
import Sensors.FireSensor;
import Sensors.GasSensor;
import Sensors.RadiationSensor;
import Sensors.SensorNotCompatibleException;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBackend {
    public static void main(String[] args) {
        int nb_sensors = 10;

        List<Room> roomList = new ArrayList<>();
        List<FireSensor> fireSensorList = new ArrayList<>();
        List<GasSensor> gasSensorList = new ArrayList<>();
        List<RadiationSensor> radiationSensorsList = new ArrayList<>();

        MonitorA monitorA = new MonitorA();
        MonitorB monitorB = new MonitorB();

        for (int i = 0; i < nb_sensors; i++) {
            roomList.add(new Room("C" + 200 + i));
            fireSensorList.add(new FireSensor("FireDectector" + i, roomList.get(i)));
            gasSensorList.add(new GasSensor("GasSensor" + i, roomList.get(i)));
            radiationSensorsList.add(new RadiationSensor("RadiationSensor1", roomList.get(i)));

            try {
                fireSensorList.get(i).addListener(monitorA);
                gasSensorList.get(i).addListener(monitorA);
                gasSensorList.get(i).addListener(monitorB);
                radiationSensorsList.get(i).addListener(monitorB);
            } catch (SensorNotCompatibleException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            TimeUnit timeUnit = TimeUnit.SECONDS;

            Random random = new Random();
            int i = random.nextInt(nb_sensors);
            FireSensor fireSensor = fireSensorList.get(i);
            FireAlarm fireAlarm = new FireAlarm(LocalDateTime.now(), fireSensor.getRoom(), random.nextInt(5), fireSensor);
            fireSensor.launchAlert(fireAlarm);

            RadiationSensor radiationSensor = radiationSensorsList.get(i);
            RadiationAlarm radiationAlarm = new RadiationAlarm(LocalDateTime.now(), radiationSensor.getRoom(), random.nextInt(5), random.nextInt(100), radiationSensor);
            radiationSensor.launchAlert(radiationAlarm);

            GasSensor gasSensor = gasSensorList.get(i);
            GasAlarm gasAlarm = new GasAlarm(LocalDateTime.now(), gasSensor.getRoom(), random.nextInt(5), "CO2", gasSensor);
            gasSensor.launchAlert(gasAlarm);

            try {
                timeUnit.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}