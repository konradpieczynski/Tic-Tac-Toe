import TicTacToe.GameBoard;
import TicTacToe.TerminalDisplay;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {
    @Test
    void testTerminalDisplay()
    {
        //Given
        GameBoard gameBoard = new GameBoard(5);
        char a = 'a';
        for (int i = 0; i < gameBoard.getGameBoard().length ; i++) {
            for (int j = 0; j < gameBoard.getGameBoard()[i].length; j++) {
                gameBoard.setGameBoardItem(i,j,a);
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
}
