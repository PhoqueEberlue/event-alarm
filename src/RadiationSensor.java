public class RadiationSensors extends Sensors{

//----------CONSTRUCTORS----------
    public CaptRadiations(String name, String room, int valMax, int valMin){
        this.unit = "Becquerel";
        this.name = name;
        this.room = room;
        this.valMax = valMax;
        this.valMin = valMin;
    }

    public CaptRadiations(String name, String room){
        this.unit = unit;
        this.name = name;
        this.room = room;
        this.valMax = 1000;
        this.valMin = 0;
    }

//----------TO STRING----------
    @java.lang.Override
    public java.lang.String toString() {
        return "RadiationSensor{}";
    }
//----------GETTER----------
    public String getRoom(){
        return this.room;
    }

    public String getUnit(){
        return this.unit;
    }

    public String getValMax(){
        return this.valMax;
    }
    public String getValMin(){
        return this.;
    }
    public String getName(){
        return this.name;
    }
}