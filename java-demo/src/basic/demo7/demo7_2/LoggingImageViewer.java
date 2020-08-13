package basic.demo7.demo7_2;

import basic.demo2.demo2_2.ImageViewerFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ljj
 * @description A modification of the image viewer program that logs various events
 * @date 2020-08-13
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("basic.demo7.demo7_2").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                FileHandler fileHandler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("basic.demo7.demo7_2").addHandler(fileHandler);
            } catch (IOException e) {
                Logger.getLogger("basic.demo7.demo7_2").log(Level.SEVERE,"Can't create log file handler",e);
            }
        }

        EventQueue.invokeLater(()->{
            Handler winowHandler = new WindowHandler();
            winowHandler.setLevel(Level.ALL);
            Logger.getLogger("basic.demo7.demo7_2").addHandler(winowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("basic.demo7.demo7_2").fine("Showing frame");
            frame.setVisible(true);

        });

    }
}
