package Views;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    public static int player2Score;
    public static int player1Score;
    static int rows;
    static int cols;
     static JButton[][] buttons;
     static boolean xTurn;
     static int winLength;

    public Grid(int n, int winLength) {
        this.rows = n;
        this.cols = n;
        this.winLength = winLength;

        setLayout(new GridLayout(rows,cols));
        buttons = new JButton[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton button = new JButton();
                button.addActionListener(e -> {
                    JButton button1 = (JButton) e.getSource();
                    button1.setFont(new Font("Chalkduster", Font.PLAIN, 20));

                    String text = xTurn ? "X" : "O";
                    button1.setText(text);
                    button1.setEnabled(false);

                    xTurn = !xTurn; // Switching turns
                    check(); // Calling the checkforwin method
                });
                this.add(button);
                buttons[r][c] = button;
            }
        }
        xTurn = true; // This bool value checks for the turn
    }
    public void check() {
        // check rows
        for (int r = 0; r < rows; r++) {
            if (checkRowCol(r, 0, 0, 1)) {
                if (xTurn) {
                    player1Score++;
                }else {
                    player2Score++;
                }
                showWinMessage();
            }
        }

        // check columns
        for (int c = 0; c < cols; c++) {
            if (checkRowCol(0, c, 1, 0)) {
                if (xTurn) {
                    player1Score++;
                }else {
                    player2Score++;
                }
                showWinMessage();
            }
        }

        // check top-left to bottom-right diagonal
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (checkRowCol(r, c, 1, 1)) {
                    if (xTurn) {
                        player1Score++;
                    }else {
                        player2Score++;
                    }
                    showWinMessage();
                }
            }
        }

        // check top-right to bottom-left diagonal
        for (int r = 0; r < rows; r++) {
            for (int c = cols - 1; c >= 0; c--) {
                if (checkRowCol(r, c, 1, -1)) {
                    if (xTurn) {
                        player1Score++;
                    }else {
                        player2Score++;
                    }
                    showWinMessage();
                }
            }
        }

        boolean buttPressed = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {    // This for loop checks if all the buttons have been pressed
                if (buttons[r][c].isEnabled()) {  // If it detects that all buttons are pressed it changes the bool value
                    buttPressed = true;
                    break;
                }
            }
        }



        if (!buttPressed) {
            if (player1Score == player2Score) {
                JLabel tempLabel = new JLabel("Draw");
                tempLabel.setFont(new Font("Chalkduster", Font.PLAIN, 50));      // DRAW message
                tempLabel.setForeground(Color.GRAY);
                tempLabel.setPreferredSize(new Dimension(250,50));
                JOptionPane.showMessageDialog(this, tempLabel);

            }
            else if (player1Score < player2Score ) {
                JLabel tempLabel = new JLabel("X WINS");
                tempLabel.setFont(new Font("Chalkduster", Font.PLAIN, 50));   // Player O WIN message
                tempLabel.setForeground(Color.RED);
                tempLabel.setPreferredSize(new Dimension(250,50));
                JOptionPane.showMessageDialog(this, tempLabel);

            }
            else {
                JLabel tempLabel = new JLabel("O WINS");
                tempLabel.setFont(new Font("Chalkduster", Font.PLAIN, 50));  // Player X WIN message
                tempLabel.setForeground(Color.BLUE);
                tempLabel.setPreferredSize(new Dimension(250,50));
                JOptionPane.showMessageDialog(this, tempLabel);

            }
        }
    }
    void showWinMessage () {
        if (xTurn) {
            GameWindow.player2.setText("Player O  " + player1Score );  // Updates the Olabel with the scores

        }
        else {
            GameWindow.player1.setText("Player X  " + player2Score);  // Updates the Xlabel with the scores

        }
    }


    static boolean checkRowCol(int row, int col, int rowIncr, int colIncr) {

        String symbol = xTurn ? "O" : "X";
        int count = 0;
        if (row == 0 && col == 0){
            row = 0;
        }

        while (row >= 0 && row < rows && col >= 0 && col < cols) {


            if (buttons[row][col].getText().equals(symbol)) {
                count++;
                if (count == winLength) {
                    return true;
                }
            }
            else {
                count = 0;
            }

            row += rowIncr;  //Increment, to traverse the cols and rows
            col += colIncr;
        }
        return false;
    }
}
