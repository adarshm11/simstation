package simstation;

import mvc.*;
import java.util.*;
import javax.swing.*;

public class SimStationPanel extends AppPanel {

    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    public SimStationPanel(AppFactory factory) {
        super(factory);

        start = new JButton("Start");
        start.addActionListener(this);
        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        resume = new JButton("Resume");
        resume.addActionListener(this);
        stop = new JButton("Stop");
        stop.addActionListener(this);
        stats = new JButton("Stats");
        stats.addActionListener(this);

        controlPanel.add(start);
        controlPanel.add(suspend);
        controlPanel.add(resume);
        controlPanel.add(stop);
        controlPanel.add(stats);
    }

    @Override
    public void setModel(Model m){
        super.setModel(m);
        Simulation s = (Simulation) m;
        Iterator<Agent> it = s.iterator();
        while (it.hasNext()){
            Thread t = new Thread(it.next());
            t.start();
        }
    }
}
