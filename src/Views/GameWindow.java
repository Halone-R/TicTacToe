package Views;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    static JLabel player1;
    static JLabel player2;
    static Grid grid;

    public GameWindow(int gridSlider, int winSliderInteger){
        super("GameWindow");

        //Setup grid
        grid = new Grid(gridSlider, winSliderInteger);
        grid.setBounds(30, 30, 720, 710);
        grid.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        //Painel componente
        JPanel statsBord = new JPanel();
        statsBord.setBounds(760,30,210,410);
        statsBord.setBorder(BorderFactory.createLineBorder(Color.blue));

        //Setup Score
        JLabel score = new JLabel("Score");
        score.setForeground(Color.blue);

        player1 = new JLabel("Player X  "+ Grid.player1Score );
        player2 = new JLabel("Player O  " + Grid.player2Score);

        score.setFont(new Font("Chalkduster", Font.BOLD, 20));
        score.setBounds(30,30, 150,50);

        player1.setFont(new Font("Chalkduster", Font.PLAIN, 15));
        player1.setBounds(30,60, 150,50);

        player2.setFont(new Font("Chalkduster", Font.BOLD, 15));
        player2.setBounds(30,90, 150,50);


        //Setting game
        JLabel settings = new JLabel("Game Settings");
        settings.setFont(new Font("Chalkduster", Font.BOLD, 20));
        settings.setBounds(30,130, 200,50);
        settings.setForeground(Color.blue);

        JLabel gridSetting = new JLabel("Grid Size:  " + gridSlider);
        gridSetting.setFont(new Font("Chalkduster", Font.PLAIN, 15));
        gridSetting.setBounds(30,160, 150,50);

        JLabel winSetting = new JLabel("Win Houses:  " + winSliderInteger);
        winSetting.setFont(new Font("Chalkduster", Font.PLAIN, 15));
        winSetting.setBounds(30,190, 150,50);


        //cancel button
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("Chalkduster", Font.BOLD, 20));
        cancelBtn.setForeground(Color.red);
        cancelBtn.setBounds(30,300, 150,50);
        cancelBtn.addActionListener(e -> {
            dispose();
            Grid.player1Score = 0;
            Grid.player2Score = 0;
        });

        //setup frame
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //add components to the frame
        add(statsBord, BorderLayout.SOUTH);
        statsBord.add(score);
        statsBord.add(player1);
        statsBord.add(player2);
        statsBord.add(settings);
        statsBord.add(gridSetting);
        statsBord.add(winSetting);
        statsBord.add(cancelBtn);
        add(grid, BorderLayout.WEST.equals(BorderLayout.CENTER));

    }

}
