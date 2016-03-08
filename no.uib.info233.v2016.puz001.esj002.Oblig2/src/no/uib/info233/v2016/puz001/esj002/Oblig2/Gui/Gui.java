package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;

import java.awt.*;
import java.io.Serializable;

/**
 * This class creates a graphical user interface and 
 * represents components there.
 */
public class Gui extends JFrame implements Serializable{


	
	
	//The fields of the Gui class
	private static final long serialVersionUID = 167504218040359025L;
	private JPanel spine;
	private LoginPanel lp = new LoginPanel();
	private IssuePanel ip = new IssuePanel();
	private UpdatePanel up = new UpdatePanel();

	/*
	 * JPanels used in the Gui.
	 * Can look at it as "Layers",
	 * where panelBackRight is the far back
	 * alligned right in the program.
	 */
	private JPanel panelBackRight;
	private JPanel panelBackLeft;
	private JPanel panelMidTopLeft;
	private JPanel panelBackLeftTop;
	private JPanel panelBackLeftBot;

	/*
	 * All the buttons used in the program.
	 * All the buttons are given action events
	 * in the Main class.
	 */
	private JButton btnSearch;
	private JButton btnListAllIssues;
	private JButton btnListAllUsers;
	private JButton btnAddUser;
	private JButton btnAddIssue;
	private JButton btnDate;
	private JButton btnPrior;
	private JButton btnSwitchUser;
	private JButton update;
	private JButton btnId;

	/*
	 * The JTexfields in the program.
	 * All the JTextFields are
	 * for user input.
	 */
	private JTextField txtSearch;
	private JTextField txtDate;
	private JTextField txtPriority;
	private JTextField txtId;


	/*
	 * searchlabel is the label
	 * above the input fields that says
	 * "query here"
	 */
	private JLabel searchLabel;

	/*
	 * The JTextPanes are simply displaying
	 * info and who you are loged in as.
	 */
	private JTextPane txtInfo;
	private JTextPane txtLoggedIn = new JTextPane();

	/*
	 * The gui class gets and instance of the IssueTable class
	 * to get methods from the class.
	 */
	private IssueTable it = new IssueTable();

	/*
	 * The Jtable qTable (qTable was the intention,
	 * not making a cutie table) is the
	 * table that displays the arraylist
	 * which is made from the xml doc.
	 */
	private JTable qTable = new JTable(it.getModel());

	/*
	 * cardlayout is the layout used in the spine.
	 */
	private CardLayout layout = new CardLayout();

	/*
	 * JComboBoxes are drop down panels
	 * making it easier to chose and input.
	 * The choose user lets you drop down all users etc.
	 *
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox<?> chooseUser = new JComboBox();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox chooseUser2 = new JComboBox(it.getUsers().toArray());
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox choosePrio2 = new JComboBox(it.getPrio().toArray());
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox choosePriority = new JComboBox(it.getPrio().toArray());

	/*
	 * The JMenu items make the menue on the top of the program
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu help = new JMenu("Help");
	private JMenuItem save = new JMenuItem("Save");
	@SuppressWarnings("unused")
	private JMenuItem about = new JMenuItem("About");

	/**
	 * Constructor for the Gui class which extends from JFrame.
	 * Creates the Gui and fills it with components.
	 */
	public Gui(){
		super("Issue Tracker");
		spine = new JPanel(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spine.setLayout(new BorderLayout(0, 0));
		spine.setPreferredSize(new Dimension(700, 600));
		
		setupComponents();
		updateChooseUser();
		setJMenuBar(menuBar);
		setContentPane(lp);
		
		pack();
		setVisible(true);
	}

	/**
	 * Initializes components and
	 * sets them up with custom designs.
	 */
	public void setupComponents(){

		/**
		 * Sets up the JMenu
		 */
		menuBar.add(file);
		menuBar.add(help);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem about = new JMenuItem("About");
		file.add(save);
		help.add(about);
		
		/**
		 * Sets up the JTable.
		 * makin it a cutetable;)
		 */
		qTable.setBackground(Color.white);
		qTable.getAutoResizeMode();
		qTable.setFillsViewportHeight(true);

		/**
		 *Initialize the JPanels
		 */
		panelBackLeft = new JPanel();
		panelBackRight = new JPanel();
		panelMidTopLeft = new JPanel();
		panelBackLeftTop = new JPanel();
		panelBackLeftBot = new JPanel();

		/**
		 * init the one and only JLabels in the class
		 */
		searchLabel = new JLabel();

		/**
		 * init the JTexFields in the class
		 */
		txtSearch = new JTextField("search/add User");
		txtDate = new JTextField("search date mm/dd/yy");
		txtPriority = new JTextField("search prior");
		txtId = new JTextField("Search ID");

		/**
		 * setting up the ComboBoxes
		 * makin em pretty
		 */
		chooseUser.setBounds(290, 200, 160, 25);
		ip.add(chooseUser);
		choosePriority.setBounds(290, 240, 160, 25);
		ip.add(choosePriority);
		chooseUser2.setBounds(290, 200, 160, 25);
		up.add(chooseUser2);
		choosePrio2.setBounds(290, 240, 160, 25);
		up.add(choosePrio2);

		/**
		 * Setting up the JPanel layers in the program
		 * making everything fit and look ok+
		 */
		panelBackLeft.setPreferredSize(new Dimension(200, 300));
		panelBackLeft.setBackground(Color.gray);
		panelBackLeft.setLayout(new BorderLayout());

		panelBackRight.setPreferredSize(new Dimension(200, 50));
		panelBackRight.setBackground(Color.white);

		panelBackLeftTop.setBackground(Color.GRAY);
		panelBackLeftBot.setBackground(Color.LIGHT_GRAY);
		panelBackLeftTop.setPreferredSize(new Dimension(100, 525));

		searchLabel.setPreferredSize(new Dimension(190, 20));
		searchLabel.setText("Query here");

		txtSearch.setPreferredSize(new Dimension(190, 20));
		txtDate.setPreferredSize(new Dimension(190, 20));
		txtPriority.setPreferredSize(new Dimension(190, 20));
		txtId.setPreferredSize(new Dimension(190, 20));

		btnSearch = new JButton("Search");
		btnListAllIssues = new JButton("List Issues");
		btnListAllUsers = new JButton("List users");
		btnAddUser = new JButton("Add");
		btnAddIssue = new JButton("Add issue");
		btnDate = new JButton("Search Date");
		btnPrior = new JButton("Search Prior");
		btnSwitchUser = new JButton("Switch user");
		update = new JButton("Update issue");
		btnId = new JButton("Search ID");

		/**
		 * seting up the buttons
		 * pretty etc
		 */
		btnSearch.setSize(new Dimension( 20, 20));
		btnListAllUsers.setSize(new Dimension(20, 20));
		btnAddUser.setSize(new Dimension(20, 20));
		btnListAllIssues.setSize(new Dimension( 20, 20));
		btnSwitchUser.setSize(new Dimension( 20, 20));
		update.setSize(new Dimension( 20, 20));
		btnId.setSize(new Dimension( 20, 20));

		/**
		 * Setting up the JLabels for txt info and login info
		 * filling the info
		 */
		txtInfo = new JTextPane();
		txtInfo.setText("Fill a field and press the correct button to search. Date field -> Date btn etc");
		txtInfo.setPreferredSize(new Dimension(190, 100));
		txtInfo.setBackground(Color.gray);
		txtLoggedIn.setText("Not logged in");
		txtLoggedIn.setBackground(Color.LIGHT_GRAY);
		txtLoggedIn.setEditable(false);
		txtLoggedIn.setPreferredSize(new Dimension(190, 20));

		/**
		 * where all the components are added to the
		 * correct JPanels or "Layers" of the program.
		 */
		spine.add(menuBar);
		spine.add(panelBackRight, BorderLayout.CENTER);
		spine.add(panelBackLeft, BorderLayout.WEST);
		panelBackRight.add(panelMidTopLeft);
		panelBackLeft.add(panelBackLeftTop, BorderLayout.NORTH);
		panelBackLeft.add(panelBackLeftBot, BorderLayout.CENTER);
		panelBackLeftTop.add(searchLabel);
		panelBackLeftTop.add(txtSearch);
		panelBackLeftTop.add(btnSearch);
		panelBackLeftTop.add(btnAddUser);
		panelBackLeftTop.add(txtDate);
		panelBackLeftTop.add(btnDate);
		panelBackLeftTop.add(txtPriority);
		panelBackLeftTop.add(btnPrior);
		panelBackLeftTop.add(txtId);
		panelBackLeftTop.add(btnId);
		panelBackLeftTop.add(btnAddIssue);
		panelBackLeftTop.add(update);
		panelBackLeftTop.add(btnListAllUsers);
		panelBackLeftTop.add(btnListAllIssues);
		panelBackLeftTop.add(txtInfo);
		panelBackLeftBot.add(txtLoggedIn);
		panelBackLeftBot.add(btnSwitchUser);
		panelMidTopLeft.add(new JScrollPane(qTable));
	}


	/**
	 * Used to authenicate user logins.
	 * Checks if the user and password field is correct.
	 * This is just a predefined value since the point wasnt to make
	 * a functional user login database.
	 * @return boolean if authentication was successful or not
	 */
	@SuppressWarnings("deprecation")
	public boolean authenticateLogin(){
		for(String s : getIt().getUsers()){
			if(s.equals(lp.getUserText().getText()) && lp.getPasswordText().getText().equals("pass")){
				getTxtLoggedIn().setText("Logged in as: " + lp.getUserText().getText());
				setContentPane(getSpine());
				return true;
			} 
		} 
		return false;
	}
	
	
	/**
	 * This method updates  The JComboButton with new info from the users list.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateChooseUser(){
		chooseUser.setModel(new DefaultComboBoxModel(it.getUsers().toArray()));
		chooseUser2 = chooseUser;
	}
	
	/**
	 * The qtable is the table displaying the lists.
	 * the contents of the table are edited by other methods
	 * mainly it contains users and issues.
	 * @return the qTable
	 */
	public JTable getqTable() {
		return qTable;
	}

	/**
	 * hehe get it?
	 * it is an instance of the IssueTable class.
	 * It has a getter in Gui since it is required in
	 * other classes, but we dont want to initialize the
	 * class more than one time.
	 * So getting a method in main from issuetable is
	 * possible via:
	 * gui.getIt().getSomethingFromIt();
	 * @return the it
	 */
	public IssueTable getIt() {
		return it;
	}

	/**
	 * The spine is the ship
	 * carrying it all.
	 * The spine is the backMost JPanel
	 * in the program, holding everything.
	 * @return the spine
	 */
	public JPanel getSpine() {
		return spine;
	}

	/**
	 * Getter for the JButton btnSearch
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * The button search is the button to init your querries.
	 * It takes userInput and looksfor the input (depending on what input)
	 * and looks for it in the arrays, then edits the qTable to
	 * match the useres specifications.
	 * @return the txtSearch
	 */
	public JTextField getTxtSearch() {
		return txtSearch;
	}


	/**
	 * button for editing the table to list all issues
	 * from the array into the qTable;
	 * @return the btnListAllIssues
	 */
	public JButton getBtnListAllIssues() {
		return btnListAllIssues;
	}

	/**
	 * button for editing the table to list only all
	 * the unique users into the qTable.
	 * @return btnListAllUsers
     */
	public JButton getBtnListAllUsers() {
		return btnListAllUsers;
	}

	/**
	 * The btn for add user lets you add a new user to the list.
	 * It takes one input-string and creates the user and then puts it
	 * into the array.
	 * @return the btnAddUser
	 */
	public JButton getBtnAddUser() {
		return btnAddUser;
	}
	
	/**
	 * The btnAddIssue is a button that sends you to a new
	 * panel, the IssuePanel.
	 * read more in the IssuePanel class.
	 * @return the btnAddIssue
	 */
	public JButton getBtnAddIssue() {
		return btnAddIssue;
	}

	/**
	 * The btnDate is a button that lets you search for a
	 * specific date in the issue table.
	 * It takes user input and matches the inputed string in the list
	 * and edits the table accordingly to the users specifications.
	 * @return the btnDate
	 */
	public JButton getBtnDate() {
		return btnDate;
	}

	/**
	 * the btnPrior is a button that lets the user search for a specific priortiy.
	 * all the issues has a priority number from 1 to 100.
	 * The button edits the table and fills it accordingly to the users specifications.
	 * @return the btnPrior
	 */
	public JButton getBtnPrior() {
		return btnPrior;
	}

	/**
	 * txtDate is a JTextField that lets the user input
	 * a specific date for searching in the database.
	 * The JTextField is used in the Main class to bind it to a button
	 * with an actionEvent.
	 * @return the txtDate
	 */
	public JTextField getTxtDate() {
		return txtDate;
	}

	/**
	 * txtPriority is a JTextfield that lets the user
	 * input a specific priority and search the database for that priority.
	 * The Textfield is used in the Main class to bind it to a button with an actionevent
	 * that lets the user search for a specific priority.
	 * @return the txtPriority
	 */
	public JTextField getTxtPriority() {
		return txtPriority;
	}

	/**
	 * The txtLoggedIn is a JTextPane, it cannot accept inputs
	 * and is used to inform the user who is currently logged in.
	 * @return the txtLoggedIn
	 */
	public JTextPane getTxtLoggedIn() {
		return txtLoggedIn;
	}

	/**
	 * lp is an instance of the class "LoginPanel".
	 * It is initialized in the Gui class to get methods from lp into Gui.
	 * It has a getter in gui so that it can be gotten from other classes aswell
	 * without having to initialize it again.
	 * @return the lp
	 */
	public LoginPanel getLp() {
		return lp;
	}

	/**
	 * The JComboBox "ChooseUsers" is a drop down panel styled user input
	 * that lets the user easily choose the required user.
	 * @return the chooseUser
	 */
	public JComboBox<?> getChooseUser() {
		return chooseUser;
	}

	/**
	 * The choose prioirty is a JComboBox that lets the
	 * user 'easily' choose a priortiy from 1 to 100.
	 * @return the choosePriority
	 */
	public JComboBox<?> getChoosePriority() {
		return choosePriority;
	}

	/**
	 * The ip is an instance of the class "IssuePanel".
	 * The panel is initialized in gui and has a getter so that methods from
	 * ip can be requested thorugh Gui without having to create a new IssuePanel.
	 * @return the ip
	 */
	public IssuePanel getIp() {
		return ip;
	}

	/**
	 * The btnSwitchUser takes you back to the login page.
	 * @return the btnSwitchUser
	 */
	public JButton getBtnSwitchUser() {
		return btnSwitchUser;
	}

	/**
	 * up is an instance of the Class up.
	 * Just like ip, lp, up and it, it's initialized in Gui to get methods from the class in gui.
	 * It has a getter so that other classes that gets Gui can get methods from it aswell.
	 *                                                                           ^ lel
	 * @return the up
	 */
	public UpdatePanel getUp() {
		return up;
	}

	/**
	 * The button "update" lets the user update the
	 * list and make changes on issues in the list.
	 * @return the update
	 */
	public JButton getUpdate() {
		return update;
	}

	/**
	 * chooseuser2 is a jcomboBox used for drop-down
	 * selecting users.
	 * The reason there are two of each drop user and prior JComboBox
	 * is that there are two different panels where they are used.
	 * In updating an issue, and when creating an issue.
	 * @return the chooseUser2
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getChooseUser2() {
		return chooseUser2;
	}

	/**
	 * chooseprio2 is a jcomboBox used for drop-down
	 * selecting priority.
	 * The reason there are two of each drop user and prior JComboBox
	 * is that there are two different panels where they are used.
	 * In updating an issue, and when creating an issue.
	 * @return the choosePrio2
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getChoosePrio2() {
		return choosePrio2;
	}

	/**
	 * save is a JMenu item. It does nothing but look cool for the time being.
	 * @return the save
	 */
	public JMenuItem getSave() {
		return save;
	}

	/**
	 * btnId lets the user search for a specific issue, with a specific ID.
	 * The list will update accordingly to the users specifications.
	 * @return the btnId
	 */
	public JButton getBtnId() {
		return btnId;
	}

	/**
	 * txtId is a JTextField for user input when searching for a specific
	 * issue with a specific ID.
	 * @return the txtId
	 */
	public JTextField getTxtId() {
		return txtId;
	}

}