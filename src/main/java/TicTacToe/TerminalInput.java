package TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalInput {
    Scanner scanner = new Scanner(System.in);

    public int scanBoardSize(){
        int scannedValue = 0;
        boolean scanned=false;
        while(!scanned)
        {
            System.out.println("Please enter board size(Values less than 3 will default to 3): ");
            try {
                scannedValue = scanner.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Please enter a number!");
            }
            scanner.nextLine();
            if (scannedValue < 3) scannedValue = 3;
            scanned = true;
        }
        return scannedValue;
    }
    public String scanPlayerName() {
        String playerName = "";
        while (playerName.equals("")) {
            System.out.println("Please enter your name: ");
            playerName = scanner.nextLine();
        }
        return playerName;
    }
}
