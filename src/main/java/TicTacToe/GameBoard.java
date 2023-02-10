package TicTacToe;

public class GameBoard {
    Character[][] gameBoard;

    public GameBoard(int board_size) {
        gameBoard = new Character[board_size][board_size];
        for (var x: gameBoard)
            for (var y : x) y = MoveList.EMPTY.getValue();
    }

    public Character[][] getGameBoard() {
        return gameBoard;
    }
    public Character getGameBoardItem(int x, int y) {
        return gameBoard[x][y];
    }
    public void setGameBoardItem(int x,int y, char c) {
        this.gameBoard[x][y] = c;
    }
}
