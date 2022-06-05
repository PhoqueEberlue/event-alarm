# event-alarm
This is a student project to manage a system of alarm inside a building.  

## Structure 
Each set of class is inside its own folder within `./src`. 
You can find the UML [here](./img/diagram_with_methods.png "uml")

### Rooms
Since this project is supposed to be running inside a building, we decided to part the building in 
rooms. A room only has a name.

### Alarms
All alarms inherit from the abstract class `EventAlarm`. There is a handful type of alarms : gas, fire and radiation.
All alarms have a location (in which room has the alarm been triggered) a priority level and is 
inside a room.
All alarm are being listened by a sensor.


### Sensors
All sensors inherit from the abstract class `Sensors`. Like alarm, there are 3 types of sensor. 
Sensors have a name, values that are being read and a tolerance interval and a unit for those. 
A sensor also belongs to a room.

### Listeners 
There are 2 listener : MonitorA and B. MonitorA listens for Fire and Gas alarms, and MonitorB listens for Gas and Radiation alarms.


## gui interface : 
The gui is composed of 3 tabs : 
* alarm, it is used to trigger alarms. You can choose the type on the first screen. Upon submitting, 
it brings you to the next page, choosing date, priority of the alarm and which sensor detected it.
* alarm monitor, which indicates which alarm have been received but not dispateched yet. It acts like a stack,
where somebody will have to manually dispatch alarms received. An alarm can only be dispatched after being reviewed. 
* monitor, where one can watch the state of each room : wether there is a current ongoing alarm, the severity and the location.

## Tests 
All tests have been done inside the `Tests` folder. There are there tests for the backend, for making each room and a `Main` file, 
where the current version of the app resides. 

## Toolset 
We used IntelIJ to make this application and the UML diagram.
