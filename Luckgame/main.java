package Infrastructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class main {

    public static void main(String[] args) {

         new GameFrame();

    }



}
class GameFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    int randomNumber = new Random().nextInt(10) + 1;
    int numGuesses = 0;

    JTextField textField = new JTextField(5);

    JButton button = new JButton("Raten sie!");

    JLabel label = new JLabel(numGuesses + " Versuche");

    public GameFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(textField);
        add(button);
        add(label);

        button.addActionListener(this);

        pack();

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textfieldtext = textField.getText();

        if (Integer.parseInt(textfieldtext) == randomNumber){

            button.setEnabled(false);

            textField.setText(textField.getText() + "Ja!");
            textField.setEnabled(false);

        } else {

            textField.setText("");
            textField.requestFocus();

        }

        numGuesses++;

        String guessWord = (numGuesses == 1) ? " Versuch" : " Versuche";

        label.setText(numGuesses + guessWord);
    }
}

