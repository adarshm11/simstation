package Flocking;
import simstation.*;
import mvc.*;

public class Bird extends Agent {

    protected int speed;

    public Bird(){
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public void update(){
        Bird neighbor = (Bird) world.getNeighbor(this, 100);
        while (neighbor == null){
            neighbor = (Bird) world.getNeighbor(this, 100);
        }
        int newSpeed = neighbor.speed;
        Heading newHeading = neighbor.heading;
        this.speed = newSpeed;
        this.heading = newHeading;
        move(speed);
    }
}
