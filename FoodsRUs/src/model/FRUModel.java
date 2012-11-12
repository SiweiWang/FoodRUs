package model;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author
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
	
	/**
	 * The method return a single item, can be used for express order by item number.
	 * @param itemNumber
	 * @return
	 * @throws Exception
	 */
	public String validatePassword(String ClientID, String password) throws Exception 
	{
		return this.dao.validatePassword(ClientID, password);
	}
	
	/**
	 * The method add the item specified by itemNumber to the shoppingCart hashmap 
	 * @param itmeNumber - the number (id) of the item
	 * @throws Exception 
	 */
	public void addToCart(HashMap<String,ItemBean> shoppingCart, String itemNumber, int qty) throws Exception
	{
		if (shoppingCart.containsKey(itemNumber))
		{
			ItemBean item = shoppingCart.get(itemNumber);
			item.setQty(item.getQty() + 1);
		}else{
			ItemBean item = this.retrieveItem(itemNumber);
			item.setQty(qty);
			shoppingCart.put(itemNumber, item);
		}
	}
	
	/**
	 * Calculate total price of items in shopping cart
	 * @param shoppingCart
	 * @return - a double value of total price in shopping cart
	 */
	public double totalPrice(HashMap<String,ItemBean> shoppingCart)
	{
		
		double totalPrice = 0;
		for(ItemBean item: shoppingCart.values())
		{
			totalPrice += (item.getPrice() * item.getQty());
		}
		return totalPrice;
	}
	
	/**
	 * Update quantity of item in shoppingCart
	 * @param shoppingCart
	 * @param itemNumber
	 * @param qty
	 */
	public void updateCart(HashMap<String,ItemBean> shoppingCart, String itemNumber, int qty)
	{
		if (qty == 0)//remove the item from shoppingCart
		{
			shoppingCart.remove(itemNumber);
		}else //update qty
		{
			shoppingCart.get(itemNumber).setQty(qty);
		}
	}
	
	

}
