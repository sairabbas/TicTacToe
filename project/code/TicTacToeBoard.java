
package tictactoe;

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

    private JButton reset;

    private JButton b[];
    private JButton undo;
    private JTextField display;
    private String curr;
    private int limit;
    // Strategy type identified from GUI, this is associated with radio button.
    String strategyType;

    // Strategy that shall be used will be decided during runtime
    BoardStyle boardStrategy;

    /**
     * This is constuctor of this class This is invoked from StrategyPatternDemo
     * This constructor creates the board in GUI .
     */

    TicTacToeBoard(Model model) {
        this.model = model;
        frame = new JFrame("Tic Tac Toe");

        reset = new JButton("Reset");
        undo = new JButton("UNDO");
        display = new JTextField();
        display.setEditable(false);
        curr = "X";

        strategy1 = new JButton("Board Style 1");
        strategy2 = new JButton("Board Style 2");

        strategy1.setBounds(120, 80, 200, 40);
        strategy2.setBounds(120, 200, 200, 40);
        frame.add(strategy1);
        frame.add(strategy2);
        strategy2.addActionListener(this);
        strategy1.addActionListener(this);
        display.setText("Player X turn");
        limit = 0;

        // frame.pack();
        frame.setLayout(null);
        frame.setSize(350, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }// eof constructor

    /**
     * This method is implementation of ActionListener interface extended by this
     * class.
     *
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

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
        undo.setEnabled(false);
        reset.setEnabled(false);

        displayBoard();

    }

    /**
     * This method is called after user selects the board style. This is the context
     * where Strategy is implemented during runtime During runtime user can select
     * any style required ,based on it the method changes the behavior of the board
     * with invoking the corresponding strategy implementation IF the user chooses
     * first style - FirstBoardStyle is used IF the user chooses second style -
     * SecondBoardStyle is used This method is used to display the board with
     * updated behavior provided by strategy.
     */
    public void displayBoard() {
        display.setBounds(120, 400, 100, 70);

        frame.add(display);
        int j, ii, jj, x, y;
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

            b[i].addActionListener(new ActionListener() {

                /**
                 * This method is used when the user plays his turn , that is pick a square
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("limit count" + limit);

                    JButton but = new JButton();
                    but = (JButton) e.getSource();

                    // Initially the undo button is disable so we need to enable it
                    // but since we don't allow multiple undos in a row we
                    // use a curr variable to check if the player has changed
                    undo.setEnabled(true);

                    if (!curr.equals(model.getCurrPlayer())) {

                        limit++;
                        if (limit > 2) {
                            undo.setEnabled(false);
                            limit = 0;

                        }

                    } else {
                        limit = 0;
                        model.setUndoLimitForPlayer1();
                        model.setUndoLimitForPlayer2();

                    }

                    // Only update the model if the winner is not found
                    if (but.getText().equals("") && model.getWinner() == false) {

                        // set the text with the corrrect value "0 or X"
                        // Update the model
                        (but).setText(model.getCurrPlayer());
                        for (int i = 0; i < b.length; i++) {
                            if (e.getSource() == b[i]) {

                                model.update(i);
                            }
                        }
                        // Check for the winner or tie
                        model.isWinner();
                        if (model.getWinner()) {
                            JOptionPane.showMessageDialog(null, "Player with " + model.getCurrPlayer() + " has won");
                            undo.setEnabled(false);

                            // display.setText("Player X turn");
                            // When we create the new model everything is reseted in the model
                            model = new Model();
                            model.changePlayer();
                            // the board is reseted too
                            for (int i = 0; i <= 8; i++) {
                                b[i].setText("");
                            }

                        } else if (model.getMoves() == 9) {
                            JOptionPane.showMessageDialog(null,
                                    "The game has been tied, please reset for another game");
                            undo.setEnabled(false);
                        }
                        // change the player because now it turn of other player
                        model.changePlayer();
                        curr = model.getCurrPlayer();

                        // Display which player turn is this
                        display.setText("Player " + model.getCurrPlayer() + " turn");
                        // Get the current player and is used above to avoid multiple undos in a row
                        // curr = model.getCurrPlayer();

                    }

                }
            }

            );

        } // eof for

        reset = new JButton("RESET");
        reset.setBounds(50, 350, 100, 50);
        undo.setBounds(200, 350, 100, 50);
        frame.add(undo);
        undo.addActionListener(new ActionListener() {

            /**
             * 
             * This method is called when the user presses the undo button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                // disable the undo button
                undo.setEnabled(false);
                // The index of the button of the previous move
                int index = model.getIndexForUndo();
                // Since the user undo the move we need the same player
                model.changePlayer();
                // display whose turn is this
                display.setText("Player " + model.getCurrPlayer() + " turn");
                // update the model
                model.updateAfterUndo(index);

                // Check if the player has reached its undo limit
                if ((model.getCurrPlayer().equals("X"))) {
                    if (!model.isUndoLimitForPlayer1())

                    {
                        // set the previous button to ""
                        b[index].setText("");
                    } else {
                        model.changePlayer();
                        // if the undo limit has reached display a message dialog
                        display.setText("Player " + model.getCurrPlayer() + " turn");

                    }
                }
                // Same for the other player
                else if ((model.getCurrPlayer().equals("0"))) {
                    if (!model.isUndoLimitForPlayer2()) {
                        System.out.println("here");
                        b[index].setText("");
                    } else {
                        model.changePlayer();
                        display.setText("Player " + model.getCurrPlayer() + " turn");
                        JOptionPane.showMessageDialog(null, "The Undo limit for Player 0 reached, cannot undo now");

                    }
                }

            }

        });
        frame.add(reset);
        // Reset the game
        reset.addActionListener(new ActionListener()

        {

            @Override
            public void actionPerformed(ActionEvent e) {
                model = new Model();

                // the board is reseted too
                for (int i = 0; i <= 8; i++) {
                    b[i].setText("");
                }

                display.setText("Player " + model.getCurrPlayer() + " turn");

                limit = 0;

//              

            }

        });

    }// eof showButton

}
