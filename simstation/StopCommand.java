package simstation;
import mvc.*;

public class StopCommand extends Command {

    public StopCommand(Model m){
        super(m);
    }

    public void execute() throws Exception {
        if (!(model instanceof Simulation)){
            throw new Exception("Model must instantiate Simulation");
        }
        Simulation s = (Simulation) model;
        s.stop();
    }
}
