package java.main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DefaultJFrame defaultJFrame = new DefaultJFrame();
            defaultJFrame.setVisible(true);

        });
    }
}
