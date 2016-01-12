package dbt.online.rental;

import java.util.HashSet;
import java.util.Set;

public class Customer extends DBCommunication<Customer>{

	private int CUSTOMER_ID = 0;
	private String name;
	private String address;
	private String email;
	private Set<Order> Orders = new HashSet<Order>();
	
	public Customer(String name, String address, String email) {
		super();
		this.name=name;
		this.address=address;
		this.email=email;
		this.execute(this, METHOD.CREATE);
	}

	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}


	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}



	public Set<Order> getOrders() {
		return Orders;
	}



	public void setOrders(Set<Order> myOrders) {
		this.Orders = myOrders;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){		
		return "Customer-" + this.CUSTOMER_ID+ "[" + this.name  + "]";
	}
}
