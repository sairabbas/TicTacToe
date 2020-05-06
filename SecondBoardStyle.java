
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;


/**
 * This is strategy concrete class implementing strategy interface BoardStyle.java
 * Methods defined in  the BoardStyle strategy interface are implemented in this class
 *
 * @author Admin
 *
 */
public class SecondBoardStyle implements BoardStyle {
    public  Color btnBgColor=Color.ORANGE;


    /**
     * This method will be implemented as part of MVC mode.
     * The main goal of this method is to capture user events on gui
     * After capturing the events on gui this method is responsible to repaint
     * with the required changes.
     * The doOperation invoked from TicTacToeBoard context  dynamically during runtime..
     */
    @Override
    public void doOperation() {
        // TODO Auto-generated method stub

    }


    /**
     * The style of this board is chosen to be Orange as defined above in btnBgColor
     * The getBtnColoris invoked from TicTacToeBoard context  dynamically during runtime..
     *
     */

    @Override
    public Color getBtnColor() {
        return btnBgColor;

    }




    /**
     * SecondBoardStyle has chosen to use DefaultMetalTheme
     * The below method sets the DefaultMetalTheme in UIManager.
     * When the board is created the board uses DefaultMetalTheme style.
     * The setBoardTheme invoked from TicTacToeBoard context dynamically during runtime.
     */
    @Override
    public void setBoardTheme() {
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        try {
            //UIMan16kd9sager.setLookAndFeel(new MetalLookAndFeel());
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }


}
