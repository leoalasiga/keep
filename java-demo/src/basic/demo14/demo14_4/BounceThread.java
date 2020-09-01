package basic.demo14.demo14_4;

import javax.swing.*;
import java.awt.*;

/**
 * @author ljj
 * @description
 * @date 2020-08-27
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
