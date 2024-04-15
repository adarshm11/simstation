package simstation;

import mvc.*;

import java.awt.*;
import java.util.List;

public class SimulationView extends View {

    public SimulationView(Model model) {
        super(model);
    }


    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation simulation = (Simulation) model;


        // Draw each agent
        for (Agent agent : simulation.agents) {
            drawAgent(gc, agent);
        }
    }

    public void update() {
        repaint();
    }

    private void drawAgent(Graphics gc, Agent agent) {
        // Drawing the agent as a dot
        gc.setColor(Color.WHITE);
        gc.fillOval(agent.xc, agent.yc, 10, 10);
    }
}