import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple Swing-based calculator application.
 * This class creates a GUI with buttons for numbers and operations,
 * and a text field to display the result.
 */
public class Calculator implements ActionListener {

    // Frame and main panel for the calculator
    private JFrame frame;
    private JPanel panel;

    // Text field to display the numbers and results
    private JTextField textField;

    // Array of buttons for numbers and operations
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;

    // Font for the buttons and text field
    private Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Variables to store the numbers and the result
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor to set up the GUI
    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Text field setup
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initialize button arrays
        numberButtons = new JButton[10];
        functionButtons = new JButton[8];

        // Create function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        // Add function buttons to the array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // Add action listeners to function buttons and set font
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Set bounds for special buttons
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Create and set up the button panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel in a grid layout
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add all components to the frame
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    /**
     * Main method to run the calculator application.
     */
    public static void main(String[] args) {
        new Calculator();
    }

    /**
     * Handles the logic for number button presses.
     * @param e The ActionEvent from the button click.
     */
    private void handleNumberButtons(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
    }

    /**
     * Handles the logic for operator button presses.
     * @param e The ActionEvent from the button click.
     */
    private void handleOperatorButtons(ActionEvent e) {
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
    }

    /**
     * Handles the logic for the equals button.
     */
    private void performCalculation() {
        num2 = Double.parseDouble(textField.getText());
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Handle division by zero
                if (num2 == 0) {
                    textField.setText("Error");
                    return;
                }
                result = num1 / num2;
                break;
        }
        textField.setText(String.valueOf(result));
        num1 = result;
    }

    /**
     * Handles the logic for the clear button.
     */
    private void handleClearButton() {
        textField.setText("");
    }

    /**
     * Handles the logic for the delete button.
     */
    private void handleDeleteButton() {
        String text = textField.getText();
        if (text.length() > 0) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    /**
     * Action listener for all button clicks.
     * This method handles all user interactions with the calculator buttons.
     * @param e The ActionEvent generated by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check for number button clicks
        handleNumberButtons(e);

        // Check for decimal button
        if (e.getSource() == decButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));
            }
        }

        // Check for operator buttons
        handleOperatorButtons(e);

        // Check for equals button
        if (e.getSource() == equButton) {
            performCalculation();
        }

        // Check for clear button
        if (e.getSource() == clrButton) {
            handleClearButton();
        }

        // Check for delete button
        if (e.getSource() == delButton) {
            handleDeleteButton();
        }
    }
}
