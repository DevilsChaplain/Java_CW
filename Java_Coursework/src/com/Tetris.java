package com;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Tetris extends JFrame {
    public static String recordName;
    private JLabel statusbar;

    public Tetris() throws IOException {
            initUI();
    }

    private void initUI() throws IOException {
        statusbar = new JLabel(" 0");
        JLabel statusbar2 = new JLabel(" Рекорд - " + " Имя: " + Board.arrayList.get(0) + "    Счет: " + Board.arrayList.get(1));
        add(statusbar, BorderLayout.SOUTH);
        add(statusbar2, BorderLayout.NORTH);

        var board = new Board(this);
        add(board);
        board.start();
        board.setBackground(new Color(224, 217, 217));
        setTitle("Тетрис");
        setSize(300, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) throws IOException {
        recordName=JOptionPane.showInputDialog(null,"Введите ваше имя: ","Тетрис", JOptionPane.INFORMATION_MESSAGE);
        if(recordName.isEmpty()){
            System.exit(0);
        }
        Board.FileIn();
        EventQueue.invokeLater(() -> {
            Tetris game = null;
            try {
                game = new Tetris();
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.setVisible(true);
        });
    }
}