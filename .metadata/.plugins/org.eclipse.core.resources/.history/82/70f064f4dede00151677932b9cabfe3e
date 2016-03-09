package no.uib.info233.v2016.puz001.esj002.Oblig2.Gui;

import javax.swing.*;
import no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling.IssueTable;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by esj002 and puz001
 * This class creates a graphical user interface and 
 * represents components there.
 */
public class Gui extends JFrame implements Serializable{


	
	/**
	 * The fields of the Gui class
	 */
	private static final long serialVersionUID = 167504218040359025L;
	private JPanel spine;
	private LoginPanel lp = new LoginPanel();
	private IssuePanel ip = new IssuePanel();
	private UpdatePanel up = new UpdatePanel();
	private JPanel panelBackRight;
	private JPanel panelBackLeft;
	private JPanel panelMidTopLeft;
	private JPanel panelBackLeftTop;
	private JPanel panelBackLeftBot;

	//Jbuttons
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
	
	//JTextFields
	private JTextField txtSearch;
	private JTextField txtDate;
	private JTextField txtPriority;
	private JTextField txtId;



	//JLabels
	private JLabel searchLabel;

	//JTextPanes
	private JTextPane txtInfo;
	private JTextPane txtLoggedIn = new JTextPane();

	//Instance of the IssueTable class
	private IssueTable it = new IssueTable();
	

	//JTable
	private JTable qTable = new JTable(it.getModel());

	private CardLayout layout = new CardLayout();
	
	//JComboBoxes
	@SuppressWarnings("rawtypes")
	private JComboBox<?> chooseUser = new JComboBox();
	
	//JComboBoxes for the UpdatePanel class
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox chooseUser2 = new JComboBox(it.getUsers().toArray());
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox choosePrio2 = new JComboBox(it.getPrio().toArray());
	
	//JMenu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu help = new JMenu("Help");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem about = new JMenuItem("About");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox choosePriority = new JComboBox(it.getPrio().toArray());
	


	
	
	/**
	 * Constructor for the Gui class which extends from JFrame.
	 * Creates the Gui and starts it up.
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
		
		//Sets up the JMenu
		menuBar.add(file);
		menuBar.add(help);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem about = new JMenuItem("About");
		file.add(save);
		help.add(about);
		
		
		
		
		//Sets up the JTable
		qTable.setBackground(Color.white);
		qTable.getAutoResizeMode();
		qTable.setFillsViewportHeight(true);

		//Initialize the JPanels
		panelBackLeft = new JPanel();
		panelBackRight = new JPanel();
		panelMidTopLeft = new JPanel();
		panelBackLeftTop = new JPanel();
		panelBackLeftBot = new JPanel();

		//Initialize the JLabels
		searchLabel = new JLabel();

		//Initialize the JTexFields
		txtSearch = new JTextField("search/add User");
		txtDate = new JTextField("search date");
		txtPriority = new JTextField("search prior");
		txtId = new JTextField("Search ID");
		
		//JComboBoxes
		chooseUser.setBounds(290, 200, 160, 25);
		ip.add(chooseUser);
		
		choosePriority.setBounds(290, 240, 160, 25);
		ip.add(choosePriority);
		
		chooseUser2.setBounds(290, 200, 160, 25);
		up.add(chooseUser2);
		
		choosePrio2.setBounds(290, 240, 160, 25);
		up.add(choosePrio2);


		//Sets up the JPanel panelBackLeft
		panelBackLeft.setPreferredSize(new Dimension(200, 300));
		panelBackLeft.setBackground(Color.gray);
		panelBackLeft.setLayout(new BorderLayout());

		//Sets up the JPanel panelBackRight
		panelBackRight.setPreferredSize(new Dimension(200, 50));
		panelBackRight.setBackground(Color.white);

		//sets panelBackLeftTop and bot
		panelBackLeftTop.setBackground(Color.GRAY);
		panelBackLeftBot.setBackground(Color.LIGHT_GRAY);
		panelBackLeftTop.setPreferredSize(new Dimension(100, 525));

		//Sets up the JLabel searchLabel
		searchLabel.setPreferredSize(new Dimension(190, 20));
		searchLabel.setText("Query here");

		//Sets up the JTextfiels
		txtSearch.setPreferredSize(new Dimension(190, 20));
		txtDate.setPreferredSize(new Dimension(190, 20));
		txtPriority.setPreferredSize(new Dimension(190, 20));
		txtId.setPreferredSize(new Dimension(190, 20));


		//Sets up the buttons
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


		//size the buttons
		btnSearch.setSize(new Dimension( 20, 20));
		btnListAllUsers.setSize(new Dimension(20, 20));
		btnAddUser.setSize(new Dimension(20, 20));
		btnListAllIssues.setSize(new Dimension( 20, 20));
		btnSwitchUser.setSize(new Dimension( 20, 20));
		update.setSize(new Dimension( 20, 20));
		btnId.setSize(new Dimension( 20, 20));

		//Sets up the JLabels
		txtInfo = new JTextPane();
		txtInfo.setText("Fill a field and press the correct button to search. Date field -> Date btn etc");
		txtInfo.setPreferredSize(new Dimension(190, 100));
		txtInfo.setBackground(Color.gray);
		txtLoggedIn.setText("Not logged in");
		txtLoggedIn.setBackground(Color.LIGHT_GRAY);
		txtLoggedIn.setEditable(false);
		txtLoggedIn.setPreferredSize(new Dimension(190, 20));

			
		
		//Adds the components to the Panels
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
	 * 
	 * @return boolean if authentication was successful or not
	 * Used to authenicate user logins.
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
	 * This method updates  The JComboButto with new info from the users list.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateChooseUser(){
		chooseUser.setModel(new DefaultComboBoxModel(it.getUsers().toArray()));
		chooseUser2 = chooseUser;
		}
	
	
	/**
	 * @return the panelBackRight
	 */
	public JPanel getPanelBackRight() {
		return panelBackRight;
	}


	/**
	 * @param panelBackRight the panelBackRight to set
	 */
	public void setPanelBackRight(JPanel panelBackRight) {
		this.panelBackRight = panelBackRight;
	}



	/**
	 * @return the panelBackLeft
	 */
	public JPanel getPanelBackLeft() {
		return panelBackLeft;
	}



	/**
	 * @param panelBackLeft the panelBackLeft to set
	 */
	public void setPanelBackLeft(JPanel panelBackLeft) {
		this.panelBackLeft = panelBackLeft;
	}



	/**
	 * @return the txtInfo
	 */
	public JTextPane getTxtInfo() {
		return txtInfo;
	}



	/**
	 * @param txtInfo the txtInfo to set
	 */
	public void setTxtInfo(JTextPane txtInfo) {
		this.txtInfo = txtInfo;
	}




	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @param spine the spine to set
	 */
	public void setSpine(JPanel spine) {
		this.spine = spine;
	}



	/**
	 * @param panelMidTopLeft the panelMidTopLeft to set
	 */
	public void setPanelMidTopLeft(JPanel panelMidTopLeft) {
		this.panelMidTopLeft = panelMidTopLeft;
	}



	/**
	 * @param btnSearch the btnSearch to set
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}



	/**
	 * @param txtSearch the txtSearch to set
	 */
	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}



	/**
	 * @param searchLabel the searchLabel to set
	 */
	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}



	/**
	 * @return the qTable
	 */
	public JTable getqTable() {
		return qTable;
	}



	/**
	 * @param qTable the qTable to set
	 */
	public void setqTable(JTable qTable) {
		this.qTable = qTable;
	}



	/**
	 * @return the it
	 */
	public IssueTable getIt() {
		return it;
	}



	/**
	 * @param it the it to set
	 */
	public void setIt(IssueTable it) {
		this.it = it;
	}



	/**
	 * @return the spine
	 */
	public JPanel getSpine() {
		return spine;
	}



	/**
	 * @return the panelMidTopLeft
	 */
	public JPanel getPanelMidTopLeft() {
		return panelMidTopLeft;
	}



	/**
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}



	/**
	 * @return the txtSearch
	 */
	public JTextField getTxtSearch() {
		return txtSearch;
	}



	/**
	 * @return the searchLabel
	 */
	public JLabel getSearchLabel() {
		return searchLabel;
	}



	/**
	 * @return the btnListAllIssues
	 */
	public JButton getBtnListAllIssues() {
		return btnListAllIssues;
	}

	public JButton getBtnListAllUsers() {
		return btnListAllUsers;
	}



	/**
	 * @param btnListAllIssues the btnListAllIssues to set
	 */
	public void setListAllIssues(JButton btnListAllIssues) {
		this.btnListAllIssues = btnListAllIssues;
	}

	/**
	 * @return the btnAddUser
	 */
	public JButton getBtnAddUser() {
		return btnAddUser;
	}

	/**
	 * @param btnAddUser the btnAddUser to set
	 */
	public void setBtnAddUser(JButton btnAddUser) {
		this.btnAddUser = btnAddUser;
	}

	/**
	 * @param btnListAllIssues the btnListAllIssues to set
	 */
	public void setBtnListAllIssues(JButton btnListAllIssues) {
		this.btnListAllIssues = btnListAllIssues;
	}

	/**
	 * @param btnListAllUsers the btnListAllUsers to set
	 */
	public void setBtnListAllUsers(JButton btnListAllUsers) {
		this.btnListAllUsers = btnListAllUsers;
	}



	/**
	 * @return the layout
	 */
	public CardLayout getLayout() {
		return layout;
	}

	/**
	 * @param layout the layout to set
	 */
	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}


	/**
	 * @return the btnAddIssue
	 */
	public JButton getBtnAddIssue() {
		return btnAddIssue;
	}

	/**
	 * @param btnAddIssue the btnAddIssue to set
	 */
	public void setBtnAddIssue(JButton btnAddIssue) {
		this.btnAddIssue = btnAddIssue;
	}

	/**
	 * @return the panelBackLeftTop
	 */
	public JPanel getPanelBackLeftTop() {
		return panelBackLeftTop;
	}

	/**
	 * @param panelBackLeftTop the panelBackLeftTop to set
	 */
	public void setPanelBackLeftTop(JPanel panelBackLeftTop) {
		this.panelBackLeftTop = panelBackLeftTop;
	}

	/**
	 * @return the panelBackLeftBot
	 */
	public JPanel getPanelBackLeftBot() {
		return panelBackLeftBot;
	}

	/**
	 * @param panelBackLeftBot the panelBackLeftBot to set
	 */
	public void setPanelBackLeftBot(JPanel panelBackLeftBot) {
		this.panelBackLeftBot = panelBackLeftBot;
	}

	/**
	 * @return the btnDate
	 */
	public JButton getBtnDate() {
		return btnDate;
	}

	/**
	 * @param btnDate the btnDate to set
	 */
	public void setBtnDate(JButton btnDate) {
		this.btnDate = btnDate;
	}

	/**
	 * @return the btnPrior
	 */
	public JButton getBtnPrior() {
		return btnPrior;
	}

	/**
	 * @param btnPrior the btnPrior to set
	 */
	public void setBtnPrior(JButton btnPrior) {
		this.btnPrior = btnPrior;
	}


	/**
	 * @return the txtDate
	 */
	public JTextField getTxtDate() {
		return txtDate;
	}

	/**
	 * @param txtDate the txtDate to set
	 */
	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	/**
	 * @return the txtPriority
	 */
	public JTextField getTxtPriority() {
		return txtPriority;
	}

	/**
	 * @param txtPriority the txtPriority to set
	 */
	public void setTxtPriority(JTextField txtPriority) {
		this.txtPriority = txtPriority;
	}


	/**
	 * @return the txtLoggedIn
	 */
	public JTextPane getTxtLoggedIn() {
		return txtLoggedIn;
	}

	/**
	 * @param txtLoggedIn the txtLoggedIn to set
	 */
	public void setTxtLoggedIn(JTextPane txtLoggedIn) {
		this.txtLoggedIn = txtLoggedIn;
	}


	/**
	 * @return the lp
	 */
	public LoginPanel getLp() {
		return lp;
	}

	/**
	 * @param lp the lp to set
	 */
	public void setLp(LoginPanel lp) {
		this.lp = lp;
	}

	/**
	 * @return the chooseUser
	 */
	public JComboBox<?> getChooseUser() {
		return chooseUser;
	}

	/**
	 * @param chooseUser the chooseUser to set
	 */
	public void setChooseUser(JComboBox<?> chooseUser) {
		this.chooseUser = chooseUser;
	}

	/**
	 * @return the choosePriority
	 */
	public JComboBox<?> getChoosePriority() {
		return choosePriority;
	}

	/**
	 * @return the ip
	 */
	public IssuePanel getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(IssuePanel ip) {
		this.ip = ip;
	}

	/**
	 * @return the btnSwitchUser
	 */
	public JButton getBtnSwitchUser() {
		return btnSwitchUser;
	}

	/**
	 * @param btnSwitchUser the btnSwitchUser to set
	 */
	public void setBtnSwitchUser(JButton btnSwitchUser) {
		this.btnSwitchUser = btnSwitchUser;
	}

	/**
	 * @param choosePriority the choosePriority to set
	 */
	@SuppressWarnings("rawtypes")
	public void setChoosePriority(JComboBox choosePriority) {
		this.choosePriority = choosePriority;
	}

	/**
	 * @return the up
	 */
	public UpdatePanel getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(UpdatePanel up) {
		this.up = up;
	}

	/**
	 * @return the update
	 */
	public JButton getUpdate() {
		return update;
	}

	/**
	 * @param update the update to set
	 */
	public void setUpdate(JButton update) {
		this.update = update;
	}

	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * @return the file
	 */
	public JMenu getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(JMenu file) {
		this.file = file;
	}

	/**
	 * @return the help
	 */
	public JMenu getHelp() {
		return help;
	}

	/**
	 * @param help the help to set
	 */
	public void setHelp(JMenu help) {
		this.help = help;
	}

	/**
	 * @return the chooseUser2
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getChooseUser2() {
		return chooseUser2;
	}

	/**
	 * @param chooseUser2 the chooseUser2 to set
	 */
	@SuppressWarnings("rawtypes")
	public void setChooseUser2(JComboBox chooseUser2) {
		this.chooseUser2 = chooseUser2;
	}

	/**
	 * @return the choosePrio2
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getChoosePrio2() {
		return choosePrio2;
	}

	/**
	 * @param choosePrio2 the choosePrio2 to set
	 */
	@SuppressWarnings("rawtypes")
	public void setChoosePrio2(JComboBox choosePrio2) {
		this.choosePrio2 = choosePrio2;
	}

	/**
	 * @return the save
	 */
	public JMenuItem getSave() {
		return save;
	}

	/**
	 * @param save the save to set
	 */
	public void setSave(JMenuItem save) {
		this.save = save;
	}

	/**
	 * @return the about
	 */
	public JMenuItem getAbout() {
		return about;
	}

	/**
	 * @param about the about to set
	 */
	public void setAbout(JMenuItem about) {
		this.about = about;
	}

	/**
	 * @return the btnId
	 */
	public JButton getBtnId() {
		return btnId;
	}

	/**
	 * @param btnId the btnId to set
	 */
	public void setBtnId(JButton btnId) {
		this.btnId = btnId;
	}

	/**
	 * @return the txtId
	 */
	public JTextField getTxtId() {
		return txtId;
	}

	/**
	 * @param txtId the txtId to set
	 */
	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}


}