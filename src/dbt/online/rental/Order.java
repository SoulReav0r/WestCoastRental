package dbt.online.rental;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class Order extends DBCommunication<Order>{

	private int MYORDER_ID=0;
	private String rentDate; // Datentyp Date Rückgabe Datum
	private String returnDate;
	private float totalPrice;
	private Customer customer;
	private Set<Offer> offer = new HashSet<Offer>();
	
	public Order(Customer customer) {
		super();
		rentDate = (new Timestamp(System.currentTimeMillis())).toString();
		this.customer = customer;
		this.execute(this, METHOD.CREATE);
	}
	
	public void addOffer(Offer offers){
		offer.add(offers);
		this.totalPrice = this.totalPrice + offers.getPrice();
		this.execute(this, METHOD.UPDATE);
	}
	
	public void removeOffer(Offer offers){
		offer.remove(offers);
		this.totalPrice = this.totalPrice - offers.getPrice();
		this.execute(this, METHOD.DELETE);
	}
	
	public int getMYORDER_ID() {
		return MYORDER_ID;
	}
	public void setMYORDER_ID(int oRDER_ID) {
		MYORDER_ID = oRDER_ID;
	}
	public String getOrderDate() {
		return rentDate;
	}
	public void setOrderDate(String date) {
		this.rentDate = date;
	}
	
	private float getOffersPrice(){
		float offerPrice = 0;
		if (!this.offer.isEmpty()){
			for (Offer offer : this.offer){
				offerPrice = offerPrice + offer.getPrice();
			}
		}
		return offerPrice;
	}
	
	public float getTotalPrice() {	
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = getOffersPrice();
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Offer> getOffers() {
		return offer;
	}
	public void setOffers(Set<Offer> offers) {
		this.offer = offers;
	}

	public String toString(){
		String returnString = "Order-" + this.MYORDER_ID + "->" + this.customer.toString() + "->Date:" + this.rentDate.toString()+ "->Price:" + this.totalPrice + "[\n" ;
		for(Offer offer : offer){
			returnString += offer.toString();
		}
		return returnString + "]\n";
	}	
}
