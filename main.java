package Calculator;

import javax.swing.ImageIcon;

public class main {
    public static void main(String[] args) {
        Calculator frame = new Calculator();
        setFrame(frame);
        frame.setVisible(true);

    }

    public static void setFrame(Calculator frameIn) {

        String title = "CALCULATOR";
        frameIn.setSize(600, 800);
        frameIn.setTitle(title);
        frameIn.setLocationRelativeTo(null);

    }
}
