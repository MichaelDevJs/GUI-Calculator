package Calculator;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.plaf.DimensionUIResource;

public class main {
    public static void main(String[] args) {
        Calculator frame = new Calculator();
        setFrame(frame);
        frame.setVisible(true);
        frame.setMaximumSize(new Dimension(600, 800));

    }

    public static void setFrame(Calculator frameIn) {

        String title = "CALCULATOR";
        frameIn.setSize(300, 400);
        frameIn.setTitle(title);
        frameIn.setLocationRelativeTo(null);

    }
}
