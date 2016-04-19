package no.uib.info233.v2016.puz001.esj002.Oblig3.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.IssueTable;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.XmlFilehandling;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.IssueFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mariuslillevik on 04.04.16.
 */
public class newMain {

    public static void main(String[] args) {
        IssueFrame isf = new IssueFrame();
        XmlFilehandling xfh = new XmlFilehandling();
        IssueTable it = new IssueTable(xfh);
        xfh.fillIssues(it);
        it.changePrio();

        isf.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!xfh.getNewFile().exists()) {
                    xfh.writeXmlFile(it);
                    xfh.writeXmlFileNewProgram(isf);
                    JOptionPane.showMessageDialog(new JFrame(), "Sucsessfully added an issue!", "Sucsess!", JOptionPane.YES_NO_CANCEL_OPTION);
                } else {
                    xfh.writeXmlFileNewProgram(isf);
                    JOptionPane.showMessageDialog(new JFrame(), "Sucsessfully added an issue!", "Sucsess!", JOptionPane.YES_NO_CANCEL_OPTION);
                }
            }
        });

        isf.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isf.closeWindow();
            }
        });
    }
}
