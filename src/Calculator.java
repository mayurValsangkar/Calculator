import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    // Declaring global frame
    JFrame frame;

    // Declaring global textField
    JTextField textField;

    // Initializing array of numberButton
    JButton[] numberButton = new JButton[10];

    // Initializing array of functionButton
    JButton[] functionButton = new JButton[9];

    // Declaring buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    // Declaring panel
    JPanel panel;

    // Declaring global font
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Declaring global variables
    double num1 = 0, num2 =0, result = 0;
    char operator;


    // Constructor
    Calculator() {

        // Initializing and setting frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Initializing and setting text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initializing function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // Adding function buttons in functionButton array
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        // Adds an ActionListener to the functionButton
        // And setting font of buttons
        for(int i=0;i<9;i++) {

            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        // Adds an ActionListener to the numberButton
        // And setting font of buttons
        for(int i=0;i<10;i++) {

            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        // Setting dimension and placing negative, delete, clear buttons at right place
        negButton.setBounds(50,430, 100, 50 );
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Initializing panel and setting its position and layout
        panel =new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);

        // Adding all the buttons in panel grid
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Adding panel, button and text field in frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    // Event handling for buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++) {

            if(e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Decimal case
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // Checking operator(Plus)
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        // Checking operator(Subtraction)
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        // Checking operator(Multiplication)
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        // Checking operator(Division)
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // If button is equal sign
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            // Performing operation according to operator
            switch (operator) {

                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // If button is Clear
        if(e.getSource() == clrButton) {
            textField.setText("");
        }

        // If button is Delete
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        // If button is negative sign button
        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}