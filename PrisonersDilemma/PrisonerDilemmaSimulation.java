package PrisonersDilemma;

import mvc.*;
import java.util.*;
import simstation.*;

public class PrisonerDilemmaSimulation extends Simulation {
    private List<Prisoner> prisoners;
    private int gridSize;

    public PrisonerDilemmaSimulation() {
        prisoners = new ArrayList<>();

        // Initialize prisoners with random strategies
        initializePrisoners();
    }

    private void initializePrisoners() {
        Random random = new Random();

        // Create prisoners with random strategies
        for (int i = 0; i < gridSize * gridSize; i++) {
            Strategy strategy;
            switch (random.nextInt(4)) {
                case 0:
                    strategy = new Cooperate();
                    break;
                case 1:
                    strategy = new Cheat();
                    break;
                case 2:
                    strategy = new Tit4Tat();
                    break;
                default:
                    strategy = new Cooperate();
            }
            prisoners.add(new Prisoner(strategy));
        }
    }

    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new PrisonerDilemmaFactory());
        panel.display();
    }

}