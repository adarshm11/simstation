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
        List<Agent> agents = simulation.getAgents();

        // Draw each agent
        for (Agent agent : agents) {
            drawAgent(gc, agent);
        }
    }

    private void drawAgent(Graphics gc, Agent agent) {
        // Drawing the agent as a dot
        gc.setColor(Color.BLACK);
        gc.fillOval(agent.getX(), agent.getY(), 5, 5);
    }
}