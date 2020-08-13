package basic.demo7.demo7_2;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * @author ljj
 * @description A handler for displaying log records in a window
 * @date 2020-08-13
 */
public class WindowHandler extends StreamHandler {
    private JFrame jFrame;

    public WindowHandler() {
        jFrame = new JFrame();

        final JTextArea output = new JTextArea();

        output.setEditable(false);
        jFrame.setSize(200, 200);
        jFrame.add(new JScrollPane(output));
        jFrame.setFocusableWindowState(false);
        jFrame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord logRecord) {
        if (!jFrame.isVisible()) {
            return;
        }

        super.publish(logRecord);
        flush();
        
    }
}
