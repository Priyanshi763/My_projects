package guess_number;
import java.awt.*;
import java.awt.event.*;

public class NumberGuessing extends Frame {
    private TextField textField;
    private Label label;
    private int targetNumber;
    private int attempts;

    public NumberGuessing() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setLayout(new FlowLayout());

        label = new Label("Guess a number between 1 and 100:");
        add(label);

        textField = new TextField(10);
        textField.addActionListener(new TextFieldListener());
        add(textField);

        targetNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(textField.getText());
                attempts++;

                if (guess < targetNumber) {
                    label.setText("Too low! Guess again:");
                } else if (guess > targetNumber) {
                    label.setText("Too high! Guess again:");
                } else {
                    label.setText("Congratulations! You guessed it in " + attempts + " attempts.");
                    textField.setEditable(false);
                }

                textField.setText("");
            } catch (NumberFormatException ex) {
                label.setText("Invalid input! Guess again:");
            }
        }
    }

    public static void main(String[] args) {
        NumberGuessing game = new NumberGuessing();
        game.setVisible(true);
    }
}
