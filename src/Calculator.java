import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the number input fields
        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        // Create the panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("First Number:", SwingConstants.RIGHT));
        inputPanel.add(firstNumberField);
        inputPanel.add(new JLabel("Second Number:", SwingConstants.RIGHT));
        inputPanel.add(secondNumberField);
        inputPanel.add(new JLabel("Result:", SwingConstants.RIGHT));
        inputPanel.add(resultField);

        // Create the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(modButton);
        buttonPanel.add(clearButton);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add some padding around the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = firstNumber + secondNumber;
            } else if (e.getSource() == subButton) {
                result = firstNumber - secondNumber;
            } else if (e.getSource() == mulButton) {
                result = firstNumber * secondNumber;
            } else if (e.getSource() == divButton) {
                result = firstNumber / secondNumber;
            } else if (e.getSource() == modButton) {
                result = firstNumber % secondNumber;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
