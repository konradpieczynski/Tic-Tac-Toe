package TicTacToe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckWinningConditions {

    public String checkStatus(GameBoard gameBoard){
        Character[][] board = gameBoard.getGameBoard();
        int winningCount = 3;
        if (board.length == 5) winningCount = 4;
        if (board.length > 5) winningCount = 5;
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
        for (int shift = 0; shift < board.length-1; shift++) {
            int count=1;
            for (int i = 0; i < board[shift].length-1-shift; i++) {
                if ((board[i][i+shift]==board[i+1][i+shift+1]) && (board[i][i+shift]!= MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][i+shift].toString();
                }
                else count =1;
            }
        }
        for (int shift = 0; shift < board.length-1; shift++) {
            int count=1;
            for (int i = 0; i < board[shift].length-1-shift; i++) {
                if ((board[i+shift][i]==board[i+shift+1][i+1]) && (board[i+shift][i]!= MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][i+shift].toString();
                }
                else count =1;
            }
        }
        //Diagonal check 2
        for (int shift = 0; shift < board.length-1; shift++) {
            int count=1;
            for (int i = 0; i < board[shift].length-1-shift; i++) {
                if ((board[i][(board.length-1)-(i+shift)]==board[i+1][(board.length-1)-(i+shift+1)])
                        && (board[i][(board.length-1)-(i+shift)]!= MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][i+shift].toString();
                }
                else count =1;
            }
        }
        for (int shift = 0; shift < board.length-1; shift++) {
            int count=1;
            for (int i = 0; i < board[shift].length-1-shift; i++) {
                if ((board[(board.length-1)-(i+shift)][i]==board[(board.length-1)-(i+shift+1)][i+1])
                        && (board[(board.length-1)-(i+shift)][i]!= MoveList.EMPTY.getValue())) {
                    count++;
                    if (count >= winningCount) return board[i][i+shift].toString();
                }
                else count =1;
            }
        }

        //Tie
        boolean tie = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if ((board[i][j] == MoveList.EMPTY.getValue())) {
                    tie = false;
                    break;
                }
            }
        }
        if (tie) return "Tie";
        return "Continue";
    }
}
