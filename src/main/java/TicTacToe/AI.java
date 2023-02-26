package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    public void makeMove(GameBoard gameBoard, Character AiMoveType){
        Character[][] tempAddressOfBoard = gameBoard.getGameBoard();
        int length = tempAddressOfBoard.length;
        int[][] aiBoard = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                    aiBoard[i][j] = 0;
            }
        }

        //Evaluate moves
        for (int i = 0; i < tempAddressOfBoard.length ; i++) {
            for (int j = 0; j < tempAddressOfBoard[i].length; j++) {
                if (tempAddressOfBoard[i][j] != MoveList.EMPTY.getValue())
                {
                    if (aiBoard[i][j] == AiMoveType) {
                        if (j < length-1) aiBoard[i][j+1] = aiBoard[i][j+1]+1;
                        if (j > 0) aiBoard[i][j-1] = aiBoard[i][j-1]+1;
                        if (i < length-1) aiBoard[i+1][j] = aiBoard[i+1][j]+1;
                        if (i > 0) aiBoard[i-1][j] = aiBoard[i-1][j]+1;
                        if ((i > 0) && (j < length-1)) aiBoard[i-1][j+1] = aiBoard[i-1][j+1]+1;
                        if ((i > 0) && (j > 0)) aiBoard[i-1][j-1] = aiBoard[i-1][j-1]+1;
                        if ((i < length-1) && (j < length-1)) aiBoard[i+1][j+1] = aiBoard[i+1][j+1]+1;
                        if ((i < length-1) && (j > 0)) aiBoard[i+1][j-1] = aiBoard[i+1][j-1]+1;
                    }
                    else {
                        if (j < length-1) aiBoard[i][j+1] = aiBoard[i][j+1]+2;
                        if (j > 0) aiBoard[i][j-1] = aiBoard[i][j-1]+2;
                        if (i < length-1) aiBoard[i+1][j] = aiBoard[i+1][j]+2;
                        if (i > 0) aiBoard[i-1][j] = aiBoard[i-1][j]+2;
                        if ((i > 0) && (j < length-1)) aiBoard[i-1][j+1] = aiBoard[i-1][j+1]+2;
                        if ((i > 0) && (j > 0)) aiBoard[i-1][j-1] = aiBoard[i-1][j-1]+2;
                        if ((i < length-1) && (j < length-1)) aiBoard[i+1][j+1] = aiBoard[i+1][j+1]+2;
                        if ((i < length-1) && (j > 0)) aiBoard[i+1][j-1] = aiBoard[i+1][j-1]+2;
                    }
                }
            }
        }
        //Clean aiBoard from invalid moves
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (tempAddressOfBoard[i][j] != MoveList.EMPTY.getValue()) {
                     aiBoard[i][j] = -1;
                }
            }
        }
        //Find max
        int max = -1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (aiBoard[i][j] > max) {
                    max = aiBoard[i][j];
                }
            }
        }
        //Create array of moves with max values
        List<Move> maxValues = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (aiBoard[i][j] == max) {
                    maxValues.add(new Move(i,j));
//                    System.out.println("x: "+i+" y: "+j);
                }
            }
        }
        //Make random move from maxValues list
        Random random = new Random();
        int nextRandomMove = random.nextInt(maxValues.size());
        gameBoard.setGameBoardItem(maxValues.get(nextRandomMove).x(),maxValues.get(nextRandomMove).y(), AiMoveType);
    }
}
