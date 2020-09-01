package basic.demo14.demo14_1;

import javax.swing.*;
import java.awt.*;

/**
 * @author ljj
 * @description Shows an animated bouncing ball
 * @date 2020-08-26
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
