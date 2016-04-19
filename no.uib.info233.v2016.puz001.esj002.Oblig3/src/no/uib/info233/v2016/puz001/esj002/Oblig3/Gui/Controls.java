package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.IssueTable;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.SaveProgram;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.XmlFilehandling;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.util.EventListener;

/**
 * Created by goat on 19.04.16.
 */
public class Controls {
    private Gui gui;
    private IssueTable it;
    private XmlFilehandling xfh;

    public Controls(Gui g, IssueTable it, XmlFilehandling x){
        this.gui = g;
        this.it = it;
        this.xfh = x;
    }

    public void addActions(){
        userSearch();
        idSearch();
        prioritySearch();
        dateSearch();
        listAllusers();
        listAllIssues();
        addNewUser();
        changeToIssuePanel();
        createNewIssue();
        login();
        switchUser();
        updatePanel();
        updateIssue();
        returnFromUpdatePanel();
        returnFromIssuePanel();
        showIssueText();
        listAllUpdaters();
        startNewProgram();
        updateIssueListFromFile();
    }


    /**
     * This method adds and action listener to the
     * btnSearch JButton from gui so  that is searches
     * for all issues by the given user.
     */
    public void userSearch(){

        gui.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                it.tableRows();
                for (Issues issue : it.getIssueList()) {
                    if (issue.getAssigned().toString().trim().equals(gui.getTxtSearch().getText().trim())) {
                        it.getModel().addRow(new Object[]{issue.getId(),
                                issue.getAssigned(),
                                issue.getCreated(),

                                issue.getPriority(),
                                issue.getLocation(),
                                issue.getStatus()});
                    }
                }
            }
        });
    }


    /**
     * This is an actionListener for the btnId which
     * finds a specific issue and displays it in the JTable.
     */
    public void idSearch(){

        gui.getBtnId().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
				/*	it.tableRows();
					Issues issue = it.getIssueMap().get(Integer.parseInt(gui.getTxtId().getText()));

					it.getModel().addRow(new Object[]{issue.getId(),
							issue.getAssigned(),
							issue.getCreated(),
							issue.getPriority(),
							issue.getLocation(),
							issue.getStatus()});
				} catch (IndexOutOfBoundsException f) {
					JOptionPane.showMessageDialog(it.errorFrame, "Error getting ID's");
				}*/

                    Issues issue = it.getIssueList().get(Integer.parseInt(gui.getTxtId().getText()) - 1);

                    it.tableRows();
                    it.getModel().addRow(new Object[]{issue.getId(),
                            issue.getAssigned(),
                            issue.getCreated(),
                            issue.getPriority(),
                            issue.getLocation(),
                            issue.getStatus()});
                    System.out.println(issue.getId());
                } catch (IndexOutOfBoundsException f) {
                    JOptionPane.showMessageDialog(it.errorFrame, "Error getting ID's");
                }
            }
        });
    }

    /**
     * This method finds all the issues with
     * a priority higher than the user input from the textfield.
     */
    public void prioritySearch(){

        gui.getBtnPrior().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                it.tableRows();

                for (Issues issue : it.getIssueList()) {
                    if (issue.getPriority().equals(gui.getSearchPrior().getSelectedItem().toString())) {
                        it.getModel().addRow(new Object[]{issue.getId(),
                                issue.getAssigned(),
                                issue.getCreated(),
                                issue.getPriority(),
                                issue.getLocation(),
                                issue.getStatus()});
                    }
                }
            }
        });
    }

    /**
     * This lists all the issues on a specific date and lists them
     * in the JTable for the user to see.
     */
    public void dateSearch(){

        gui.getBtnDate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                it.tableRows();
                for (Issues issue : it.getIssueList()) {
                    if (it.dateToString(issue.getCreated()).equals(gui.getTxtDate().getText())) {
                        it.getModel().addRow(new Object[]{issue.getId(),
                                issue.getAssigned(),
                                issue.getCreated(),
                                issue.getPriority(),
                                issue.getLocation(),
                                issue.getStatus()});
                        System.out.print(issue.getCreated());
                    }
                }

            }
        });
    }

    /**
     * This method lists all the unique users and
     * presents them using a JTable
     */
    public void listAllusers(){

        gui.getBtnListAllUsers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                it.listUniqueUsers();

            }
        });
    }

    /**
     * This method lists all the issues from the arrayList issues
     * and presents them in the JTable qtable using methods from
     * IssueTable.
     */
    public void listAllIssues(){


        gui.getBtnListAllIssues().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                it.tableRows();

                for (Issues i : it.getIssueList()) {
                    it.getModel().addRow(new Object[]{i.getId(),
                            i.getAssigned(),
                            i.getCreated(),
                            i.getPriority(),
                            i.getLocation(),
                            i.getStatus()});
                }
            }
        });
    }

    public void addNewUser(){
        /**
         * This method simply adds a user to the arrayList users
         * using methods from IssueTable.
         */
        gui.getBtnAddUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Adds a user to the list
                it.addUser(gui.getTxtSearch().getText());
                gui.updateChooseUser();
                //Writes to the userFile
                xfh.writeUsersToXml(it);
                //Changes the panel
                it.listUniqueUsers();
            }
        });
    }


    /**
     * Adds an issue depending on the user input.
     */
    public void changeToIssuePanel(){
    gui.getBtnAddIssue().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setContentPane(gui.getIp());
            gui.pack();
        }
    });
    }

    /**
     * Creates the new ISSUE and
     * Adds an issue depending on the user input.
     */
    public void createNewIssue(){
    gui.getIp().getCreateButton().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Creates new issue.
            //xfh.fillIssues(it);
            Issues is = new Issues(Integer.parseInt(xfh.getHighest()),
                    gui.getChooseUser().getSelectedItem().toString(),
                    new Date(),
                    gui.getIp().getIssueText().getText(),
                    gui.getChoosePriority().getSelectedItem().toString(),
                    gui.getIp().getLocationText().getText(),
                    "Open");
            is.setCreatedBy(it.getCurrentUser());
            is.setLastUpdatedBy(it.getCurrentUser());
            is.addUpdated(it.getCurrentUser());
            it.getIssueList().add(is);
            it.tableForIssues();

            //Writes to files.
            xfh.writeXmlFile(it);
            xfh.writeUsersToXml(it);
            //Changes panel
            gui.setContentPane(gui.getSpine());
            gui.pack();
        }
    });}

    /**
     * This actionslistener for the login button
     * checks if the user input is in the list of users.
     * If the user is not found, a textLabel is changed to "User not found."
     * and if true Sets the user to logged in.
     */

    public void login(){
    gui.getLp().getLoginButton().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.authenticateLogin() == false) {
                gui.getLp().getStatus().setText("Username or password is incorrect.");
            }
        }
    });}

    /**
     * This metod switches the panel to login for a new login
     * when the buttom switch user is pressed.
     */
    public void switchUser(){
    gui.getBtnSwitchUser().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getLp().getStatus().setText("Not logged in.");
            gui.setContentPane(gui.getLp());
            gui.pack();
        }
    });}

    /**
     * This method changes the update panel if a row is selected.
     */
    public void updatePanel(){
    gui.getUpdate().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = gui.getqTable().getSelectedRow();
            if (i == -1) {
                System.out.println("Please select a row to edit.");
            } else {
                //gui.updateChooseUser();
                gui.getChooseUser2().setSelectedItem(gui.getqTable().getValueAt(i, 1).toString().trim());
                gui.getChoosePrio2().setSelectedItem(gui.getqTable().getValueAt(i, 3).toString());
                gui.getUp().getIssueText().setText(it.getSelectedIssue(gui.getqTable()));
                gui.getUp().getLocationText().setText(gui.getqTable().getValueAt(i, 4).toString());
                gui.setContentPane(gui.getUp());
                gui.pack();
            }
        }
    });}

    /**
     * UPDATES an issue.
     * This method edits a row depending on user inputs.
     */
    public void updateIssue(){
    gui.getUp().getCreateButton().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int j = gui.getqTable().getSelectedRow();
            String prio = String.valueOf(gui.getChoosePrio2().getSelectedItem());
            for (Issues i : it.getIssueList()) {
                if (i.getId() == Integer.parseInt(gui.getqTable().getValueAt(j, 0).toString())) {
                    gui.getChooseUser2();
                    it.getModel().removeRow(j);
                    i.setAssigned(gui.getChooseUser2().getSelectedItem().toString());
                    i.setPriority(prio);
                    i.setIssue(gui.getUp().getIssueText().getText());
                    i.setLocation(gui.getUp().getLocationText().getText());
                    i.setLastUpdatedBy(it.getCurrentUser());
                    i.addUpdated(it.getCurrentUser());
                    it.tableForIssues();
                }
            }

            xfh.writeXmlFile(it);
            gui.setContentPane(gui.getSpine());
            gui.pack();
        }
    });}

    /**
     * This is an actionlistener for the backButton in the updatePanel class
     * which returns the user to the main panel if the button is pushed.
     */
    public void returnFromUpdatePanel(){
    gui.getUp().getBackButton().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setContentPane(gui.getSpine());
        }
    });}

    /**
     * This is an actionlistener for the backButton in the IssuePanel class
     * which returns the user to the main panel if the button is pushed.
     */
    public void returnFromIssuePanel(){
    gui.getIp().getBackButton().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setContentPane(gui.getSpine());
        }
    });}

    /**
     * This method lists the IssueText of the currentSelected row.
     */
    public void showIssueText(){
    gui.getqTable().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            gui.getDp().getIssueText().setText
                    (it.getSelectedIssue(gui.getqTable()));

            gui.getDp().getCreatedBy().setText("Created by: " +
                    it.getCreatedBy(gui.getqTable()));
            gui.getDp().getLastUpdatedBy().setText("Updated by: " +
                            it.getLastUpdated(gui.getqTable())
            );
        }
    });}


    /**
     * This method prints all the users who have updated the issue
     * that is currently selected in the JTable.
     */
    public void listAllUpdaters(){
    gui.getDp().getUpdates().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = gui.getqTable().getSelectedRow();
            if (i == -1) {
                System.out.println("Please select a row to list all updaters.");
            } else {
                it.printAllUpdates(gui.getqTable());
            }
        }
    });}

    /**
     * This method starts a .Jar file which is currently stored
     * the same place the project folder is.
     */
    public void startNewProgram(){
    gui.getDp().getNewProgram().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Process proc = Runtime.getRuntime().exec("java -jar newProgram.jar");
                proc.getOutputStream();
                System.out.println("A new program was started successfully! :D");
            } catch (IOException io) {
                System.out.println("Could not find the newProgram.jar file.");
            }
        }
    });}

    public void updateIssueListFromFile(){
    gui.getDp().getUpdateList().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            it.updateTable();
        }
    });}

}
