package simstation;
import mvc.*;

public abstract class SimStationFactory implements AppFactory {
    public abstract Model makeModel();

    public View makeView(Model m){
        return new SimulationView(m);
    }

    public abstract String getTitle();

    public String[] getHelp(){
        return new String[]{"Start makes the agents begin interacting and moving",
                "Suspend causes the agents to be frozen in place",
                "Resume causes the suspended agents to continue interacting and moving",
                "Stop ends the simulation",
                "Stats reveals a breakdown of the agents' vitals" };
    }

    public String about(){
        return "This program runs simulations of agent interactions";
    }

    public String[] getEditCommands(){
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    public Command makeEditCommand(Model m, String name, Object source) throws Exception {
        if (name.equals("Start")) return new StartCommand(m);
        if (name.equals("Suspend")) return new SuspendCommand(m);
        if (name.equals("Resume")) return new ResumeCommand(m);
        if (name.equals("Stop")) return new StopCommand(m);
        if (name.equals("Stats")) return new StatsCommand(m);
        throw new Exception("Unrecognized command: " + name);
    }
}
