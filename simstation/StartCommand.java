package simstation;
import mvc.*;

public class StartCommand extends Command {

    public StartCommand(Model m){
        super(m);
    }

    public void execute() throws Exception {
        if (!(model instanceof Simulation)){
            throw new Exception("Model must instantiate Simulation");
        }
        Simulation s = (Simulation) model;
        s.start();
    }
}
