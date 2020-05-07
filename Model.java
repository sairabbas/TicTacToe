import javax.swing.JOptionPane;

public class Model {
    
    private String[] board;
    private int moves;
    private String currPlayer;
    private boolean isWinner;
    public Model()
    {
       board = new String[8];
        moves = 9;
        currPlayer = "X";
        isWinner = false;
    }
    
    public void changePlayer()
    {
        if(currPlayer.equals("0"))
        {
            currPlayer = "X";
        }
        else
        {
            currPlayer = "0";
        }
    
        
    }
    public String getCurrPlayer()
    {
        return currPlayer;
    }
   
    
    public void ResetBoard()
    {
        currPlayer = "X";
        isWinner = false;
        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board.length;j++) {
                board[i] = "";
            }
        }
        
    }
    public boolean getWinner()
    {
        return isWinner;
    }
    
    public void isWinner()
    {
        if(board[0].equals(currPlayer)  &&  board[1].equals(currPlayer) && board[2].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[0].equals(currPlayer)  &&  board[3].equals(currPlayer) && board[6].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[6].equals(currPlayer)  &&  board[7].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[2].equals(currPlayer)  &&  board[5].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[3].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[5].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[0].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[1].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[7].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        else if(board[2].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[6].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player" + currPlayer + "has won");
            isWinner = true;
            
        }
        
       
    }

}
