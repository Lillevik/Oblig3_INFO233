package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.ErrorFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;


/**
 * This is a class which deals with handling the xml files
 * and creating lists of strings and object from the xml file.
 * We added a HashMap to this class to get single instances of the Issues
 * class without having to look through the entire collection. An example of this
 * the ID search function. Using the hashMap uses the ID of the
 */
public class IssueTable implements Serializable{

	public static ErrorFrame errorFrame = new ErrorFrame();
	private static final long serialVersionUID = -6349521349294077303L;
	//Fields for the IssueTable class
	private TableModel model = new TableModel();
	private ArrayList<String> users = new ArrayList<String>();
	private ArrayList<Issues> issueList = new ArrayList<Issues>();
	private HashMap<Integer, Issues> issueMap = new HashMap<>();
	private String currentUser = new String();
	private XmlFilehandling xfh;

	/**
	 * Constructor for the IssueTable class.
	 * The constructor runs some methods at runtime to fill
	 * certain arrays and arrayLists.
	 */
	public IssueTable(XmlFilehandling xfh) {
		addUser("admin");
		this.xfh = xfh;
		xfh.fillUsers(this);
		xfh.fillIssues(this);
		fillMap();
		changePrio();
		tableForIssues();
	}

	/**
	 * This method Lists all the users from the ArrayList users
	 * and displays them in the JTable in Gui.
	 */
	public void listUniqueUsers() {
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Users: ");

		for (String s : users) {
			model.addRow(new Object[]{s});
		}
	}

	/**
	 * Adds a user to the users ArrayList.
	 *
	 * @param name
	 */
	public void addUser(String name) {
		users.add(name);
	}


	public void fillMap(){
		for(Issues i : issueList){
			issueMap.put(i.getId(),i);
		}
	}


	/**
	 * A method to represents all the Issues objects from
	 * the issues ArrayList and represent them in the JTable qTable.
	 */
	public void tableForIssues() {
		tableRows();

		for (Issues issue : issueList) {
			model.addRow(new Object[]{issue.getId(),
					issue.getAssigned(),
					issue.getCreated(),
					issue.getPriority(),
					issue.getLocation(),
					issue.getStatus()});
		}
	}

	/**
	 * This method converts all the int priorities into 5 different Strings
	 * depending on the value if the integer.
	 */
	public void changePrio() {
		if (!xfh.getNewFile().exists()) {
			for (Issues issue : issueList) {
				issue.setPriority(changePrioSingle(issue));
			}
		}
	}

	/**
	 * This method converts all the int priorities into 5 different Strings
	 * depending on the value if the integer.
	 */
	public String changePrioSingle(Issues issue) {
				int prior = Integer.parseInt(String.valueOf(issue.getPriority().trim()));
				if (prior >= 80) {
					issue.setPriority("Kritisk");
				} else if (prior >= 60 && prior < 80) {
					issue.setPriority("Høy");
				} else if (prior >= 40 && prior < 60) {
					issue.setPriority("Normal");
				} else if (prior >= 20 && prior < 40) {
					issue.setPriority("Lav");
				} else if (prior >= 0 && prior < 20) {
					issue.setPriority("Ikke prioritert");
				}
		return issue.getPriority();
	}

	/**
	 * This method returns the selected issue depending on the current
	 * selected row in the JTable.
	 * @param table
	 * @return
     */
	public String getSelectedIssue(JTable table){
		int j = table.getSelectedRow();

		for(Issues i : issueList) {
			if (i.getId() == Integer.parseInt(table.getValueAt(j, 0).toString())){
				return i.getIssue();
			}
		}
		return null;
	}

	/**
	 * This method returns the created by field in an issue
	 * if the field ID entered is the same as an Issue ID.
	 * @param table
	 * @return
     */
	public String getCreatedBy(JTable table){
		int j = table.getSelectedRow();

		for(Issues i : issueList) {
			if (i.getId() == Integer.parseInt(table.getValueAt(j, 0).toString())){
				return i.getCreatedBy();
			}
		}
		return null;
	}

	/**
	 * This method takes a table as a parameter and returns a string
	 * of the Issues field of lastUpdatedBy()
	 * @param table
	 * @return
     */
	public String getLastUpdated(JTable table){
		int j = table.getSelectedRow();
		for(Issues i : issueList) {
			if (i.getId() == Integer.parseInt(table.getValueAt(j, 0).toString())) {
				return i.getLastUpdatedBy();
			}
		}
		return null;
	}

	/**
	 * This method prints all of the updaters on an issue
	 * to the CustomOutPrint textArea.
	 * @param table
     */
	public void printAllUpdates(JTable table){
		int j = table.getSelectedRow();
		for(Issues i : issueList){
			if (i.getId() == Integer.parseInt(table.getValueAt(j, 0).toString())) {
				System.out.println("This issue has been updated by: ");
				for(String s : i.getBeenUpdatedBy()){
					System.out.println(s.trim());
				}
			}
		}
	}


	/**
	 * This method returns the model used for the qTable
	 * in gui.
	 * @return the model
	 */
	public DefaultTableModel getModel() {
		return model;
	}


	/**
	 * This method returns the ArrayList issueList
	 * containing all the Issues objects.
	 * @return the issueList
	 */
	public ArrayList<Issues> getIssueList() {
		return issueList;
	}


	/**
	 * This method returns the users ArrayList
	 * @return the users
	 */
	public ArrayList<String> getUsers() {

		return users;
	}

	/**
	 * This method sets the currentUser of the program.
	 * @param currentUser
     */
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * This method returns the current user String
	 * who is currently logged in to the program.
	 * @return
     */
	public String getCurrentUser() {
		return currentUser;
	}

	/**
	 * This method returns the IssueMap containing issues.
	 * @return
     */
	public HashMap<Integer, Issues> getIssueMap() {
		return issueMap;
	}

	/**
	 * This method takes a Date as a parameter and
	 * converts it to a string with the format month/day/year(mm/dd/yyyy).
	 * It is used to convert the Dates stored in each issue to display
	 * them as strings to the user with a specific format.
	 * @param d
	 * @return
	 */
	public String dateToString(Date d){
		DateFormat writeFormat = new SimpleDateFormat( "MM/dd/yyyy");

		String formattedDate = "";
		if( d != null ) {
			formattedDate = writeFormat.format(d);
		}
		return formattedDate;
	}

	/**
	 * This method converts a String to a date. The method
	 * is used for converting the date Strings in the xml documents
	 * into date formats for each issue. The dates need to be in a
	 * date format in order to properly sort them.
	 * @param s
	 * @return
	 */
	public Date stringToDate(String s){
		DateFormat readFormat = new SimpleDateFormat( "MM/dd/yyyy");
		Date date = null;
		try{
			date = readFormat.parse(s);
		} catch (ParseException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(errorFrame,
					"There was a problem converting the String to a Date.", "Error", JOptionPane.ERROR_MESSAGE);

		}

		if(date != null){
			return date;
		}
		return null;
	}

	/**
	 * This method is made to reduce code duplication
	 * by reusing some code where possible.
	 */
	public void tableRows(){
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Issue ID: ");
		model.addColumn("Assigned to: ");
		model.addColumn("Created: ");
		model.addColumn("Priority: ");
		model.addColumn("Location: ");
		model.addColumn("Status: ");
	}

	public void updateTable(){
		xfh.fillIssues(this);
		changePrio();
		tableForIssues();
	}
}
