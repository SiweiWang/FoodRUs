/**
 * 
 */
package model;

/**
 * @author
 *
 */
public class CategoryBean {
	
	private int catID;
	private String name;
	private String description;
		
	
	/**
	 * The constructor for Category Bean
	 * @param catID
	 * @param name
	 * @param description
	 */
	public CategoryBean(int catID, String name, String description) {
		super();
		this.catID = catID;
		this.name = name;
		this.description = description;
	}


	/**
	 * @return the catID
	 */
	public int getCatID() {
		return catID;
	}


	/**
	 * @param catID the catID to set
	 */
	public void setCatID(int catID) {
		this.catID = catID;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
