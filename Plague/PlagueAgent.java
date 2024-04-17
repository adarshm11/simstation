package Plague;

import mvc.*;
import simstation.*;
import java.awt.*;

public class PlagueAgent extends Agent {

    public boolean infected;
    public PlagueAgent(boolean infected){
        super();
        this.infected = infected;
        heading = Heading.random();
        if (infected){
            color = Color.RED;
        }
        else{
            color = Color.GREEN;
        }

    }
    public void update(){

        PlagueAgent neighbor = (PlagueAgent) world.getNeighbor(this, 1);

        if (neighbor != null && neighbor.infected){

            if (!infected){
                boolean changeInfect = Utilities.rng.nextInt(100) < PlagueSimulation.RESISTANCE;
                if (!changeInfect){
                    this.infected = true;
                    color = Color.RED;
                    PlagueSimulation.numInfected++;
                }
            }
        }
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}
