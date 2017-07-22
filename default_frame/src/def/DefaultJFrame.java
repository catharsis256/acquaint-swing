package def;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DefaultJFrame extends JFrame {

    public DefaultJFrame(String frameName) throws HeadlessException {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension resolution = kit.getScreenSize();

        setSize((int)(resolution.width / 2.), (int)(resolution.height / 2.));
        setName(frameName);

        Image imageIcon = new ImageIcon(System.getProperty("user.dir")
                + File.separator + "default_frame"
                + File.separator + "if_red_matreshka_big_993808.PNG").getImage();
        setIconImage(imageIcon);
    }
}
