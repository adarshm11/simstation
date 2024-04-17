package PrisonersDilemma;

import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    protected Strategy strategy;

    public Prisoner(Strategy strategy) {
        super();
        this.strategy = strategy;
        this.strategy.myPrisoner = this;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void updateFitness(int amount) {
        fitness += amount;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }

    public int getFitness() {
        return fitness;
    }

    public void update() {
        Prisoner neighbor = (Prisoner) world.getNeighbor(this, 10);
        if (neighbor != null){
            boolean prisoner1 = this.cooperate();
            boolean prisoner2 = neighbor.cooperate();
            if (prisoner1 && prisoner2){
                this.updateFitness(3);
                neighbor.updateFitness(3);
                this.partnerCheated = false;
                neighbor.partnerCheated = false;
            }
            else if (prisoner1){
                neighbor.updateFitness(5);
                this.partnerCheated = true;
                neighbor.partnerCheated = false;
            }
            else if (prisoner2){
                this.updateFitness(5);
                this.partnerCheated = false;
                neighbor.partnerCheated = true;
            }
            else {
                this.updateFitness(1);
                neighbor.updateFitness(1);
                this.partnerCheated = true;
                neighbor.partnerCheated = true;
            }
        }
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}
