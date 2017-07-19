package ru.catharsis256.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Igor on 7/18/2017.
 */
public class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDHT = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() throws HeadlessException {
        setSize(DEFAULT_WIDHT, DEFAULT_HEIGHT);
    }
}
