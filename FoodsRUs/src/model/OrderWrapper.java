package model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="order")
public class OrderWrapper {

	private int id;
	
	private String submitted;
	
	private ClientBean customer;
	
	private ShoppingCartHelper shoppingCart;
	
	private double total;
	
	private double shipping;
	
	private double HST;
	
	private double grandTotal;
	
	
	public OrderWrapper() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@XmlAttribute
	public String getSubmitted() {
		return submitted;
	}


	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	@XmlElement
	public ClientBean getCustomer() {
		return customer;
	}


	public void setCustomer(ClientBean customer) {
		this.customer = customer;
	}

	@XmlElement(name="items")
	public ShoppingCartHelper getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCartHelper shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@XmlElement
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}

	@XmlElement
	public double getShipping() {
		return shipping;
	}


	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	@XmlElement
	public double getHST() {
		return HST;
	}


	public void setHST(double hST) {
		HST = hST;
	}

	@XmlElement
	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	/**
	 * @param id
	 * @param submitted
	 * @param customer
	 * @param shoppingCart
	 */
	public OrderWrapper(int id, String submitted, ClientBean customer,
			ShoppingCartHelper shoppingCart) {
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
