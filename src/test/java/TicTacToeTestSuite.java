import TicTacToe.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTestSuite {
    @Nested
    @DisplayName("Terminal tests")
    class terminal {
        @Test
        void testEmptyTerminalDisplay() {
            //Given
            GameBoard gameBoard = new GameBoard(5);
            TerminalDisplay terminalDisplay = new TerminalDisplay();
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            //When
            terminalDisplay.Display(gameBoard);
            //Then
            assertEquals("""                    
                    | | | | | |
                    | | | | | |
                    | | | | | |
                    | | | | | |
                    | | | | | |""", outContent.toString().trim());
        }

        @Test
        void testTerminalDisplay() {
            //Given
            GameBoard gameBoard = new GameBoard(5);
            char a = 'a';
            for (int i = 0; i < gameBoard.getGameBoard().length; i++) {
                for (int j = 0; j < gameBoard.getGameBoard()[i].length; j++) {
                    gameBoard.setGameBoardItem(i, j, a);
                    a++;
                }
            }
            TerminalDisplay terminalDisplay = new TerminalDisplay();
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            //When
            terminalDisplay.Display(gameBoard);
            //Then
            assertEquals("""
                    |a|b|c|d|e|
                    |f|g|h|i|j|
                    |k|l|m|n|o|
                    |p|q|r|s|t|
                    |u|v|w|x|y|""", outContent.toString().trim());
        }

        @Test
        void testPlayerNameInput() {
            //Given
            String input = "Konrad";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            TerminalInput terminalInput = new TerminalInput();
            //When
            String scannedName = terminalInput.scanPlayerName();
            //Then
            assertEquals(input, scannedName);
        }

        @Test
        void testBoardSizeInput() {
            //Given
            String input = "4\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            TerminalInput terminalInput = new TerminalInput();
            //When
            int scannedValue = terminalInput.scanBoardSize();
            //Then
            assertEquals(4, scannedValue);
        }

        @Test
        void testBoardSizeInputMismatch() {
            //Given
            String input = "Not number";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            TerminalInput terminalInput = new TerminalInput();
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            //When
            terminalInput.scanBoardSize();
            //Then
            assertEquals("Please enter board size(Values less than 3 will default to 3): \n" +
                    "Please enter a number!", outContent.toString().trim());
        }
    }
    @Nested
    @DisplayName("Logic tests")
    class logic {
        @Test
        void testPlayer() {
            //Given & When
            Player player = new Player("Konrad", false);
            Player player1 = new Player("AI", true);
            //Then
            assertEquals("Konrad", player.getName());
            assertFalse(player.isAI());
            assertEquals("AI", player1.getName());
            assertTrue(player1.isAI());
        }

        @Test
        void testPlayerList() {
            //Given
            Player player = new Player("Konrad", false);
            Player player1 = new Player("AI", true);
            PlayerList playerList = new PlayerList();
            //When
            playerList.addPlayer(player);
            playerList.addPlayer(player1);
            //Then
            assertEquals(0, playerList.getPlayerNumber(player));
            assertEquals(1, playerList.getPlayerNumber(player1));
            assertEquals(player, playerList.getPlayer(0));
            assertEquals(player1, playerList.getPlayer(1));
        }
    }
    @Nested
    @DisplayName("Win condition tests")
    class WinConditions{
        @Test
        void tie(){
            //Given
            GameBoard gameBoard = new GameBoard(3);
            CheckWinningConditions winConditions = new CheckWinningConditions();
            gameBoard.setGameBoardItem(0,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(0,1,MoveList.X.getValue());
            gameBoard.setGameBoardItem(0,2,MoveList.O.getValue());
            gameBoard.setGameBoardItem(1,0,MoveList.O.getValue());
            gameBoard.setGameBoardItem(1,1,MoveList.O.getValue());
            gameBoard.setGameBoardItem(1,2,MoveList.X.getValue());
            gameBoard.setGameBoardItem(2,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(2,1,MoveList.O.getValue());
            gameBoard.setGameBoardItem(2,2,MoveList.O.getValue());
//            TerminalDisplay terminalDisplay = new TerminalDisplay();
//            terminalDisplay.Display(gameBoard);
            //When
            String result = winConditions.checkStatus(gameBoard);
            //Then
            assertEquals("Tie", result);
        }
        @Test
        void horizontal(){
            //Given
            GameBoard gameBoard = new GameBoard(3);
            CheckWinningConditions winConditions = new CheckWinningConditions();
            gameBoard.setGameBoardItem(0,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(0,1,MoveList.X.getValue());
            gameBoard.setGameBoardItem(0,2,MoveList.X.getValue());
//            TerminalDisplay terminalDisplay = new TerminalDisplay();
//            terminalDisplay.Display(gameBoard);
            //When
            String result = winConditions.checkStatus(gameBoard);
            //Then
            assertEquals(MoveList.X.getValue().toString(), result);
        }
        @Test
        void vertical(){
            //Given
            GameBoard gameBoard = new GameBoard(3);
            CheckWinningConditions winConditions = new CheckWinningConditions();
            gameBoard.setGameBoardItem(0,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(1,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(2,0,MoveList.X.getValue());
//            TerminalDisplay terminalDisplay = new TerminalDisplay();
//            terminalDisplay.Display(gameBoard);
            //When
            String result = winConditions.checkStatus(gameBoard);
            //Then
            assertEquals(MoveList.X.getValue().toString(), result);
        }
        @Test
        void diagonal(){
            //Given
            GameBoard gameBoard = new GameBoard(3);
            CheckWinningConditions winConditions = new CheckWinningConditions();
            gameBoard.setGameBoardItem(0,0,MoveList.X.getValue());
            gameBoard.setGameBoardItem(1,1,MoveList.X.getValue());
            gameBoard.setGameBoardItem(2,2,MoveList.X.getValue());
//            TerminalDisplay terminalDisplay = new TerminalDisplay();
//            terminalDisplay.Display(gameBoard);
            //When
            String result = winConditions.checkStatus(gameBoard);
            //Then
            assertEquals(MoveList.X.getValue().toString(), result);
        }
        @Test
        void diagonal2(){
            //Given
            GameBoard gameBoard = new GameBoard(3);
            CheckWinningConditions winConditions = new CheckWinningConditions();
            gameBoard.setGameBoardItem(0,2,MoveList.X.getValue());
            gameBoard.setGameBoardItem(1,1,MoveList.X.getValue());
            gameBoard.setGameBoardItem(2,0,MoveList.X.getValue());
//            TerminalDisplay terminalDisplay = new TerminalDisplay();
//            terminalDisplay.Display(gameBoard);
            //When
            String result = winConditions.checkStatus(gameBoard);
            //Then
            assertEquals(MoveList.X.getValue().toString(), result);
        }
    }

}
