package Plague;

import simstation.*;
import mvc.*;

import java.nio.file.FileSystemNotFoundException;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int numInfected = 0;
    // etc.

    public void populate(){
        for (int i = 0; i < 5; i++){
            boolean infected = Utilities.rng.nextInt(100) < VIRULENCE;
            if (infected == true){
                numInfected++;
            }
            addAgents(new PlagueAgent(infected));

        }

    }

    public String[] getStats(){
        String[] result = new String[3];
        result[0] = "#agents = " + agents.size();
        result[1] = "clock = " + clock;
        result[2] = "%infected = " + ((double)numInfected / agents.size()) * 100;
        return result;
    }

    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new PlagueFactory());
        panel.display();
    }
}