package model;

public class Cart {
	private String user;
	private int idProduct;
	private int count;
	
	public Cart(String user, int idProduct, int count) {
		super();
		this.user = user;
		this.idProduct = idProduct;
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public String getUser() {
		return user;
	}
	
}	
