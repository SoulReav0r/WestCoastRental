package dbt.online.rental;

import java.util.HashSet;
import java.util.Set;

public class Offer extends DBCommunication<Offer>{

	private int OFFER_ID = 0;
	private String name;
	private float price;
	private int discount;
	private Set<Collection> collections = new HashSet<Collection>();

	public Offer(String name, int discount) {
		super();
		this.name = name;		
		this.discount = discount;
		this.execute(this, METHOD.CREATE);
	}
	
	public void addCollection(Collection prod){
		collections.add(prod);
		this.price = this.price + prod.getPrice() * (100-discount)/100;
		this.execute(this, METHOD.UPDATE);
	}
	
	public void removeCollection(Collection prod){
		collections.remove(prod);
		this.price = this.price - prod.getPrice();
		this.execute(this, METHOD.DELETE);
	}

	
	public int getOFFER_ID() {
		return OFFER_ID;
	}


	public void setOFFER_ID(int mENU_ID) {
		OFFER_ID = mENU_ID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

		
	
	public float getPrice() {		
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	/**
	 * @return the Products
	 */
	public Set<Collection> getCollections() {
		return collections;
	}

	/**
	 * @param Products the Products to set
	 */
	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}
	
	public String toString(){
		String returnString = "\tOffer-" + this.OFFER_ID + "->Name:" + this.name + "->Discount:" + this.discount + "[\n" ;
		for(Collection prod : collections){
			returnString += prod.toString();
		}
		return returnString + "\t]\n";
	}
}
