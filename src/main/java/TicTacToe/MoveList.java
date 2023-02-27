package TicTacToe;

public enum MoveList {
    X('X'),
    O('O'),
    A('A'),
    EMPTY(' ');
    private final Character value;
    MoveList(Character value) {
        this.value = value;
    }
    public Character getValue() {
        return value;
    }
}
