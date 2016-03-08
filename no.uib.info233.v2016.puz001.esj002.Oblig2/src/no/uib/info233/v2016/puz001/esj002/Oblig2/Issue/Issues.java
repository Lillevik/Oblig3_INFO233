/**
 * 
 */
package no.uib.info233.v2016.puz001.esj002.Oblig2.Issue;

import java.io.Serializable;

/**
 * @author mariuslillevik
 *This class is made to create objects containing the
 *values from the ISSUES elements in the old_issues.xml file.
 */
public class Issues implements Serializable{

	
	//These are the fields for the Issues class.
	private static final long serialVersionUID = -2428158722130066013L;
	private String id;
	private String assigned;
	private String created;
	private String issue;
	private String priority;
	private String location;
	
	
	/**
	 * This is the constructor for the Issues class.
	 * @param id
	 * @param assigned
	 * @param created
	 * @param issue
	 * @param priority
	 * @param location
	 */
	public Issues(String id, String assigned, String created, String issue, String priority, String location){
		this.id = id;
		this.assigned = assigned;
		this.created = created;
		this.issue = issue;
		this.priority = priority;
		this.location = location;
	}



	/**
	 * This is a getter for the field id which
	 * returns the current id value as a string.
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * This is a setter for the field id which
	 * sets the value of the field to a different value.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * This is a getter for the field id which
	 * returns the assigned name value as a string.
	 * @return the assigned
	 */
	public String getAssigned() {
		return assigned;
	}



	/**
	 * This is a setter for the field assigned which
	 * sets the value of the field to a new value.
	 * @param assigned the assigned to set
	 */
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}



	/**
	 * This is a getter for the field created which
	 * returns the current created date value as a string.
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}



	/**
	 * This is a setter for the field created which
	 * sets the value of the field to a different value.
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}



	/**
	 * This is a getter for the field issue which
	 * returns the current issue value as a string.
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}



	/**
	 * This is a setter for the field issue which
	 * sets the value of the field to a different value.
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}



	/**
	 * This is a getter for the field priority which
	 * returns the current priority value as a string.
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}



	/**
	 * This is a setter for the field priority which
	 * sets the value of the field to a different value.
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}



	/**
	 * This is a getter for the field location which
	 * returns the current location value as a string.
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
	 * This is a setter for the field location which
	 * sets the value of the field to a different value.
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * This method returns the id field as an Integer instead of string
	 * and uses this to calculate the highest current id in getMaxId().
	 * @return
	 */
	public int idInt(){
		int i = Integer.parseInt(this.id);
		return i;
	}
}
