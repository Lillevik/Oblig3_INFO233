package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import sun.plugin.javascript.JSClassLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mariuslillevik on 10.03.16.
 */
public class DetailsPanel extends JPanel{

    //JButtons
    private JButton updates = new JButton("All updaters");

    //TextAres
    private JTextArea issueText = new JTextArea(10, 15);
    private JScrollPane pane = new JScrollPane(issueText);

    //Panels

    //JLabels
    private JLabel issueLabel = new JLabel("Issue: ");
    private JLabel createdBy = new JLabel(("Created by: "));
    private JLabel lastUpdatedBy = new JLabel("Updated by: ");
    private JLabel weightLabel = new JLabel();

    public DetailsPanel(){
        setLayout(new GridBagLayout());
        setupComponents();
        gridbagConstaints();
    }


    public void gridbagConstaints(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 0;
        gc.gridy = 0;
        add(issueLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(pane, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(createdBy, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(lastUpdatedBy, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(updates, gc);

        gc.gridy = 5;
        gc.gridx = 0;
        gc.weighty = 3;
        add(weightLabel, gc);
    }

    public void setupComponents(){
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        issueText.setLineWrap(true);
        issueText.setWrapStyleWord(true);
        issueText.setEditable(false);
    }

    public JTextArea getIssueText() {
        return issueText;
    }


    public JLabel getCreatedBy() {
        return createdBy;
    }

    public JLabel getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(JLabel lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public JButton getUpdates() {
        return updates;
    }
}


