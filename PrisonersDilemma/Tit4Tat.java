package PrisonersDilemma;

public class Tit4Tat extends Strategy {

    public boolean cooperate(){
        return myPrisoner.getPartnerCheated();
    }
}