package def;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
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
    private static final String APP_NAME = "Just a simple shape figure";
    private static final String ICON_PATH = System.getProperty("user.dir") +
            File.separator + "simple_window_text" + File.separator + "if_gallery_1646013.PNG";

    ShapeDrawFrame() throws HeadlessException {
        setName(APP_NAME);

        ImageIcon icon = new ImageIcon(ICON_PATH);
        setIconImage(icon.getImage());

        add(new ShapeDrawComponent());
        pack();
    }
}

class ShapeDrawComponent extends JComponent {

    private Dimension dimension;

    public ShapeDrawComponent() {
        configure();
    }

    void configure() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        if(kit == null)
            throw new IllegalStateException("Toolkit is null");

        Dimension dimension_default = kit.getScreenSize();
        if(dimension_default == null || dimension_default.width == 0 || dimension_default.height == 0)
            throw new IllegalStateException("Dimension is null");

        dimension = new Dimension((int)(dimension_default.getWidth() * 0.35), (int)(dimension_default.getHeight() * 0.35));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrameFromDiagonal();

        graphics2D.draw(ellipse2D);

    }

    @Override
    public Dimension getPreferredSize() {
        return (Dimension)dimension.clone();
    }
}
