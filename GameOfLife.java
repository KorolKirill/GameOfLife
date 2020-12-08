package life;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife  extends JFrame{
    static int generationN = 0;
    static JPanel mainPanel = new JPanel();
    static int matrixSize = 80;
    static JLabel generation = new JLabel("Generation:");
    static JLabel alive = new JLabel("Alive:");
    static Functionality functions = new Functionality(new Printer(), new InitialMatrix(),matrixSize);
    static Timer timer = new Timer(500,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            functions.nextGeneration();
            displayUniverse(functions.getUniverse());
            alive.setText("Alive: " + functions.counterAlive());
            generation.setText("Generation: " + ++generationN);
            //frame.setVisible(true);
        }
    });

    public GameOfLife() {
        JToggleButton buttonPlay = new JToggleButton("play");
        JToggleButton buttonPause = new JToggleButton("resume");
        JButton buttonRestart = new JButton("restart");
        buttonPlay.setName("PlayToggleButton");
        buttonRestart.setName("ResetButton");
        generation.setName("GenerationLabel");
        alive.setName("AliveLabel");
        JSlider slider = new JSlider(1,10);
        JLabel sliderText = new JLabel("Speed Mode");
        mainPanel.setBackground(Color.ORANGE);
        buttonPlay.setBounds(10,8,70,40);
        buttonPause.setBounds(85,8,70,40);
        buttonRestart.setBounds(160,8,70,40);
        mainPanel.setBounds(240,8,570,570);
        mainPanel.setLayout(new GridLayout(matrixSize,matrixSize)); // !!!!!!!!!!!!!!
        generation.setBounds(10,50,230,30);
        generation.setFont(new Font(generation.getFont().getName(),Font.BOLD,16));
        alive.setFont(new Font(generation.getFont().getName(),Font.BOLD,16));
        sliderText.setFont(new Font(generation.getFont().getName(),Font.ITALIC,12));
        alive.setBounds(10,80,230,30);
        slider.setBounds(10,150,230,50);
        sliderText.setBounds(10,130,230,20);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1);
        buttonPause.setSelected(true);
        buttonPlay.setSelected(false);
        add(alive);
        add(generation);
        add(buttonPlay);
        add(buttonPause);
        add(buttonRestart);
        add(mainPanel);
        add(sliderText);
        add(slider);
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlay.setEnabled(false);
                buttonPause.setEnabled(true);
                buttonPause.setSelected(false);
                if (buttonPlay.isSelected()) {
                    timer.restart();
                }
                else {
                    timer.stop();
                }

            }
        });
        buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPause.setEnabled(false);
                buttonPlay.setSelected(false);
                buttonPlay.setEnabled(true);
                timer.stop();
            }
        });
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlay.setSelected(false);
                buttonPause.setSelected(true);
                buttonPause.setEnabled(false);
                buttonPlay.setEnabled(true);
                timer.stop();
                functions.makeMatrix();
                displayUniverse(functions.getUniverse());
                generationN = 0;
                alive.setText("Alive: " + functions.counterAlive());
                generation.setText("Generation: " + generationN);
                //frame.setVisible(true);
            }
        });



        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                timer.setDelay(slider.getValue()*100);
            }
        });

        displayUniverse(functions.getUniverse());

        setSize(850,630);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void displayUniverse(String[][] universe) {
        mainPanel.removeAll();
        for (int x = 0; x<matrixSize;x++) {
            for (int i=0;i<matrixSize;i++) {
                JPanel cell = new JPanel();
                if (universe[x][i].equals("O")) {
                    cell.setBackground(Color.black);
                }
                mainPanel.add(cell);
            }
        }
    }
}
