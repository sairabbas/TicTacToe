package tictactoe;

import javax.swing.JOptionPane;

public class Model {

    private String[] board;

    private String currPlayer;
    private int previousIndex;
    private boolean isWinner;
    private int moves = 0;
    private int player1UndoCount;
    private int player2UndoCount;
    private boolean undoLimitForPlayer1;
    private boolean undoLimitForPlayer2;

    /**
     * Constructor for the model
     */
    public Model() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
        player1UndoCount = 0;
        player2UndoCount = 0;
        moves = 0;
        currPlayer = "X";
        isWinner = false;
        previousIndex = 0;
        undoLimitForPlayer1 = false;
        undoLimitForPlayer1 = false;

    }

    /**
     * Change the player
     */
    public void changePlayer() {

        if (currPlayer.equals("0")) {
            currPlayer = "X";
        } else if (currPlayer.equals("X")) {
            currPlayer = "0";
        }

    }

    /**
     * get the current player
     * 
     * @return the current player
     */
    public String getCurrPlayer() {
        return currPlayer;
    }

    /**
     * Reset the board
     */
    public void ResetBoard() {
        currPlayer = "X";
        isWinner = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i] = "";
            }
        }

    }

    /**
     * This method updates the model
     * 
     * @param index the index of the square whose value needs to be updated
     */
    public void update(int index) {

        board[index] = currPlayer;
        previousIndex = index;

    }

    /**
     * Check if the undo limit for player 1 has reached
     * 
     * @return boolean value
     */
    public boolean isUndoLimitForPlayer1() {
        return undoLimitForPlayer1;
    }

    public void setUndoLimitForPlayer1() {
        player1UndoCount = 0;
    }
    
    public void setUndoLimitForPlayer2() {
      
        player2UndoCount = 0;
    }
    /**
     * Check if the undo limit for player 2 has reached
     * 
     * @return boolean value
     */
    public boolean isUndoLimitForPlayer2() {
       
        return undoLimitForPlayer2;
    }

    /**
     * This method checks updates the board after the player decides to undo a move.
     * First it checks which player decided to undo a move and then check if the
     * undo limit has reached or not and if the limit is not reached the model is
     * updated
     * 
     * @param index the move index that has been undo
     */
    public void updateAfterUndo(int index) {

        if (currPlayer.equals("0")) {
            player2UndoCount++;
            if (player2UndoCount > 3) {
                undoLimitForPlayer2 = true;
            } else {
                moves--;
                board[index] = "";
                // changePlayer();
            }
        } else {
            player1UndoCount++;
            if (player1UndoCount > 3) {
                undoLimitForPlayer1 = true;
            } else {
                moves--;
                board[index] = "";
                // changePlayer();
            }
        }

    }

    /**
     * This gets the move index for the undo
     * 
     * @return the index of the move that needs to be undo
     */
    public int getIndexForUndo() {
       
        return previousIndex;
    }

    /**
     * 
     * @return returns if the winner is found or not
     */
    public boolean getWinner()

    {
        return isWinner;
    }

    /**
     * 
     * @return the total move counts
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Checks for the winner or tie based on the board indexes
     */
    public void isWinner() {
        moves++;

        if (board[0].equals(currPlayer) && board[1].equals(currPlayer) && board[2].equals(currPlayer)) {

            isWinner = true;

        } else if (board[0].equals(currPlayer) && board[3].equals(currPlayer) && board[6].equals(currPlayer)) {
            isWinner = true;

        } else if (board[6].equals(currPlayer) && board[7].equals(currPlayer) && board[8].equals(currPlayer)) {

            isWinner = true;

        } else if (board[2].equals(currPlayer) && board[5].equals(currPlayer) && board[8].equals(currPlayer)) {

            isWinner = true;

        } else if (board[3].equals(currPlayer) && board[4].equals(currPlayer) && board[5].equals(currPlayer)) {

            isWinner = true;

        } else if (board[0].equals(currPlayer) && board[4].equals(currPlayer) && board[8].equals(currPlayer)) {

            isWinner = true;

        } else if (board[1].equals(currPlayer) && board[4].equals(currPlayer) && board[7].equals(currPlayer)) {

            isWinner = true;

        } else if (board[2].equals(currPlayer) && board[4].equals(currPlayer) && board[6].equals(currPlayer)) {

            isWinner = true;

        }

    }

}
