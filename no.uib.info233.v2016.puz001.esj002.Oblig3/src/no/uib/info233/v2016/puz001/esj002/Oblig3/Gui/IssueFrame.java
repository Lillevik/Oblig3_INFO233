package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import java.awt.*;
import java.io.Serializable;

import javax.swing.*;


/**
 * The purpose of this class is to serve as a panel for
 * creating new issues.
 */
public class IssueFrame extends JFrame implements Serializable {

    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private JLabel priority = new JLabel("Priority:");
    private JLabel locationField = new JLabel("Location:");
    private JTextField locationText = new JTextField();
    private JTextArea issueText = new JTextArea("Write issue here.");
    private JButton createButton = new JButton("Create");
    private JButton backButton = new JButton("Exit");
    private String[] priorities = {"Ikke prioritet", "Lav", "Normal", "Høy", "Kritisk"};
    private JComboBox choosePrio = new JComboBox(priorities);
    private JPanel mainPanel = new JPanel(new BorderLayout(2, 2));



    /**
     * This is the constructor of the issuePanel which initialized its
     * components, sets its size and makes it visible.
     */
    public IssueFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 700, 600);
        mainPanel.setPreferredSize(new Dimension(700, 600));
        placeComponents(mainPanel);
        setContentPane(mainPanel);
        setVisible(true);
    }

    /**
     * This is the method that sets up and add all the
     * components to the panel.
     * @param panel
     */
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        choosePrio.setBounds(290, 240, 160, 25);
        panel.add(choosePrio);

        priority.setBounds(200, 240, 80, 25);
        panel.add(priority);

        locationField.setBounds(200, 280, 80, 25);
        panel.add(locationField);

        locationText.setBounds(290, 280, 160, 25);
        panel.add(locationText);

        createButton.setBounds(275, 480, 80, 25);
        panel.add(createButton);

        backButton.setBounds(390, 480, 80, 25);
        panel.add(backButton);

        issueText.setBounds(290, 320, 160, 125);
        panel.add(issueText);

        issueText.setLineWrap(true);
        issueText.setWrapStyleWord(true);
    }


    public void closeWindow(){
        System.exit(0);
    }
    /**
     * This is a getter for the field locationText
     * which is used to get location of an issue.
     * @return the locationText
     */
    public JTextField getLocationText() {
        return locationText;
    }


    /**
     * This is a getter for the issueText
     * which is used to write the actual issue.
     * @return the issueText
     */
    public JTextArea getIssueText() {
        return issueText;
    }


    /**
     * This is the button that creates the issue
     * and returns the user to the main window.
     * @return the createButton
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * @param backButton the backButton to set
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JComboBox getChoosePrio() {
        return choosePrio;
    }
}