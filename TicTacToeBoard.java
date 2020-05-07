import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class TicTacToeBoard extends JFrame implements ActionListener {
    JButton strategy1, strategy2;
    
    private JFrame frame;
    private Model model;
    private JButton[][] buttons;
    private JButton reset;
    private JTextArea playerturn;
    private JButton b[] ;
    private int count = 0;

    // Strategy type identified from GUI, this is associated with radio button.
    String strategyType;

    // Strategy that shall be used will be decided during runtime
    BoardStyle boardStrategy;

    // This is not used , will be used in MVC implementation
    private static String synthFile = "buttonSkin.xml";

    /**
     * This is constuctor of this class This is invoked from StrategyPatternDemo
     * This constructor creates the board in GUI .
     */

    TicTacToeBoard() {
        model = new Model();
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[3][3];
        reset = new JButton("Reset");
        playerturn = new JTextArea();
        
       
        this.buttons = new JButton[3][3];

        // CheckboxGroup cbg = new CheckboxGroup();
        strategy1 = new JButton("Board Style 1");
        strategy2 = new JButton("Board Style 2");
        strategy1.setBounds(120, 80, 200, 40);
        strategy2.setBounds(120, 150, 200, 40);
        frame.add(strategy1);
        frame.add(strategy2);
        strategy2.addActionListener(this);
        strategy1.addActionListener(this);



        frame.setLayout(null);
        frame.setSize(330, 450);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }// eof constructor

    /**
     * This method is implementation of ActionListener interface extended by this
     * class.
     *
     * This method is dummy method and shall be used during MVC implementation
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("here");
        JButton check = (JButton) (e.getSource());
        if (check.getText() == "Board Style 1") {
            strategyType = "style1";
            boardStrategy = new FirstBoardStyle();

        } else if (check.getText() == "Board Style 2") {
            strategyType = "style2";

            boardStrategy = new SecondBoardStyle();
        }
        boardStrategy.doOperation();
        frame.remove(strategy1);
        frame.remove(strategy2);
        frame.repaint(0, 0, 330, 450);

        displayBoard();
       
    }

    /**
     *
     * This method is the implementation of the ItemListener. This method is invoked
     * when the user selects radio button based on style requirement.
     *
     */
   

    /**
     * This method is called from itemStateChanged after user selects the board
     * style. This is the context where Strategy is implemented during runtime
     * During runtime user can select any style required ,based on it the method
     * changes the behavior of the board with invoking the corresponding strategy
     * implementation IF the user chooses first style - FirstBoardStyle is used IF
     * the user chooses second style - SecondBoardStyle is used This method is used
     * to display the board with updated behavior provided by strategy.
     */
    public void displayBoard() {
        int  j, ii, jj, x, y, yesnull;
        JButton b[] = new JButton[9];
        JButton reset;
        x = 10;
        y = 10;
        j = 0;
        for (int i = 0; i <= 8; i++, x += 100, j++) {
            
            b[i] = new JButton();
            JButton button = new JButton();
           
            Border line = new LineBorder(Color.BLACK);
            

            Border margin = new EmptyBorder(5, 15, 5, 15);
            Border compound = new CompoundBorder(line, margin);
            b[i].setText("");
            b[i].setBorder(compound);
            b[i].setOpaque(true);
            b[i].setBackground(boardStrategy.getBtnColor());
            // b[i].setBackground(Color.ORANGE);

            if (j == 3) {
                j = 0;
                y += 100;
                x = 10;
            }
            b[i].setBounds(x, y, 100, 100);
            frame.add(b[i]);
           // button = b[i]
            count = i;
           
            
            
            b[i].addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                 JButton but = new JButton();
                 but = (JButton)e.getSource();
                 if(but.getText().equals("") )
                   {
                     
                       (but).setText(model.getCurrPlayer());
                       model.changePlayer();
                       
                   }
                }
        
            });
           
            
           
        } // eof for
        
        
    
        reset = new JButton("RESET");
        reset.setBounds(100, 350, 100, 50);
        frame.add(reset);
        reset.addActionListener(new ActionListener()
                
                {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i <= 8; i++) {
                            b[i].setText("");
                        }
                        
                       
                        
                    }
            
                });

    }// eof showButton

}
