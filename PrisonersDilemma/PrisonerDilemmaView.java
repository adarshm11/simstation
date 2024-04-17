package PrisonersDilemma;

import mvc.*;
import simstation.*;

import javax.swing.*;
import java.awt.*;

public class PrisonerDilemmaView extends SimulationView {
    private Model model;
    private JPanel displayPanel;
    private JLabel statisticsLabel;

    public PrisonerDilemmaView(Model model) {
        super(model);
        this.model = model;

        displayPanel = new JPanel();
        statisticsLabel = new JLabel("Statistics");

        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.CENTER);
        add(statisticsLabel, BorderLayout.SOUTH);
    }

    /*
    @Override
    public void updateView() {
        for (Prisoner prisoner : model.getPrisoners()) {
            JLabel prisonerLabel = new JLabel(prisoner.toString());
            displayPanel.add(prisonerLabel);
        }
        
        // Repaint the displayPanel
        displayPanel.revalidate();
        displayPanel.repaint();
        
        // Update statisticsLabel
        String statistics = generateStatistics(); 
        statisticsLabel.setText(statistics);
    }


    private String generateStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Average Fitness:\n");
        for (Strategy strategy : model.getStrategies()) {
            int averageFitness = calculateAverageFitnessForStrategy(strategy);
            statistics.append(strategy.getClass().getSimpleName()).append(": ").append(averageFitness).append("\n");
        }
        return statistics.toString();
    }
    
    private int calculateAverageFitnessForStrategy(Strategy strategy) {
        int totalFitness = 0;
        int count = 0;
        for (Prisoner prisoner : model.getPrisoners()) {
            if (prisoner.getStrategy().equals(strategy)) {
                totalFitness += prisoner.getFitness();
                count++;
            }
        }
        return count > 0 ? totalFitness / count : 0;
    }

    */
}
