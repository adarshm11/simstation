package PrisonersDilemma;

public class Tit4Tat implements Strategy {
    private boolean isFirstMove = true;
    private boolean lastMove = true; // Cooperate on first move

    public boolean cooperate() {
        if (isFirstMove) {
            isFirstMove = false;
            return true;
        } else {
            return lastMove;
        }
    }

    public void setLastMove(boolean move) {
        lastMove = move;
    }
}