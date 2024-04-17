package PrisonersDilemma;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class PrisonerDilemmaView extends View {
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

    @Override
    public void updateView() {
        // Update displayPanel and statisticsLabel based on model data
    }
}
