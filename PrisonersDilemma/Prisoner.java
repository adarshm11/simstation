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
        // Update strategy or fitness based on the outcome of the last interaction
        if (partnerCheated) {
            // If partner cheated, adjust strategy or fitness accordingly
            if (myPrisonerStrategy instanceof Tit4Tat) {
                Tit4Tat tit4TatStrategy = (Tit4Tat) myPrisonerStrategy;
                boolean lastMove = tit4TatStrategy.cooperate();
                if (!lastMove) {
                    updateFitness(5);
                }
            }
        }
        partnerCheated = false;
    }

}
