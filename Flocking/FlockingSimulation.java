package Flocking;
import simstation.*;
import mvc.*;

public class FlockingSimulation extends Simulation {


    public void populate(){
       for (int i = 0; i < 15; i++){
           addAgents(new Bird());
       }
    }

    public String[] getStats(){
        String[] result = new String[5];
        for (int i = 0; i < 5; i++){
            result[i] = "#birds @ speed " + (i+1) + " = ";
            int counter = 0;
            for (Agent a : agents){
                Bird b = (Bird) a;
                if (b.speed == (i + 1)) counter++;
            }
            result[i] += counter;
        }
        return result;
    }

    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new FlockingFactory());
        panel.display();
    }
}
