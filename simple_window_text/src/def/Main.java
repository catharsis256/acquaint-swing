package def;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    private static final String APP_NAME = "Just a simple app";
    private static final String ICON_PATH = System.getProperty("user.dir") +
            File.separator + "simple_window_text" + File.separator + "if_gallery_1646013.PNG";


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFrame sFrame = new SimpleFrame(APP_NAME, ICON_PATH);
            sFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            sFrame.setLocationByPlatform(true);
            sFrame.setVisible(true);

        });
    }
}

class SimpleFrame extends JFrame {
    public SimpleFrame(String title, String icon) throws HeadlessException {
        super(title);
        setIconImage(new ImageIcon(icon).getImage());

        TextComponent tc = new TextComponent("It's just not a 'hello, world'");
        add(tc);
        pack();
    }

}


class TextComponent extends JComponent {

    private static final Integer PREFERRED_WIDTH = 300;
    private static final Integer PREFERRED_HEIGHT = 200;

    private static final Integer TEXT_POSITION_X = 75;
    private static final Integer TEXT_POSITION_Y = 100;
    private String text;

    public TextComponent(String text) {
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString(text, TEXT_POSITION_Y, TEXT_POSITION_X);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
}
