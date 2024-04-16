package Plague;


import mvc.Utilities;
import simstation.*;

import java.awt.*;

public class PlagueAgent extends Agent {

    public boolean infected;
    public int test = 0;
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

        if (neighbor != null && neighbor.infected == true){

            if (infected == false){
                boolean changeInfect = Utilities.rng.nextInt(100) < PlagueSimulation.RESISTANCE;
                if (changeInfect == false){
                    this.infected = true;
                    color = Color.RED;
                    PlagueSimulation.numInfected++;
                }
            }
        }


        heading = Heading.random();
        int steps = Utilities.rng.nextInt(2) + 1;
        move(steps);
    }
}
