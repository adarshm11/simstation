package PrisonersDilemma;

import mvc.*;
import simstation.*;

public class PrisonerDilemmaSimulation extends Simulation {

    public void populate(){
        for (int i = 0; i < 40; i++){
            if (i < 10){
                addAgents(new Prisoner(new Cheat()));
            }
            else if (i < 20){
                addAgents(new Prisoner(new Cooperate()));
            }
            else if (i < 30){
                addAgents(new Prisoner(new Tit4Tat()));
            }
            else {
                addAgents(new Prisoner(new RandomlyCooperate()));
            }
        }
    }

    public String[] getStats(){
        String[] result = new String[4];
        int cheatCount = 0, cooperateCount = 0, randomCount = 0, tit4tatCount = 0;
        int cheatScore = 0, cooperateScore = 0, randomScore = 0, tit4tatScore = 0;
        for (Agent a : agents){
            Prisoner p = (Prisoner) a;
            if (p.strategy instanceof Cheat){
                cheatCount++;
                cheatScore += p.getFitness();
            }
            else if (p.strategy instanceof Cooperate){
                cooperateCount++;
                cooperateScore += p.getFitness();
            }
            else if (p.strategy instanceof RandomlyCooperate){
                randomCount++;
                randomScore += p.getFitness();
            }
            else if (p.strategy instanceof Tit4Tat){
                tit4tatCount++;
                tit4tatScore += p.getFitness();
            }
        }
        result[0] = "Average fitness for always cheat: " + ((double)cheatScore / cheatCount);
        result[1] = "Average fitness for always cooperate: " + ((double)cooperateScore / cooperateCount);
        result[2] = "Average fitness for randomly cooperate: " + ((double)randomScore / randomCount);
        result[3] = "Average fitness for copy opponent (tit-for-tat): " + ((double)tit4tatScore / tit4tatCount);
        return result;
    }

    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new PrisonerDilemmaFactory());
        panel.display();
    }

}