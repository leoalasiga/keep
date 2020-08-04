package basic.demo2.demo2_2;

import javax.swing.*;
import java.awt.*;

/**
 * @author ljj
 * @description a program for viewing images
 * @date 2020-07-08
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
