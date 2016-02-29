package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.*;




/**
 * The purpose of this class is to serve as a panel for
 * updating issues.
 * @author mariuslillevik
 *
 */
public class UpdatePanel extends JPanel implements Serializable{


	
	/**
	 * These are the fields for the UpdatePanel	
	 */
	private static final long serialVersionUID = 4161520540703687836L;
	private JLabel userLabel = new JLabel("Assign to:");
	private JLabel priority = new JLabel("Priority:");
	private JLabel locationField = new JLabel("Location:");
	private JTextField locationText = new JTextField();
	private JTextArea issueText = new JTextArea("Write issue here.");
	private JButton createButton = new JButton("Update");

	
	
	
	/**
	 * This is the constructor of the issuePanel which initialized its
	 * components and sets a size pf the panel.
	 */
	public UpdatePanel(){
		setPreferredSize(new Dimension(700, 600));
		placeComponents(this);
		setVisible(true);
	}

	/**
	 * This is the method that sets up and add all the 
	 * components to the panel.
	 * @param panel
	 */
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		userLabel.setBounds(200, 200, 80, 25);
		panel.add(userLabel);

		
		priority.setBounds(200, 240, 80, 25);
		panel.add(priority);
		
		locationField.setBounds(200, 280, 80, 25);
		panel.add(locationField);
		
		locationText.setBounds(290, 280, 160, 25);
		panel.add(locationText);

		createButton.setBounds(275, 480, 80, 25);
		panel.add(createButton);
		
		issueText.setBounds(290, 320, 160, 125);
		panel.add(issueText);

		
	}

	/**
	 * @return the userLabel
	 */
	public JLabel getUserLabel() {
		return userLabel;
	}

	/**
	 * @param userLabel the userLabel to set
	 */
	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	/**
	 * @return the passwordLabel
	 */
	public JLabel getPasswordLabel() {
		return priority;
	}

	/**
	 * @param passwordLabel the passwordLabel to set
	 */
	public void setPasswordLabel(JLabel passwordLabel) {
		this.priority = passwordLabel;
	}

	/**
	 * @return the loginButton
	 */
	public JButton getLoginButton() {
		return createButton;
	}

	/**
	 * @param loginButton the loginButton to set
	 */
	public void setLoginButton(JButton loginButton) {
		this.createButton = loginButton;
	}


	/**
	 * @return the priority
	 */
	public JLabel getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(JLabel priority) {
		this.priority = priority;
	}


	/**
	 * @return the locationText
	 */
	public JTextField getLocationText() {
		return locationText;
	}

	/**
	 * @param locationText the locationText to set
	 */
	public void setLocationText(JTextField locationText) {
		this.locationText = locationText;
	}

	/**
	 * @return the issueText
	 */
	public JTextArea getIssueText() {
		return issueText;
	}

	/**
	 * @param issueText the issueText to set
	 */
	public void setIssueText(JTextArea issueText) {
		this.issueText = issueText;
	}

	/**
	 * @return the location
	 */
	public JLabel getLocationField() {
		return locationField;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocationField(JLabel location) {
		this.locationField = location;
	}

	/**
	 * @return the createButton
	 */
	public JButton getCreateButton() {
		return createButton;
	}

	/**
	 * @param createButton the createButton to set
	 */
	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}
}