package dbt.online.rental;

import java.util.HashSet;
import java.util.Set;

public class Collection extends DBCommunication<Collection>{

	private int COLLECTION_ID = 0;
	private float price;
	private String name;
	private Set<Item> items = new HashSet<Item>();
		
	public Collection(float gprice, String gname) {
		super();
		this.price=gprice;
		this.name=gname;
		this.execute(this, METHOD.CREATE);
	}
	
	public void addItem(Item ing){
		items.add(ing);
		this.price = this.price + ing.getPrice();
		this.execute(this, METHOD.UPDATE);
	}
	
	public void removeItem(Item item){
		items.remove(item);
		this.price = this.price - item.getPrice();
		this.execute(this, METHOD.DELETE);
	}

	public int getCOLLECTION_ID() {
		return COLLECTION_ID;
	}

	public void setCOLLECTION_ID(int collection_ID) {
		COLLECTION_ID = collection_ID;
	}

	public Set<Item> getItem() {
		return items;
	}

	public void setItem(Set<Item> item) {
		this.items = item;
	}
	
	/**
	 * @return the price
	 */
	public float getPrice() {		
		return this.price;
	}


	/**
	 * @param price setter
	 */
	public void setPrice(float price) {
		this.price = price;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name setter
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		String returnString = "\t\tCollection-" + this.COLLECTION_ID + "->" + this.name + "[\n" ;
		for(Item ing : items){
			returnString += ing.toString();
		}
		return returnString + "\t\t]\n";
	}
}
