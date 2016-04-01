package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for warning the
 * Created by Eirik on 31.03.2016.
 * This class is a panel created to show error dialouges.
 * Indead of printing errors it will display the errors that are catched in an error box.
 */
public class ErrorFrame extends JOptionPane {
    private JPanel spine = new JPanel();

    public ErrorFrame(){
        add(spine);
        spine.setPreferredSize(new Dimension(100, 100));
    }

}

