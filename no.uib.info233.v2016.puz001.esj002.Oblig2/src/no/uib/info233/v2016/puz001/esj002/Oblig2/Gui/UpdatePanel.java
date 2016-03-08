package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.*;




/**
 * The purpose of this class is to serve as a panel for
 * updating issues.
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
	private JButton backButton = new JButton("Cancel");

	
	
	
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
		
		backButton.setBounds(390, 480, 80, 25);
		panel.add(backButton );
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
	 * This is the button that updates the issue
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
}