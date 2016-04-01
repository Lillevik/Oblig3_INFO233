package no.uib.info233.v2016.puz001.esj002.Oblig3.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;


import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.SaveProgram;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;


/**
 * Class to start the program.
 * Creates JButton methods.
 * @author esj002 and puz001
 */
public class Main implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1834915564586880152L;
	public static Gui gui = new Gui();

	/**
	 * This method starts the program and connects the different
	 * instances together in one class.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * This button lists all the issues from the user given
		 * in the textField and presents these in the JTable qtable.
		 */
		gui.getBtnSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();
				for (Issues issue : gui.getIt().getIssueList()) {
					if (issue.getAssigned().equals(gui.getTxtSearch().getText())) {
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
								issue.getAssigned(),
								gui.getIt().dateToString(issue.getCreated()),
								issue.getPriority(),
								issue.getLocation()});
					}
				}
			}
		});

		/**
		 * This is an actionListener for the btnId which 
		 * finds a specific issues and displays it in the JTable.
		 */
		gui.getBtnId().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();
				System.out.print(gui.getIt().getModel().getColumnClass(2));
				Issues issue = gui.getIt().getIssueMap().get(Integer.parseInt(gui.getTxtId().getText()));

						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
								issue.getAssigned(),
								gui.getIt().dateToString(issue.getCreated()),
								issue.getPriority(),
								issue.getLocation(),
								issue.getStatus()});

			}
		});


		/**
		 * This method finds all the issues with 
		 * a priority higher than the user input from the textfield.
		 */
		gui.getBtnPrior().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();

				for (Issues issue : gui.getIt().getIssueList()) {

					if (issue.getPriority().equals(gui.getTxtPriority().getText())) {
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
								issue.getAssigned(),
								gui.getIt().dateToString(issue.getCreated()),
								issue.getPriority(),
								issue.getLocation(),
								issue.getStatus()});
					}
				}
			}
		});


		/**
		 * This lists all the issues on a specific date and lists them
		 * in the JTable for the user to see.
		 */
		gui.getBtnDate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();

				for (Issues issue : gui.getIt().getIssueList()) {
					if (gui.getIt().dateToString(issue.getCreated()).equals(gui.getTxtDate().getText())) {
						gui.getIt().getModel().addRow(new Object[]{issue.getId(),
								issue.getAssigned(),
								gui.getIt().dateToString(issue.getCreated()),
								issue.getPriority(),
								issue.getLocation(),
								issue.getStatus()});
					}
				}

			}
		});


		gui.getDp().getSortDates().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();

				Collections.sort(gui.getIt().getIssueList());
				for (Issues i : gui.getIt().getIssueList()) {
					gui.getIt().getModel().addRow(new Object[]{i.getId(),
							i.getAssigned(),
							gui.getIt().dateToString(i.getCreated()),
							i.getPriority(),
							i.getLocation(),
							i.getStatus()});
				}
			}
		});


		/**
		 * This method lists all the unique users and
		 * presents them using a JTable
		 */
		gui.getBtnListAllUsers().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().listUniqueUsers();

			}
		});

		/**
		 * This method lists all the issues from the arrayList issues
		 * and presents them in the JTable qtable using methods from
		 * IssueTable.
		 */
		gui.getBtnListAllIssues().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getIt().tableRows();

				for (Issues i : gui.getIt().getIssueList()) {
					gui.getIt().getModel().addRow(new Object[]{i.getId(),
							i.getAssigned(),
							i.getCreated(),
							i.getPriority(),
							i.getLocation(),
							i.getStatus()});
				}
				//gui.getIt().tableForIssues();
			}
		});

		/**
		 * This method simply adds a user to the arrayList users
		 * using methods from IssueTable.
		 */
		gui.getBtnAddUser().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Adds a user to the list
				gui.getIt().addUser(gui.getTxtSearch().getText());
				gui.updateChooseUser();
				//Writes to the userFile
				gui.getIt().writeUsersToXml();
				//Changes the panel
				gui.getIt().listUniqueUsers();
			}
		});

		/**
		 * Adds an issue depending on the user input.
		 */
		gui.getBtnAddIssue().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setContentPane(gui.getIp());
				gui.pack();
			}
		});

		/**
		 * Adds an issue depending on the user input.
		 */
		gui.getIp().getCreateButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Creates new issue.
				Issues is = new Issues(gui.getIt().maxIssueId(),
						gui.getChooseUser().getSelectedItem().toString(),
						new Date(),
						gui.getIp().getIssueText().getText(),
						gui.getChoosePriority().getSelectedItem().toString(),
						gui.getIp().getLocationText().getText(),
						"Open");
				is.setCreatedBy(gui.getIt().getCurrentUser());
				is.setLastUpdatedBy(gui.getIt().getCurrentUser());
				is.addUpdated(gui.getIt().getCurrentUser());
				gui.getIt().getIssueList().add(is);
				gui.getIt().tableForIssues();
				//Writes to files.
				gui.getIt().writeXmlFile();
				gui.getIt().writeUsersToXml();
				//Changes panel
				gui.setContentPane(gui.getSpine());
				gui.pack();
			}
		});

		/**
		 * This actionslistener for the login button
		 * checks if the user input is in the list of users.
		 * If the user is not found, a textLabel is changed to "User not found."
		 * and if true Sets the user to logged in.
		 */
		gui.getLp().getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gui.authenticateLogin() == false) {
					gui.getLp().getStatus().setText("Username or password is incorrect.");
				}
			}
		});

		/**
		 * This metod switches the panel to login for a new login
		 * when the buttom switch user is pressed.
		 */
		gui.getBtnSwitchUser().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getLp().getStatus().setText("Not logged in.");
				gui.setContentPane(gui.getLp());
				gui.pack();
			}
		});

		/**
		 * This method changes the update panel if a row is selected.
		 */
		gui.getUpdate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = gui.getqTable().getSelectedRow();
				if (i == -1) {
					System.out.println("Please select a row to edit.");

				} else {
					//gui.updateChooseUser();
					gui.getChooseUser().setSelectedItem(gui.getqTable().getValueAt(i, 1).toString().trim());
					gui.getChoosePrio2().setSelectedItem(gui.getqTable().getValueAt(i, 3).toString());
					gui.getUp().getIssueText().setText(gui.getIt().getSelectedIssue(gui.getqTable()));
					gui.getUp().getLocationText().setText(gui.getqTable().getValueAt(i, 4).toString());
					gui.setContentPane(gui.getUp());
					gui.pack();
				}
			}
		});

		/**
		 * This method edits a row depending on user inputs.
		 */
		gui.getUp().getCreateButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int j = gui.getqTable().getSelectedRow();
				String prio = String.valueOf(gui.getChoosePrio2().getSelectedItem());
				for (Issues i : gui.getIt().getIssueList()) {
					if (i.getId()== Integer.parseInt(gui.getqTable().getValueAt(j, 0).toString())) {
						gui.getChooseUser2();
						gui.getIt().getModel().removeRow(j);
						i.setAssigned(gui.getChooseUser2().getSelectedItem().toString());
						i.setPriority(prio);
						i.setIssue(gui.getUp().getIssueText().getText());
						i.setLocation(gui.getUp().getLocationText().getText());
						i.setLastUpdatedBy(gui.getIt().getCurrentUser());
						i.addUpdated(gui.getIt().getCurrentUser());
						gui.getIt().tableForIssues();
					}
				}

				gui.getIt().writeXmlFile();
				gui.setContentPane(gui.getSpine());
				gui.pack();
			}
		});

		/**
		 * This button attempts to save the current state of the program
		 * when the menu button is pushed and writes a file.
		 */
		gui.getSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveProgram.save(gui.getIt());
				gui.getIt().writeXmlFile();
				gui.getIt().writeUsersToXml();
			}
		});


		/**
		 * This is an actionlistener for the backButton in the updatePanel class
		 * which returns the user to the main panel if the button is pushed.
		 */
		gui.getUp().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setContentPane(gui.getSpine());
			}
		});

		/**
		 * This is an actionlistener for the backButton in the IssuePanel class
		 * which returns the user to the main panel if the button is pushed.
		 */
		gui.getIp().getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setContentPane(gui.getSpine());
			}
		});

		gui.getqTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gui.getDp().getIssueText().setText
						(gui.getIt().getSelectedIssue(gui.getqTable()));

				gui.getDp().getCreatedBy().setText("Created by: " +
						gui.getIt().getCreatedBy(gui.getqTable()));
				gui.getDp().getLastUpdatedBy().setText("Updated by: " +
								gui.getIt().getLastUpdated(gui.getqTable())
				);

			}
		});


		gui.getDp().getUpdates().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = gui.getqTable().getSelectedRow();
				if (i == -1) {
					System.out.println("Please select a row to list all updaters.");
				} else {
					gui.getIt().printAllUpdates(gui.getqTable());
				}
			}
		});

		gui.getDp().getNewProgram().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Process proc = Runtime.getRuntime().exec("java -jar newProgram.jar");
					proc.getOutputStream();
					System.out.println("A new program was started successfully! :D");
				} catch (IOException io) {
					System.out.println("Not working.");
				} finally {

				}
			}
		});
	}




	public static Gui getGui() {
		return gui;
	}

	public static void setGui(Gui gui) {
		Main.gui = gui;
	}
}