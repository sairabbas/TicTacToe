
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class TicTacToeBoard extends JFrame implements ItemListener, ActionListener, Observer
{
    Checkbox strategy1,strategy2;
    Icon ic1,ic2,icon,ic11,ic22;
    boolean state,type,set;

    //Declare global model variable
    Model model;

    //Strategy type identified from GUI, this is associated with radio button.
    String strategyType;

    //Strategy that shall be used will be decided during runtime
    BoardStyle boardStrategy;

    //This is not used , will be used in MVC implementation
    private static String synthFile = "buttonSkin.xml";


    /**
     * This is constuctor of this class
     * This is invoked from StrategyPatternDemo
     * This constructor creates the board in GUI .
     */

    TicTacToeBoard()
    {
        super("TIC TAC TOE - GAME");

        //Initialize and add observer to model
        model = new Model();
        model.addObserver(this);

        CheckboxGroup cbg=new CheckboxGroup();
        strategy1=new Checkbox("Board Style 1",cbg,false);
        strategy2=new Checkbox("Board Style 2",cbg,false);
        strategy1.setBounds(120,80,200,40);
        strategy2.setBounds(120,150,200,40);
        add(strategy1); add(strategy2);
        strategy1.addItemListener(this);
        strategy2.addItemListener(this);

        state=true;type=true;set=true;
        ic1=new ImageIcon("ic1.jpg");
        ic2=new ImageIcon("ic2.jpg");
        ic11=new ImageIcon("ic11.jpg");
        ic22=new ImageIcon("ic22.jpg");

        setLayout(null);
        setSize(330,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//eof constructor

    /**
     * This method is implementation of ActionListener interface extended by this class.
     *
     *This method is dummy method and shall be used during MVC implementation
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
    /**
     *
     * This method is the implementation of the ItemListener.
     * This method is invoked when the user selects radio button based on style requirement.
     *
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (strategy1.getState()) {
            System.out.println(strategy1.getState());
            strategyType="style1";
            boardStrategy=new FirstBoardStyle();

        }else if (strategy2.getState()) {

            boardStrategy=new SecondBoardStyle();
        }
        boardStrategy.doOperation();
        remove(strategy1);
        remove(strategy2);
        repaint(0, 0, 330, 450);


        displayBoard();
    }
    /**
     * This method is called from itemStateChanged after user selects the board style.
     * This is the context where Strategy is implemented during runtime
     * During runtime user can select any style required ,based on it the method
     * changes the behavior of the board with invoking the corresponding strategy implementation
     * IF the user chooses first style - FirstBoardStyle is used
     * IF the user chooses second style - SecondBoardStyle is used
     * This method is used to display the board with updated behavior provided by strategy.
     */
    public void displayBoard() {
        int i, j, ii, jj, x, y, yesnull;
        JButton b[] = new JButton[9];
        JButton undo;
        x = 10;
        y = 10;
        j = 0;
        for (i = 0; i <= 8; i++, x += 100, j++) {
            b[i] = new JButton();
            Border line = new LineBorder(Color.BLACK);

            Border margin = new EmptyBorder(5, 15, 5, 15);
            Border compound = new CompoundBorder(line, margin);
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
            add(b[i]);
            b[i].addActionListener(this);
        } // eof for

        undo = new JButton("Undo");
        undo.setBounds(100, 350, 100, 50);
        add(undo);
        undo.addActionListener(this);

        //Controller class that handles user input
        class Controller
        {
            
        }//end of Controller class
    }// eof showButton

    //Updates the graphical view whenever input occurs
    @Override
    public void update(Observable observable, Object o)
    {
        repaint();
    }
}


