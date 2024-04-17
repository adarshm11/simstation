package PrisonersDilemma;

import simstation.*;
import mvc.*;

public class PrisonerDilemmaFactory extends SimStationFactory {

    public Model makeModel(){
        return new PrisonerDilemmaSimulation();
    }

    public String getTitle(){
        return "Prisoner's Dilemma Simulation";
    }
}
