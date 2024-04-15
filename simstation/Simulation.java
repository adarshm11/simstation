package simstation;
import mvc.*;
import java.util.*;

public class Simulation extends Model {
    public List<Agent> agents = new ArrayList<>();
    transient private Timer timer;
    private int clock = 0;
    protected static int SIZE = 500; // should be initialized to size of view panel, I think

    private void startTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer(){
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run(){
            clock++;
        }
    }

    // up next are the methods corresponding to the buttons - unsure if these preliminary implementations are correct
    public void start(){
        startTimer();
        populate();
        for (Agent a : agents){
            Thread t = new Thread(a);
            t.start();
            a.join();
        }
        notifySubs();
    }

    public void suspend(){
        for (Agent a : agents){
            a.suspend();
        }
        notifySubs();
    }

    public void resume(){
        for (Agent a : agents){
            a.resume();
        }
        notifySubs();
    }

    public void stop(){
        stopTimer();
        for (Agent a : agents){
            a.stop();
        }
        notifySubs();
    }

    public String[] getStats(){
        return new String[] {"#agents = " + agents.size(), "clock = " + clock};
    }

    public Agent getNeighbor(Agent a, double radius){
        Random rand = new Random();
        int rng = rand.nextInt(agents.size());
        Agent chosen = agents.get(rng);
        int i = rng;
        Agent neighbor = null;
        boolean flagged = false;
        while(!flagged){
            double xcor = Math.abs(chosen.xc - a.xc);
            double ycor = Math.abs(chosen.yc - a.yc);
            chosen = agents.get(i);
            i++;
            if ((xcor <= radius && ycor <= radius)){
                neighbor = chosen;
                return neighbor;
            }
            if (i == rng){
                flagged = true;
            }
            if (i == agents.size()){
                i = 0;
            }
        }
        return null;
    }

    public void populate(){
    }

    public void addAgents(Agent a){
        agents.add(a);
        a.world = this;
    }
}
