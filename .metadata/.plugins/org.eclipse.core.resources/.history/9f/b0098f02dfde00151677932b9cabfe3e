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

	/**
	 * //These are the fields for the Issues class
	 */
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the assigned
	 */
	public String getAssigned() {
		return assigned;
	}



	/**
	 * @param assigned the assigned to set
	 */
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}



	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}



	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}



	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}



	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}



	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}



	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}



	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
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
