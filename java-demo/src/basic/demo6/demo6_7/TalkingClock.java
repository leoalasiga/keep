package basic.demo6.demo6_7;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author ljj
 * @description A clock that prints the time in regular intervals
 * @date 2020-08-12
 */
public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep) {
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimerPrinter implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
