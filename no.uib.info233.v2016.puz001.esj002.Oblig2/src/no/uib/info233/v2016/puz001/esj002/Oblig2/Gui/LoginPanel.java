package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/**
 * The purpose of this class is to serve as a panel logging 
 * into the program.
 *
 */
public class LoginPanel extends JPanel implements Serializable{



	
	/**
	 * These are the fields for the LoginPanel.
	 */
	private static final long serialVersionUID = -2311655122465975281L;
	private JLabel userLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JButton loginButton = new JButton("login");
	private JPasswordField passwordText = new JPasswordField(20);
	private JTextField userText = new JTextField(20);
	private JLabel info = new JLabel("Example: Username:admin Password:pass");
	private JLabel status = new JLabel ("Not logged in.");
	
	
	/**
	 * This is the constructor of the LoginPanel which initialized its
	 * components and sets a size pf the panel.
	 */
	public LoginPanel(){
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
		
		status.setBounds(200, 320, 400, 25);
		panel.add(status);

		info.setBounds(200, 150, 500, 25);
		panel.add(info);
		
		userLabel.setBounds(200, 200, 80, 25);
		panel.add(userLabel);


		userText.setBounds(290, 200, 160, 25);
		panel.add(userText);

		
		passwordLabel.setBounds(200, 240, 80, 25);
		panel.add(passwordLabel);


		passwordText.setBounds(290, 240, 160, 25);
		panel.add(passwordText);


		loginButton.setBounds(275, 280, 80, 25);
		panel.add(loginButton);
		
	}

	/**
	 * This is a textfield which takes a user input
	 * and uses the input for authentication.
	 * @return the passwordText
	 */
	public JPasswordField getPasswordText() {
		return passwordText;
	}

	/**
	 * This is a textfield which takes a user input
	 * and uses the input for authentication.
	 * @return the userText
	 */
	public JTextField getUserText() {
		return userText;
	}


	/**
	 * This is the button used for authenticating login info
	 * and changing the content pane if the login is correct.
	 * @return the loginButton
	 */
	public JButton getLoginButton() {
		return loginButton;
	}


	/**
	 * This is a JLabel that simply changes depending on the
	 * status of the login. Tells the user about errors.
	 * @return the status
	 */
	public JLabel getStatus() {
		return status;
	}
}