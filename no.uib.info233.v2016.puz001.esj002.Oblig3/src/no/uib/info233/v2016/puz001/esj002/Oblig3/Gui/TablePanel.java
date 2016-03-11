package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.*;

/**
 * Created by mariuslillevik on 10.03.16.
 */
public class TablePanel extends JPanel {



    private JScrollPane pane = new JScrollPane();
    //JScrollPane informationPanel = new JScrollPane(this.textArea);
    private JTextArea textArea;
    private PrintStream standardOut;



    public TablePanel(JScrollPane pane){
        this.pane = pane;
        setLayout(new BorderLayout(1, 1));
        setupComponents();
        add(pane, BorderLayout.CENTER);
    }

    public void setupComponents(){
        // Initialize the text area
        this.textArea = new JTextArea(10, 0);
        this.textArea.setBounds(0, 0, 100, 100);
        this.textArea.setEditable(false);
        this.textArea.setLineWrap(true); // Wrap text
        this.textArea.setWrapStyleWord(true); // Wrap by word


        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        standardOut = System.out;

        System.setOut(printStream);
        //System.setErr(printStream); disabled so the users will not be confused

        // Put the text area into a JScrollPane so it can be scrolled
        JScrollPane informationPanel = new JScrollPane(this.textArea);
        // Always show vertical scroll bar
        informationPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the informationPanel to the bottom og the window
        this.add(informationPanel, BorderLayout.SOUTH);
    }



}

