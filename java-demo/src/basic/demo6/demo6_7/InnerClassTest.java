package basic.demo6.demo6_7;

import javax.swing.*;

/**
 * @author ljj
 * @description This program demonstrates the use of inner class
 * @date 2020-08-12
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();
        //keep program running until enter ok
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
