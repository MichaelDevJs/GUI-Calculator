package Calculator;

import javax.sound.sampled.Line;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        ImageIcon icon = new ImageIcon("Image/Screen Shot 2023-08-03 at 00.34.40.png");
        this.setIconImage(icon.getImage());
        rootPanel.setLayout(new BorderLayout());
        this.getContentPane().add(rootPanel);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(0, 29, 61));

        JLabel label1 = new JLabel("num1");

        label1.setForeground(purple);
        final JTextField textField1 = new JTextField(20);
        textField1.setForeground(purple);

        JLabel operatorLabel = new JLabel("'+,-,/,*,% '");
        operatorLabel.setForeground(purple);
        final JTextField operatorTextField = new JTextField(20);
        operatorTextField.setForeground(purple);

        JLabel label2 = new JLabel("num2");
        label2.setForeground(purple);
        final JTextField textField2 = new JTextField(20);
        textField2.setForeground(purple);

        JButton button = new JButton("Calculate");
        button.setForeground(Color.BLACK);
        final JLabel resultLabel = new JLabel("Result");
        resultLabel.setForeground(purple);
        final JTextField resultText = new JTextField(20);
        resultText.setForeground(blue);

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
        JButton resetButton = new JButton("Reset");
        resetButton.setForeground(Color.red);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                operatorTextField.setText("");
                textField2.setText("");
                resultText.setText("");

            }
        });

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(operatorLabel);
        panel1.add(operatorTextField);
        panel1.add(label2);
        panel1.add(textField2);
        panel1.add(button);
        panel1.add(resultLabel);
        panel1.add(resultText);
        panel1.add(resetButton);
        rootPanel.add(panel1);
    }
}
