package Views;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    static int gridsliderInteger;
    static int winSliderInteger;

    JLabel gridSizeLabel= new JLabel(" SET GRID SIZE");
    JLabel winhouseLabel = new JLabel(" SET WIN SIZE");
    public MainWindow(){

        super("Main Window");
        //Setup winning Size
        JSlider WinSize = new JSlider(JSlider.VERTICAL);
        WinSize.setBounds(400,40, 150,250);
        WinSize.setMinimum(3);
        WinSize.setMaximum(9);
        WinSize.setValue(3);
        WinSize.setMajorTickSpacing(1);
        WinSize.setPaintTicks(true);
        WinSize.setPaintLabels(true);
        WinSize.setFont(new Font("Chalkduster", Font.BOLD, 12));

        // Setup grid Options
        JSlider gridSize = new JSlider(JSlider.VERTICAL);
        gridSize.setBounds(250, 40,150,250);
        gridSize.setMaximum(9);
        gridSize.setMinimum(3);
        gridSize.setValue(3);
        gridSize.setMajorTickSpacing(1);
        gridSize.setPaintTicks(true);
        gridSize.setPaintLabels(true);
        gridSize.setFont(new Font("Chalkduster", Font.BOLD, 12));


        //Add labels to frame
        gridSizeLabel.setBounds(260,7, 150,50);
        gridSizeLabel.setFont(new Font("Chalkduster", Font.BOLD, 15));
        gridSizeLabel.setForeground(new Color(52, 52, 217));
        winhouseLabel.setBounds(410,7, 150,50);
        winhouseLabel.setFont(new Font("Chalkduster", Font.BOLD, 15));
        winhouseLabel.setForeground(new Color(52, 52, 217));


        gridSize.addChangeListener(e -> {
            int value = gridSize.getValue();
            gridsliderInteger = value;
        });

        WinSize.addChangeListener(e -> {
            int value = WinSize.getValue();
            winSliderInteger = value;

        });

        gridsliderInteger = gridSize.getValue();    // Getting the values of slider and saving them to a Integer
        winSliderInteger = WinSize.getValue();

        // Setup start
        JButton start = new JButton("Start");
        start.setFont(new Font("Chalkduster", Font.BOLD, 20));
        start.setForeground(new Color(52, 52, 217));
        start.setBounds(80,150,150,50);
        start.addActionListener(e -> startGame());

        //Setup Frame
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        // Add components to the frame
        add(WinSize);
        add(winhouseLabel);
        add(gridSize);
        add(gridSizeLabel);

        add(start);

    }

    public static void startGame(){
        new GameWindow(gridsliderInteger, winSliderInteger);
    }

}
