package TicTacToe;

import java.util.stream.IntStream;

public class TerminalDisplay {
    public void Display(GameBoard gameBoard)
    {
        for (Character[] characters : gameBoard.getGameBoard()) {
            IntStream.range(0, characters.length).forEach(j -> {
                System.out.print("|" + characters[j]);
                if (j == characters.length - 1) System.out.print("|\n");
            });
        }
    }
}
