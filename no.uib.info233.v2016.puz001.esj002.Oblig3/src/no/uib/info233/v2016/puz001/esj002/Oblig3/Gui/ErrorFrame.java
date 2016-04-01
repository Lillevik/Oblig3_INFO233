package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eirik on 31.03.2016.
 */
public class ErrorFrame extends JOptionPane {
    private JPanel spine = new JPanel();

    public ErrorFrame(){
        add(spine);
        spine.setPreferredSize(new Dimension(100, 100));
    }

}

