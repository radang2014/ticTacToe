/* TicTacToeTester.java
 * Purpose: Uses the TicTacToe class to execute gameplay, prompting the user for inputs to add to the tic-tac-toe board.
 * The user should run the main method of this class to play the game.
 * Written by: Randy Dang
 */
import java.io.*;
import java.util.*;
public class TicTacToeTester {
    
    public static void main(String args[]) {
        //Creates TicTacToe object and begins the game.
        TicTacToe game = new TicTacToe();
        System.out.println("Begin Game.");
        
        //Loop for gameplay; keep prompting user to fill the board until either someone wins or there is a tie.
        while (game.keepPlaying() && (!(game.checkWinner()))) {
            //Prints board and prompts user for X or O.
            game.printBoard();
            System.out.println("Enter X or O:");
            Scanner kbReader = new Scanner(System.in);
            String input = kbReader.next();
            
            //Checks that user inputted an X or O.
            if (!((input.equals("X") || input.equals("O")))) {
                System.out.println("You must enter an X or an O.");
                continue;
            }
            
            //Prompts user to enter a row number.
            System.out.println("Enter a row: ");
            int row = kbReader.nextInt();
            
            //Checks that the row number is within the bounds of the array.
            if (row<0 || row>2) {
                System.out.println("Row number must be between 0 and 2.");
                continue;
            }
            
            //Prompts user to enter a column number.
            System.out.println("Enter a column: ");
            int column = kbReader.nextInt();
            
            //Checks that the column number is within the bounds of the array.
            if (column<0 || column>2) {
                System.out.println("Column number must be between 0 and 2.");
                continue;
            }
            
            //Executes the appropriate move based on input.
            game.playMove(input, row, column);
        }
        
        //Prints the board at the end of the game.
        game.printBoard();
    }
}
        