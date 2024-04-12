package RandomWalks;


import mvc.*;
import simstation.*;

class Drunk extends Agent {

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}


class RandomWalkFactory extends SimStationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}

public class RandomWalkSimulation extends Simulation {

    public void populate() {
       addAgents(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimStationPanel(new RandomWalkFactory());
        panel.display();
    }

}
