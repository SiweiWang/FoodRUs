/**
 * 
 */
package model;

/**
 * @author 
 *
 */
public class ItemBean {

	
	private String itemNumber;
	private String itemName;
	private double price;
	//Category ID;
	private int catID;
	private int qty;
	private int onOrder;
	private int reOrder;
	private double cost;
	private int supID;
		
	/**
	 * @param itemNumber
	 * @param itemName
	 * @param price
	 * @param catID
	 */
	public ItemBean(String itemNumber, String itemName, double price, int catID) 
	{
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.price = price;
		this.catID = catID;
	}

	/**
	 * @return the itemNumber
	 */
	public String getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the onOrder
	 */
	public int getOnOrder() {
		return onOrder;
	}

	/**
	 * @param onOrder the onOrder to set
	 */
	public void setOnOrder(int onOrder) {
		this.onOrder = onOrder;
	}

	/**
	 * @return the reOrder
	 */
	public int getReOrder() {
		return reOrder;
	}

	/**
	 * @param reOrder the reOrder to set
	 */
	public void setReOrder(int reOrder) {
		this.reOrder = reOrder;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the supID
	 */
	public int getSupID() {
		return supID;
	}

	/**
	 * @param supID the supID to set
	 */
	public void setSupID(int supID) {
		this.supID = supID;
	}
	
	

}
