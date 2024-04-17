package Flocking;
import simstation.*;
import mvc.*;

public class FlockingFactory extends SimStationFactory {

    public Model makeModel(){
        return new FlockingSimulation();
    }

    public String getTitle(){
        return "Flocking Simulator";
    }
}
