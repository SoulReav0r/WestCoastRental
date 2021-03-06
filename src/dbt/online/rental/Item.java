package dbt.online.rental;

public class Item extends DBCommunication<Item>{

	private int ITEM_ID = 0;
	private float price;
	private String name;
	private String shape;
	private boolean available;

	public Item(float price, String name) {
		super();
		this.price = price;
		this.name = name;
		this.shape = "mint";
		this.setAvailable(true); 
		this.execute(this, METHOD.CREATE);
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}

	public void setITEM_ID(int item_ID) {
		ITEM_ID = item_ID;
	}

	public String toString(){		
		return "\t\t\tItem-" + this.ITEM_ID + "[" + name  + "] condition: " + shape + "\n";
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String condition) {
		this.shape = condition;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
