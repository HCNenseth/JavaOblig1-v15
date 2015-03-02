package javaoblig1.v15;

import java.awt.event.*;

public class Bokprogram {

    public static void main(String[] args) {
        Bokarkiv vindu = new Bokarkiv();
        vindu.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
    }
}
