package simstation;
import mvc.*;

public class StatsCommand extends Command {

    public StatsCommand(Model m){
        super(m);
    }

    public void execute() throws Exception {
        if (!(model instanceof Simulation)){
            throw new Exception("Model must instantiate Simulation");
        }

        Simulation s = (Simulation) model;
        String[] stats = s.getStats();
        String inform = "";
        int i;
        for (i = 0; i < stats.length - 1; i++){
            inform += stats[i] + "\n";
        }
        inform += stats[i];
        Utilities.inform(inform);
    }
}
