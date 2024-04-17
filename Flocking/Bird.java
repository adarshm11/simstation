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
        Bird neighbor = (Bird) world.getNeighbor(this, 10);
        if (neighbor != null){
            int newSpeed = neighbor.speed;
            Heading newHeading = neighbor.heading;
            this.speed = newSpeed;
            this.heading = newHeading;

        }
        move(speed);
    }
}
