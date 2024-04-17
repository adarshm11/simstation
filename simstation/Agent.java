package simstation;

import mvc.*;

import java.awt.*;
import java.io.Serializable;


public abstract class Agent implements Runnable, Serializable {

    protected Simulation world;
    protected String name;
    protected Heading heading;
    protected int xc = Utilities.rng.nextInt(Simulation.SIZE);
    protected int yc = Utilities.rng.nextInt(Simulation.SIZE);
    protected boolean suspended = false;
    protected boolean stopped = false;
    protected Color color = Color.WHITE;
    transient protected Thread myThread;

    public synchronized void checkSuspended() {
        try {
            while (!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized boolean isSuspended() {
        return suspended;
    }

    public synchronized void join() {
        try {
            if (myThread != null) {
                myThread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        myThread = Thread.currentThread();
        checkSuspended();
        onStart();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        onExit();
    }

    public void start() {
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        notify();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public abstract void update();

    public void move(int steps) {
        Point oldPos = new Point(xc, yc);
        switch (heading) {
            case NORTH:
                for (int i = 0; i < steps; i++) {
                    if (yc < 0)
                        yc = simstation.Simulation.SIZE - 1;
                    else
                        yc--;
                    world.changed();
                }
                break;

            case EAST:
                for (int i = 0; i < steps; i++) {
                    if (xc > simstation.Simulation.SIZE - 1)
                        xc = 0;
                    else
                        xc++;
                    world.changed();
                }
                break;

            case SOUTH:
                for (int i = 0; i < steps; i++) {
                    if (yc > simstation.Simulation.SIZE - 1)
                        yc = 0;
                    else
                        yc++;
                    world.changed();
                }
                break;

            case WEST:
                for (int i = 0; i < steps; i++) {
                    if (xc < 0)
                        xc = simstation.Simulation.SIZE - 1;
                    else
                        xc--;
                    world.changed();
                }
                break;
        }
    }


    public void onStart(){}

    public void onInterrupted(){}

    public void onExit(){}

}
