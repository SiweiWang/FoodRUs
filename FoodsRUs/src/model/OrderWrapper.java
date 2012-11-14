package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OrderWrapper {

	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private Date submitted;
	
	@XmlElement
	private ClientBean customer;
	
	@XmlElement(name="items")
	private ShoppingCartBean shoppingCart;
	
	@XmlElement
	private double total;
	
	@XmlElement
	private double shipping;
	
	@XmlElement
	private double HST;
	
	@XmlElement
	private double grandTotal;
	
	
	public OrderWrapper() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id
	 * @param submitted
	 * @param customer
	 * @param shoppingCart
	 */
	public OrderWrapper(int id, Date submitted, ClientBean customer,
			ShoppingCartBean shoppingCart) {
		this.id = id;
		this.submitted = submitted;
		this.customer = customer;
		this.shoppingCart = shoppingCart;
		this.total = this.shoppingCart.getTotal();
		this.shipping = this.shoppingCart.getShipping();
		this.HST = this.shoppingCart.getHST();
		this.grandTotal = this.shoppingCart.getGrandTotal();
	}
	
	

}
