package model;

public class User {
	private String email;
	private String user;
	private String password;
	private String name;
	private String address;
	private String phone;
	
	
	public User(String email, String user2, String password, String name, String address, String phone) {
		super();
		this.email = email;
		this.user = user2;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
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

	@Override
	public String toString() {
		return this.user;
	}

}
