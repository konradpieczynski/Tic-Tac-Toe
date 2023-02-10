package TicTacToe;

public class Player {
    String name;
    boolean isAI;

    public Player(String name, boolean isAI) {
        this.name = name;
        this.isAI = isAI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }
}
