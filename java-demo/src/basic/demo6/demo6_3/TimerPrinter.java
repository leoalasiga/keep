package basic.demo6.demo6_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author ljj
 * @description
 * @date 2020-08-12
 */
public class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();

    }
}
