/* TicTacToe.java
 * Purpose: Declares all instance variables and defines all methods of the TicTacToe class, allowing for storing and 
 * manipulation of data necessary to simulate a game of tic-tac-toe.
 * Written by: Randy Dang
 */
import java.util.*;
public class TicTacToe {
    
    //Instance variables representing aspects of a tic-tac-toe game.
    private String[][] board;
    private int plays;
    
    //Constructor that initializes instance variables to initial values.
    public TicTacToe() {
        board = new String[][]{{"-","-","-"},{"-","-","-"},{"-","-","-"}};
        plays = 0;
    }
    
    //Prints the tic-tac-toe board in a way the user can easily understand and view.
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //Adds an X or O to the spot on the board that the user indicated if there isn't already a character there.
    public void playMove(String symbol, int row, int column) {
        if (board[row][column] == "-") {
            board[row][column] = symbol;
            plays++;
        }
        else {
            System.out.println("There is already a character there.");
        }
    }
    
    //Checks to see if 9 plays have already been completed, which is when the board would be filled. Returns true if 9 
    //plays have been completed, false otherwise.
    public boolean keepPlaying() {
        if (plays >= 9) {
            System.out.println("Game over. There is a tie.");
            return false;
        }
        return true;
    }
    
    //Checks if X or O occupies three spaces in a row on the board, and prints out the winner if there is one. Returns true 
    //if someone won the game, false otherwise.
    public boolean checkWinner() {
        //Checks if X or O occupies a row of the board.
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                if (!(board[i][0].equals("-"))) {
                    System.out.println(board[i][0] + " wins!");
                    return true;
                }
            }
        }
        
        //Checks if X or O occupies a column of the board.
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                if (!(board[0][i].equals("-"))) {
                    System.out.println(board[0][i] + " wins!");
                    return true;
                }
            }
        }
        
        //Checks if X or O occupies any diagonal of the board.
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            if (!(board[0][0].equals("-"))) {
                System.out.println(board[0][0] + " wins!");
                return true;
            }
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            if (!(board[0][2].equals("-"))) {
                System.out.println(board[0][2] + " wins!");
                return true;
            }
        }
        
        //Returns false if neither X nor O occupies three spaces in a row.
        return false;
    }
}