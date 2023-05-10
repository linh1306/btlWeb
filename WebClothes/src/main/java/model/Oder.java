package model;

public class Oder {
	private String idSeller;
	private String user;
	private int idProduct;
	private int count;
	
	
	public Oder(String idSeller, String user, int idProduct, int count) {
		super();
		this.idSeller = idSeller;
		this.user = user;
		this.idProduct = idProduct;
		this.count = count;
	}

	public int getIdProduct() {
		return idProduct;
	}
	public String getIdSeller() {
		return idSeller;
	}
	public String getUser() {
		return user;
	}
	
	public int getCount() {
		return count;
	}
	
}
