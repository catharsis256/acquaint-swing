package def;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DefaultJFrame defaultJFrame = new DefaultJFrame("My Default Frame");
            defaultJFrame.setLocationByPlatform(true);
            defaultJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            defaultJFrame.setVisible(true);

        });
    }
}
