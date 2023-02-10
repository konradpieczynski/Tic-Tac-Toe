package TicTacToe;

public enum MoveList {
    X('X'),
    O('O'),
    EMPTY(' ');
    private final Character value;
    MoveList(Character value) {
        this.value = value;
    }
    public Character getValue() {
        return value;
    }
}
