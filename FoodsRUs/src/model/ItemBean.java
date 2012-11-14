/**
 * 
 */
package model;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author 
 *
 */
public class ItemBean {

	DecimalFormat twoDForm = new DecimalFormat("#.##");
	
	@XmlAttribute(name="number")
	private String itemNumber;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private double price;
	
	@XmlElement
	private int quantity;
	
	@XmlElement
	private double extended;
	
	//Category ID;
	private int catID;
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
		this.name = itemName;
		this.price = Double.valueOf(twoDForm.format(price));;
		this.catID = catID;
	}

	/**
	 * @return the itemNumber
	 */
	public String getItemNumber()
	{
		return itemNumber;
	}

	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(String itemNumber)
	{
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @return the extended
	 */
	public double getExtended()
	{
		return extended;
	}

	/**
	 * @param extended the extended to set
	 */
	public void setExtended(double extended)
	{
		this.extended = extended;
	}

	/**
	 * @return the catID
	 */
	public int getCatID()
	{
		return catID;
	}

	/**
	 * @param catID the catID to set
	 */
	public void setCatID(int catID)
	{
		this.catID = catID;
	}

	/**
	 * @return the onOrder
	 */
	public int getOnOrder()
	{
		return onOrder;
	}

	/**
	 * @param onOrder the onOrder to set
	 */
	public void setOnOrder(int onOrder)
	{
		this.onOrder = onOrder;
	}

	/**
	 * @return the reOrder
	 */
	public int getReOrder()
	{
		return reOrder;
	}

	/**
	 * @param reOrder the reOrder to set
	 */
	public void setReOrder(int reOrder)
	{
		this.reOrder = reOrder;
	}

	/**
	 * @return the cost
	 */
	public double getCost()
	{
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	/**
	 * @return the supID
	 */
	public int getSupID()
	{
		return supID;
	}

	/**
	 * @param supID the supID to set
	 */
	public void setSupID(int supID)
	{
		this.supID = supID;
	}

	

}
