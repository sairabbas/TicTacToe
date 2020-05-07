import javax.swing.JOptionPane;

public class Model {
    
    private String[] board;
   
    private String currPlayer;
    private boolean isWinner;
    private int moves = 0, previousMove = 0;
    public Model()
    {
       board = new String[9];
       for(int i = 0; i < 9; i ++)
       {
           board[i] = "";
       }
      
        moves = 0;
        currPlayer = "X";
        isWinner = false;
    }
    
    public void changePlayer()
    {
        
        if(currPlayer.equals("0"))
        {
            currPlayer = "X";
        }
        else if(currPlayer.equals("X"))
        {
            currPlayer = "0";
        }
    
        
    }
    public String getCurrPlayer()
    {
        return currPlayer;
    }
    public void update(int index)
    {
        board[index] = currPlayer;
        previousMove = index;
    }
    public int getPreviousMove()
    {
        moves--;
        board[previousMove] = "";
        return previousMove;
    }
    public boolean getWinner()
    
    {
        return isWinner;
    }
    
    public void isWinner()
    {
        moves++;

        if(board[0].equals(currPlayer)  &&  board[1].equals(currPlayer) && board[2].equals(currPlayer))
        {
          
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[0].equals(currPlayer)  &&  board[3].equals(currPlayer) && board[6].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[6].equals(currPlayer)  &&  board[7].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[2].equals(currPlayer)  &&  board[5].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[3].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[5].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[0].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[8].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[1].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[7].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(board[2].equals(currPlayer)  &&  board[4].equals(currPlayer) && board[6].equals(currPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player with " + currPlayer + " has won");
            isWinner = true;
            
        }
        else if(moves == 9)
        {
            JOptionPane.showMessageDialog(null, "The game has been tied, Please restart");
        }
        
       
    }

}
