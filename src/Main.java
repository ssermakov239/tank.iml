import javax.swing.*;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frame = new JFrame();
        frame.setTitle("xxx");
        frame.setSize(1500,800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel();
        frame.add(panel);
        frame.setVisible(true);
        while (panel.frameClose) {
            frame.repaint();

        }
        System.exit(1);

    }
}
