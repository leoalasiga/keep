package basic.demo6.demo6_8;

import javax.swing.*;

/**
 * @author ljj
 * @description
 * @date 2020-08-12
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(10000, true);
        //keep program running until enter ok
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
