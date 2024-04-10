package simstation;
import mvc.*;
import java.util.*;

public class Simulation extends Model {
    private List<Agent> agents;
    transient private Timer timer;
    private int clock = 0;
    protected static int SIZE; // should be initialized to size of view panel, I think

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
        for (Agent a : agents){
            a.stop();
        }
        notifySubs();
    }

    public Agent getNeighbor(Agent a, double radius){
        return null;
    }

    public void populate(){}
}
