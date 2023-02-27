package TicTacToe;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        AI ai = new AI();
        int currentPlayer;
        PlayerList playerList = new PlayerList();
        CheckWinningConditions checkWinningConditions = new CheckWinningConditions();
        boolean end=false;
        String status;

        //Terminal mode
        TerminalInput terminalInput = new TerminalInput();
        TerminalDisplay terminalDisplay = new TerminalDisplay();
        System.out.println("Welcome to tic tac toe!");
        playerList.addPlayer(new Player((terminalInput.scanPlayerName()),false));
        playerList.addPlayer(new Player("Computer", true));
        playerList.addPlayer(new Player("Computer 2", true));
        GameBoard gameBoard =new GameBoard(terminalInput.scanNumber("board size"));
        Random random = new Random();
        int x;
        int y;
        boolean madeMove;
        //Randomize starting player
        currentPlayer=random.nextInt(playerList.getPlayerList().size()-1);
        //Main loop
        while (!end){
            madeMove=false;
            if (playerList.getPlayer(currentPlayer).isAI){
                ai.makeMove(gameBoard, MoveList.values()[currentPlayer].getValue());
            }
            else {
                terminalDisplay.Display(gameBoard);
                System.out.println(playerList.getPlayer(currentPlayer).name + "("+MoveList.values()[currentPlayer].getValue()+") turn");
                while(!madeMove) {
                    x = terminalInput.scanNumber("x coordinate");
                    y = terminalInput.scanNumber("y coordinate(9000 to quit game)");
                    madeMove = gameBoard.setGameBoardItem(x,y,MoveList.values()[currentPlayer].getValue());
                    if (y == 9000){
                        end = true;
                        break;
                    }
                }
            }
            checkWinningConditions.checkStatus(gameBoard);
            status = checkWinningConditions.checkStatus(gameBoard);
            if (!status.equals("Continue"))
            {
                if (status.equals("Tie")) {
                    System.out.println("Game Tie!");
                }
                else {
                    System.out.println(playerList.getPlayer(currentPlayer).name
                            +"(" + MoveList.values()[currentPlayer].getValue() + ") won!");
                }
                gameBoard.clearBoard();
            }
            currentPlayer++;
            if (currentPlayer > playerList.getPlayerList().size()-1) currentPlayer=0;
        }
    }
}