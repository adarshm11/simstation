package PrisonersDilemma;

import simstation.*;
import java.util.Random;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy myPrisonerStrategy;

    public Prisoner(Strategy strategy) {
        myPrisonerStrategy = strategy;
    }

    public boolean cooperate() {
        return myPrisonerStrategy.cooperate();
    }

    public void updateFitness(int amount) {
        fitness += amount;
    }

    public void setPartnerCheated(boolean cheated) {
        partnerCheated = cheated;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }

    public int getFitness() {
        return fitness;
    }

    public void update() {
        // must be implemented
    }

    // Other methods as needed
}
