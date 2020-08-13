package basic.demo7.demo7_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ljj
 * @description The frame that shows the iamge
 * @date 2020-08-13
 */
public class ImageViewFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel jLabel;
    private static Logger logger = Logger.getLogger("basic.demo7.demo7_2");

    public ImageViewFrame() {
        logger.entering("ImageViewFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> {
            logger.fine("Exiting.");
            System.exit(0);
        });

        //use a label to display the images
        jLabel = new JLabel();
        add(jLabel);
        logger.exiting("ImageViewFrame", "<init>");
    }


    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewFrame.FileOpenListener", "actionPerformed", e);
            //set up file chooser
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("."));
            //accept all fields ending with gif
            jFileChooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith("gif")||f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            //show file chooser dialog
            int r = jFileChooser.showOpenDialog(ImageViewFrame.this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = jFileChooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file{0}", name);
                jLabel.setIcon(new ImageIcon(name));
            }else {
                logger.fine("File open dialog canceled");
            }

            logger.exiting("ImageViewFrame.FileOpenListener", "actionPerformed");
        }
    }

}
