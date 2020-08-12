package basic.demo6.demo6_3;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author ljj
 * @description
 * @date 2020-08-12
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        //construct a timer that calls the listener
        //once every 10 seconds
        Timer t = new Timer(10000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);

    }
}
