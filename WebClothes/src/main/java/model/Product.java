package model;


public class Product {
	private int idProduct;
	private String idSeller;
	private String img;
	private String name;
	private String company;
	private String description;
	private String detail;
	private int price;
	
	
	public Product(int idProduct, String idSeller, String img, String name, String company, String description,
			String detail, int price) {
		super();
		this.idProduct = idProduct;
		this.idSeller = idSeller;
		this.img = img;
		this.name = name;
		this.company = company;
		this.description = description;
		this.detail = detail;
		this.price = price;
	}

	public Product(String idSeller, String img, String name, String company, String description,
	String detail, int price) {
		super();
		this.idSeller = idSeller;
		this.img = img;
		this.name = name;
		this.company = company;
		this.description = description;
		this.detail = detail;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getCompany() {
		return company;
	}
	public String getDescription() {
		return description;
	}
	public String getDetail() {
		return detail;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public String getIdSeller() {
		return idSeller;
	}
	public String getImg() {
		return img;
	}
}