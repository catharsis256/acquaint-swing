package def;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ShapeDrawFrame frame = new ShapeDrawFrame();
            config(frame);
        });
    }

    private static void config(ShapeDrawFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}

class ShapeDrawFrame extends JFrame {
    private static final String APP_NAME = "Just a simple app";
    private static final String ICON_PATH = System.getProperty("user.dir") +
            File.separator + "simple_window_text" + File.separator + "if_gallery_1646013.PNG";

    ShapeDrawFrame() throws HeadlessException {
        Toolkit kit = Toolkit.getDefaultToolkit();
        if(kit == null)
            throw new IllegalStateException("Toolkit is null");

        Dimension dimension = kit.getScreenSize();
        if(dimension == null || dimension.width == 0 || dimension.height == 0)
            throw new IllegalStateException("Dimension is null");

        dimension.setSize(dimension.getWidth() * 0.4, dimension.getHeight() * 0.25);
        setSize(dimension);

        setName(APP_NAME);

        ImageIcon icon = new ImageIcon(ICON_PATH);
        setIconImage(icon.getImage());
    }
}

class ShapeDrawComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }
}
