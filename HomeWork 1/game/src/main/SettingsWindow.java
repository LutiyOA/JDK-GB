package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Окно настроек
 */
public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    public static int mode;
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int winLength;
    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setLayout(new GridLayout(10, 1));
        JLabel label1 = new JLabel("Выберите режим игры");
        add(label1);

        ButtonGroup btnGroup1 = new ButtonGroup();
        JRadioButton radioButtonRejim1 = new JRadioButton("Человек против компьютера");
        JRadioButton radioButtonRejim2 = new JRadioButton("Человек против человека");
        btnGroup1.add(radioButtonRejim1);
        btnGroup1.add(radioButtonRejim2);
        add(radioButtonRejim1);
        add(radioButtonRejim2);

        JLabel label2 = new JLabel("Выберите размеры поля");
        add(label2);

        JLabel label3 = new JLabel("Установленный размер поля:");
        add(label3);

        JSlider slide1 = new JSlider(3, 10, 3);
        slide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label3.setText("Установленный размер поля: " + slide1.getValue());
            }
        });
        add(slide1);

        JLabel label4 = new JLabel("Выберите длину для победы");
        add(label4);

        JLabel label5 = new JLabel("Установленная длина:");
        add(label5);

        JSlider slide2 = new JSlider(3, 10, 3);
        slide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label5.setText("Установленная длина: " + slide2.getValue());
            }
        });
        add(slide2);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = radioButtonRejim1.isSelected() ? 0 : 1;
                fieldSizeX = slide1.getValue();
                fieldSizeY = slide1.getValue();
                winLength = slide2.getValue();
                gameWindow.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
                setVisible(false);
            }
        });

        add(btnStart);

//        panSettings.add(radioButtonRejim1);
//        panSettings.add(radioButtonRejim2);
//        panSettings.add(btnGroup1);


//        add(btnStart);
//        add(panSettings);


    }

}
