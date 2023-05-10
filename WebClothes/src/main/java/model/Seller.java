package model;

public class Seller {
	private String user;
	private String idSeller;
	private String name;
	private String address;
	private String phone;
	

	
	public Seller(String user, String idSeller, String name, String address, String phone) {
		super();
		this.user = user;
		this.idSeller = idSeller;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	public String getIdSeller() {
		return idSeller;
	}
	public String getUser() {
		return user;
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	
}
