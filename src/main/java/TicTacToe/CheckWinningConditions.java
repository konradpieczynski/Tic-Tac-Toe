package TicTacToe;

import java.util.Arrays;

public class CheckWinningConditions {

    public String checkStatus(GameBoard gameBoard){
        Character[][] board = gameBoard.getGameBoard();
        int winningCount = board.length > 4 ? 4 : 3;
        if (!Arrays.asList(board).contains(" ")) return "Tie";
        //Horizontal check
        for (int i = 0; i < board.length; i++) {
            int count=1;
            for (int j = 1; j < board[i].length; j++) {
                if ((board[i][j]==board[i][j-1]) && (board[i][j] != MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][j].toString();
                }
                else count =1;
            }
        }
        //Vertical check
        for (int i = 0; i < board.length; i++) {
            int count=1;
            for (int j = 1; j < board[i].length; j++) {
                if ((board[j][i]==board[j-1][i]) && (board[j][i] != MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[j][i].toString();
                }
                else count =1;
            }
        }
        //Diagonal check 1
        for (int i = 0; i < board.length-1; i++) {
            int count=1;
            for (int j = 1; j < board[i].length-1; j++) {
                if ((board[i][j-1]==board[i+j][j]) && (board[i][j-1] != MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][j].toString();
                }
                else count =1;
            }
        }
        //Diagonal check 2
        for (int i = 0; i < board.length-1; i++) {
            int count=1;
            for (int j = 1; j < board[i].length-1; j++) {
                if ((board[j-1][i]==board[j][i+j]) && (board[j-1][i] != MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[j-1][i].toString();
                }
                else count =1;
            }
        }
        return "Continue";
    }
}
