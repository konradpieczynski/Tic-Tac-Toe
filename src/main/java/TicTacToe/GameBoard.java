package TicTacToe;

public class GameBoard {
    Character[][] gameBoard;

    public GameBoard(int board_size) {
        if (board_size < 3) board_size = 3;
        gameBoard = new Character[board_size][board_size];
        for (int i = 0; i < gameBoard.length ; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                gameBoard[i][j] = MoveList.EMPTY.getValue();
            }
        }
    }

    public Character[][] getGameBoard() {
        return gameBoard;
    }
    public Character getGameBoardItem(int x, int y) {
        return gameBoard[x][y];
    }
    public boolean setGameBoardItem(int x,int y, Character c) {
        if (x > gameBoard.length || y > gameBoard.length || x < 0 || y<0) return false;
        if (getGameBoardItem(x,y) == MoveList.EMPTY.getValue()) {
            this.gameBoard[x][y] = c;
            return true;
        } else return false;
    }
    public void clearBoard(){
        for (int i = 0; i < gameBoard.length ; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                gameBoard[i][j] = MoveList.EMPTY.getValue();
            }
        }
    }
}
