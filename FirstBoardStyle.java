
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;


/**
 * First board style is subclass of Board Style implementing the methods defined in
 * the BoardStyle

 * @author Admin
 *
 */
public class FirstBoardStyle implements BoardStyle {

    /**
     * The board color is defined in this attribute.
     */
    public Color btnBgColor=Color.PINK;



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
     * The style of this board is chosen to be pink as defined above in btnBgColor.
     * The getBtnColoris invoked from TicTacToeBoard context  dynamically during runtime..
     *
     */
    @Override
    public Color getBtnColor() {
        // TODO Auto-generated method stub
        return btnBgColor;
    }



    /**
     * FirstBoardStyle has chosen to use Ocean Theme
     * The below method sets the ocean theme in UIManager.
     * When the board is created the board uses OceanTheme style.
     * The setBoardTheme invoked from TicTacToeBoard context  dynamically during runtime..
     */

    @Override
    public void setBoardTheme() {
        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        try {
           // UIManager.setLookAndFeel(new MetalLookAndFeel());
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (UnsupportedLookAndFeelException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
