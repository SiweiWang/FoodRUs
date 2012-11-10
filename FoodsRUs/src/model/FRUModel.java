package model;

import java.util.List;

/**
 * 
 * @author derek
 *	FoodsRUs model class, use this class to coordinate operations between DAO, BEAN, and Controller.
 */

public class FRUModel {

	//the FoodRUDAO Database access object to be instantiated. 
	private FoodRUDAO dao;
	
	public FRUModel() throws Exception
	{
		
		this.dao = new FoodRUDAO();
	}
	
	/**
	 * 
	 * @return the List of existing categories in the database.
	 * @throws Exception
	 */
	public List<CategoryBean> retrieveCategory() throws Exception 
	{
		return this.dao.retrieveCategory();
	}
	
	/**
	 * 
	 * @param catID
	 * @return The list of items that belong to this category
	 * @throws Exception
	 */
	public List<ItemBean> retrieveItems(int catID) throws Exception 
	{
		return this.dao.retrieveItems(catID);
	}
	
	/**
	 * The method return a single item, can be used for express order by item number.
	 * @param itemNumber
	 * @return
	 * @throws Exception
	 */
	public ItemBean retrieveItem(String itemNumber) throws Exception 
	{
		return this.dao.retrieveItem(itemNumber);
	}

}
