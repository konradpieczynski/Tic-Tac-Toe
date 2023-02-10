package TicTacToe;

public class TerminalDisplay {
    public void Display(GameBoard gameBoard)
    {
        for (var x: gameBoard.getGameBoard()) {
            for (var y: x){
                System.out.print("|"+y);
                if (x[x.length-1] == y) System.out.print("|");
            }
            System.out.println();
        }
    }
}
