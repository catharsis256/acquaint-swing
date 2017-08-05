package def;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
        setTitle(APP_NAME);

        ImageIcon icon = new ImageIcon(ICON_PATH);
        setIconImage(icon.getImage());

        add(new ShapeDrawComponent());
        pack();
    }
}

class ShapeDrawComponent extends JComponent {

    private Dimension dimension;
    private final int ELLIPSEWIDTH = 200, ELLIPSEHEIGHT = 200;

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

        Point2D xyA = new Point2D.Double((dimension.width - ELLIPSEWIDTH)/ 2. , (dimension.height - ELLIPSEHEIGHT)/ 2.),
                xyB = new Point2D.Double((dimension.width + ELLIPSEWIDTH)/ 2. , (dimension.height + ELLIPSEHEIGHT)/ 2.);

        Ellipse2D ellipse2D = new Ellipse2D.Double( xyA.getX(), xyA.getY() , ELLIPSEWIDTH, ELLIPSEHEIGHT);
        graphics2D.draw(ellipse2D);

        Rectangle2D rect2D = new Rectangle2D.Double();
        rect2D.setFrameFromDiagonal(xyA, xyB);
        graphics2D.draw(rect2D);

        Line2D line2D = new Line2D.Double(xyA, xyB);
        graphics2D.draw(line2D);

        Ellipse2D ellipse2DA = new Ellipse2D.Double();
        ellipse2DA.setFrameFromDiagonal(xyA, xyB);

        graphics2D.fill(ellipse2DA);

    }

    @Override
    public Dimension getPreferredSize() {
        return (Dimension)dimension.clone();
    }
}
