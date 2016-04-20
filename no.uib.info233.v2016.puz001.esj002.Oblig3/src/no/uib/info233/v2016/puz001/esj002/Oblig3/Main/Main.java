package no.uib.info233.v2016.puz001.esj002.Oblig3.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;


import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.IssueTable;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.SaveProgram;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.XmlFilehandling;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.Controls;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.ErrorFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;

import javax.swing.*;


/**
 * Class to start the program.
 * Creates JButton methods.
 *
 * @author esj002 and puz001
 */
public class Main implements Serializable {

	private static final long serialVersionUID = 1834915564586880152L;


	/**
	 * This method starts the program and connects the different
	 * instances together in one class.
	 * @param args
	 */
	public static void main(String[] args) {
		XmlFilehandling xfh = new XmlFilehandling();
		IssueTable it = new IssueTable(xfh);
		Gui gui = new Gui(it);
		gui.prioColumnSorter();
		Controls controls = new Controls(gui, it, xfh);
		controls.addActions();

	}
}