package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.User;

/**
 * This is a class which deals with handling the xml files
 * and creating lists of strings and object from the xml file.
 */
public class IssueTable implements Serializable {


	private static final long serialVersionUID = -6349521349294077303L;
	//Fields for the IssueTable class
	private File file = new File("old_issues.xml");
	private File newFile = new File("new_issues.xml");
	private File userFile = new File("issueTracker_users.xml");
	private transient DefaultTableModel model = new DefaultTableModel();
	private ArrayList<String> users = new ArrayList<String>();
	private ArrayList<Issues> issueList = new ArrayList<Issues>();
	private String currentUser = new String();
	private SecureRandom random = new SecureRandom();


	/**
	 * Constructor for the IssueTable class.
	 * The constructor runs some methods at runtime to fill
	 * certain arrays and arrayLists.
	 */
	public IssueTable() {
		addUser("admin");
		fillUsers();
		fillIssues();
		changePrio();
		tableForIssues();
	}


	/**
	 * This method takes all the assigned users from the
	 * xml document "old_issues.xml" and places them into the ArrayList users.
	 */
	public void fillUsers() {
		if (!userFile.exists()) {


			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
				doc.getDocumentElement().normalize();

				NodeList nodelist = doc.getElementsByTagName("ISSUES");
				for (int i = 0; i < nodelist.getLength(); i++) {
					Node node = nodelist.item(i);
					Element eElement = (Element) node;
					if (!users.contains(eElement.getAttribute("assigned_user")))
						users.add(eElement.getAttribute("assigned_user"));
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(userFile);
				doc.getDocumentElement().normalize();

				NodeList nodelist = doc.getElementsByTagName("USER");
				for (int i = 0; i < nodelist.getLength(); i++) {
					Node node = nodelist.item(i);
					Element eElement = (Element) node;
					if (!users.contains(eElement.getAttribute("name")))
						users.add(eElement.getAttribute("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
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


	/**
	 * This method adds all the ISSUES elements in the old_issues.xml file
	 * as object of Issues into the issues ArrayList.
	 */
	public void fillIssues() {
		if (!newFile.exists()) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
				NodeList nodelist = doc.getElementsByTagName("ISSUES");

				for (int i = 0; i < nodelist.getLength(); i++) {

					Node node = nodelist.item(i);
					Element eElement = (Element) node;
					Issues issue = new Issues(eElement.getAttribute("id"),
							eElement.getAttribute("assigned_user"),
							eElement.getAttribute("created"),
							eElement.getAttribute("text"),
							eElement.getAttribute("priority"),
							eElement.getAttribute("location"),
							"Not set");
						issue.setCreatedBy(eElement.getAttribute("assigned_user"));

					issueList.add(issue);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(newFile);
				NodeList nodelist = doc.getElementsByTagName("ISSUES");

				for (int i = 0; i < nodelist.getLength(); i++) {

					Node node = nodelist.item(i);
					Element eElement = (Element) node;
					Issues issue = new Issues(eElement.getAttribute("id"),
							eElement.getAttribute("assigned_user"),
							eElement.getAttribute("created"),
							eElement.getAttribute("text"),
							eElement.getAttribute("priority"),
							eElement.getAttribute("location"),
							eElement.getAttribute("status"));
						issue.setCreatedBy(eElement.getAttribute(("created_by")));


					issueList.add(issue);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * A method to represents all the Issues objects from
	 * the issues ArrayList and represent them in the JTable qTable.
	 */
	public void tableForIssues() {
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Issue ID: ");
		model.addColumn("Assigned to: ");
		model.addColumn("Created: ");
		model.addColumn("Priority: ");
		model.addColumn("Location: ");
		model.addColumn(("Status: "));

		for (Issues issue : issueList) {
			model.addRow(new Object[]{issue.getId(),
					issue.getAssigned(),
					issue.getCreated(),
					issue.getPriority(),
					issue.getLocation(),
					issue.getStatus()});
		}
	}

	public void changePrio() {
		if (!newFile.exists()) {
			for (Issues issue : issueList) {
				int prior = Integer.parseInt(String.valueOf(issue.getPriority().trim()));
				if (prior >= 80) {
					issue.setPriority("Kritisk");
				} else if (prior >= 60 && prior < 80) {
					issue.setPriority("Høy");
				} else if (prior >= 40 && prior < 60) {
					issue.setPriority("Normal");
				} else if (prior >= 20 && prior < 40) {
					issue.setPriority("Lav");
				} else if (prior >= 0 && prior < 40) {
					issue.setPriority("Ikke prioritert");
				}
			}
		}
	}


	/**
	 * @return The highest current Issue ID from the issues list.
	 */
	public String maxIssueId() {
		Comparator<Issues> iss = Comparator.comparing(Issues::idInt);
		return Integer.toString(Collections.max(issueList, iss).idInt() + 1);
	}

	public String getSelectedIssue(JTable table){
		int j = table.getSelectedRow();

		for(Issues i : issueList) {
			if (i.getId().equals(table.getValueAt(j, 0).toString())){
				return i.getIssue();
			}
		}
		return null;
	}

	public String getCreatedBy(JTable table){
		int j = table.getSelectedRow();

		for(Issues i : issueList) {
			if (i.getId().equals(table.getValueAt(j, 0).toString())){
				return i.getCreatedBy();
			}
		}
		return null;
	}


	/**
	 * This method returns a string of the current date the day it is called.
	 * Used in the assIssue button.
	 *
	 * @return current date as a string
	 */
	public String currentDate() {
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		String date = month + "/" + day + "/" + year;
		return date;
	}

	/**
	 * This method writes all the objects and string in issueList and users list
	 * into a single xml file containing all their info.
	 */
	public void writeXmlFile() {

		try {

			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();

			Element root = doc.createElement("Dataset");
			doc.appendChild(root);


			for (Issues i : issueList) {

				Element details = doc.createElement("ISSUES");
				root.appendChild(details);

				details.setAttribute("id", i.getId());
				details.setAttribute("assigned_user", i.getAssigned());
				details.setAttribute("created", i.getCreated());
				details.setAttribute("text", i.getIssue());
				details.setAttribute("priority", i.getPriority());
				details.setAttribute("location", i.getLocation());
				details.setAttribute("status", i.getStatus());
				details.setAttribute("created_by", i.getCreatedBy());
			}



			// Save the document to the disk file
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			// format the XML nicely
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			aTransformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fos = new FileWriter(newFile);
				StreamResult result = new StreamResult(fos);
				aTransformer.transform(source, result);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (TransformerException ex) {
			System.out.println("Error outputting document");

		} catch (ParserConfigurationException ex) {
			System.out.println("Error building document");
		}
	}

	public void writeUsersToXml(){
		try {

			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();

			Element root = doc.createElement("Users");
			doc.appendChild(root);

			for (String i : users) {
				Element user = doc.createElement("USER");
				root.appendChild(user);
				user.setAttribute("name", i);
			}

			// Save the document to the disk file
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			// format the XML nicely
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			aTransformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fos = new FileWriter(userFile);
				StreamResult result = new StreamResult(fos);
				aTransformer.transform(source, result);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (TransformerException ex) {
			System.out.println("Error outputting document");

		} catch (ParserConfigurationException ex) {
			System.out.println("Error building document");
		}

	}


	public String randomPass() {
		return new BigInteger(64, random).toString(32);
	}


	/**
	 * @return the model
	 */
	public DefaultTableModel getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}


	/**
	 * @return the issueList
	 */
	public ArrayList<Issues> getIssueList() {
		return issueList;
	}


	/**
	 * @param issueList the issueList to set
	 */
	public void setIssueList(ArrayList<Issues> issueList) {
		this.issueList = issueList;
	}


	/**
	 * @return the users
	 */
	public ArrayList<String> getUsers() {

		return users;
	}
}