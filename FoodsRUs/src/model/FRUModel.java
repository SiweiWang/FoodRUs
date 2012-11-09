package model;

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
	
	

}
