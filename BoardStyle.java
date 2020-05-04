package com.company;


/**
 * This is Strategy Interface . Subclasses (FirstBoardStyle.java & SecondBoardStyle.java)
 * implements this class.
 *
 * An interface to define the operations of the Strategy sub classes to adhere to the implementation.
 * There can be n number of strategies. For each strategy there shall be a concrete class defined.
 *
 * In this project it is chosen to be 2 board styles implemented with 2 strategies
 * 1. First Strategy with FirstBoardStyle.java implementing this interface
 * 2. Second Strategy with SecondBoardStyle.java implementing this interface
 * @author Admin
 *
 */
public interface BoardStyle {
    /**
     * This method is to specific operation on defined variables.
     * This method will be useful when the user starts playing the game
     * This will be implemented as part of MVC model to handle the user interaction
     * Sub classes need to overide the logic of implementation according their needs.
     */
    public void doOperation();

    /**
     * This method allows to show the color of board.
     * Each subclass can define their own color
     *
     * @return
     */
    public java.awt.Color getBtnColor();

    /**
     * This method defines the skin layout of the board
     * Subclasses implementing this method can define the specific theme depending on
     * style requirement that shall be presented.
     */
    public void setBoardTheme();
}
