package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.stream.IntStream;

public class TicTacToe implements ActionListener {

    private final Random random = new Random();
    private final JFrame frame = new JFrame();
    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private final JLabel textField = new JLabel();
    private final JButton[] buttons = new JButton[9];
    private boolean player1Turn;

    public void start() {
        setStyles();
        firstTurn();
    }

    private void setStyles() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        IntStream.range(0, buttons.length).forEach(i -> {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        });

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    private void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X turn");
        } else {
            player1Turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
        //check X win conditions
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }

        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }

        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }

        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }

        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }

        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }

        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }

        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }

        //check O win conditions
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }

        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }

        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }

        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }

        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }

        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }

        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }

        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }
    }

    private void xWins(int a, int b, int c) {
        winsProperties(a, b, c);

        textField.setText("X wins");
    }

    private void oWins(int a, int b, int c) {
        winsProperties(a, b, c);

        textField.setText("O wins");
    }

    private void winsProperties(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        IntStream.range(0, buttons.length).forEach(i -> buttons[i].setEnabled(false));
    }
}
