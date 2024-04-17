package PrisonersDilemma;

import mvc.Model;
import mvc.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrisonerDilemmaSimulation extends Model {
    private List<Prisoner> prisoners;
    private int gridSize;

    public PrisonerDilemmaSimulation(int gridSize) {
        this.gridSize = gridSize;
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

}