package Calculator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class Calculator extends JFrame {
    // This section we will write code to Calculate numbers.

    public Calculator() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();

    }

    public void init() {

        JPanel rootPanel = new JPanel();
        Color purple = new Color(181, 23, 158);
        Color blue = new Color(58, 12, 163);
        Color black = new Color(0, 0, 0);
        Color appBackground = new Color(0, 29, 61);
        ImageIcon icon = new ImageIcon("Image/Screen Shot 2023-08-03 at 00.34.40.png");
        this.setIconImage(icon.getImage());
        rootPanel.setLayout(new BorderLayout());
        this.getContentPane().add(rootPanel);

        /* ******************************** Text Field ****************************** */

        final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(8, 1, 10, 10));
        centerPanel.setBackground(Color.BLACK);

        JLabel label1 = new JLabel("Digits");
        label1.setForeground(purple);
        final JTextField textField1 = new JTextField(5);
        textField1.setForeground(purple);

        JLabel operatorLabel = new JLabel("'+,-,/,*,% '");
        operatorLabel.setForeground(purple);
        final JTextField operatorTextField = new JTextField(5);
        operatorTextField.setForeground(purple);

        JLabel label2 = new JLabel("Digits");
        label2.setForeground(purple);
        final JTextField textField2 = new JTextField(5);
        textField2.setForeground(purple);
        final JLabel resultLabel = new JLabel("Result");
        resultLabel.setForeground(purple);
        final JTextField resultText = new JTextField(5);
        resultText.setForeground(blue);

        /****************************** Button Panel *************************/

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 1, 5, 5));
        panelButton.setBackground(appBackground);
        JButton button = new JButton("Calculate");
        button.setForeground(black);
        JButton resetButton = new JButton("Reset");
        panelButton.add(button);
        panelButton.add(resetButton);
        resetButton.setForeground(Color.red);

        /* Welcome Start Panel */
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        final JPanel northSubPanel = new JPanel();
        northSubPanel.setBackground(black);
        JPanel subButtonPanel = new JPanel();
        JButton lightButton = new JButton("Switch");
        lightButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (centerPanel.getBackground().equals(Color.BLACK)) {
                    centerPanel.setBackground(Color.WHITE);
                    northPanel.setBackground(Color.WHITE);
                    northSubPanel.setBackground(Color.WHITE);
                } else if (centerPanel.getBackground() == Color.WHITE) {
                    centerPanel.setBackground(Color.BLACK);
                    northPanel.setBackground(Color.BLACK);
                    northSubPanel.setBackground(Color.BLACK);
                }

            }

        });
        subButtonPanel.add(lightButton);
        northPanel.add(northSubPanel, BorderLayout.NORTH);
        northPanel.add(lightButton, BorderLayout.EAST);
        JLabel welcomeLabel = new JLabel("Welcome to Calculator App ");
        welcomeLabel.setForeground(purple);
        northPanel.setBackground(black);
        northSubPanel.add(welcomeLabel);

        /************************
         * ** Button Event Listeners **
         *****************************/

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                operatorTextField.setText("");
                textField2.setText("");
                resultText.setText("");

            }
        });

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!textField1.getText().isEmpty()) {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());

                    if (operatorTextField.getText().equals("+")) {
                        System.out.println("Clicked");
                        double result = num1 + num2;
                        resultText.setText(Double.toString(result));

                    } else if (operatorTextField.getText().equals("*")
                            || operatorTextField.getText().equalsIgnoreCase("x")) {
                        double result = num1 * num2;
                        resultText.setText(Double.toString(result));

                    } else if (operatorTextField.getText().equals("/")) {
                        double result = num1 / num2;
                        resultText.setText(Double.toString(result));

                    } else if (operatorTextField.getText().equals("-")) {
                        double result = num1 - num2;
                        resultText.setText(Double.toString(result));

                    } else if (operatorTextField.getText().equals("%")) {
                        double result = num1 % num2;
                        resultText.setText(Double.toString(result));

                    } else if (textField1.getText().equals(" ") && operatorTextField.getText().equals(" ")
                            && textField2.getText().equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Field is Empty, Please input a number");
                    }
                    // "Please input numbers and not text \n" + "Only +,-,/,*,% are Allowed");

                }
            }

        });

        centerPanel.add(label1);
        centerPanel.add(textField1);
        centerPanel.add(operatorLabel);
        centerPanel.add(operatorTextField);
        centerPanel.add(label2);
        centerPanel.add(textField2);
        centerPanel.add(resultLabel);
        centerPanel.add(resultText);
        rootPanel.add(centerPanel, BorderLayout.CENTER);
        rootPanel.add(panelButton, BorderLayout.SOUTH);
        rootPanel.add(northPanel, BorderLayout.NORTH);
    }
}
