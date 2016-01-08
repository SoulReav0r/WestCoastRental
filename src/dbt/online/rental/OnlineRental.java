package dbt.online.rental;

public class OnlineRental {

	public OnlineRental() {
		firstTest();
	}

	public static void main(String[] args) {
		new OnlineRental();
	}
	
	@SuppressWarnings("unused")
	public void firstTest(){
		
		Customer customer1 = new Customer("Chuck Norris", "Texas", "roundhouse@kick.punch");
		Customer customer2 = new Customer("Deine Mutter", "Keller", "mother@mydirtyhobby.com");
		Customer customer5 = new Customer("Bernd Stromberg", "Hameln", "kontakt@kapitol.de");
		
		//add items (price per day, name)
		Item i1 = new Item(10, "bicycle man");
		Item i2 = new Item(12, "bicycle woman");
		Item i3 = new Item(5, "bicycle child");
		Item i4 = new Item(20, "Tandem");
		Item i5 = new Item(100, "E-Bike 500PS");
		Item i6 = new Item(3, "Trike");
		Item i7 = new Item(42, "trailer");
		Item i8 = new Item(42, "Sunglasses");
		Item i9 = new Item(42, "leather jacket");
		Item i10 = new Item(10, "glitter");
		Item i11 = new Item(5000, "5000W Basemachine");
		
		//change condition
		i10.setShape("low shiny");
		i9.setShape("used");
		
		//add Products
		Collection family = new Collection(27, "Family Package");
		family.addItem(i1);
		family.addItem(i2);
		family.addItem(i3);
		family.addItem(i7);
		
		Collection theMAN = new Collection(300, "The MAN");
		theMAN.addItem(i5);
		theMAN.addItem(i8);
		theMAN.addItem(i9);
		theMAN.addItem(i11);
		
		
		Collection theWoman = new Collection(400, "The Woman");
		theWoman.addItem(i2);
		theWoman.addItem(i10);
		
		
		//add Offers (name, discount)
		Offer gentleman = new Offer("Gentleman", 0);
		gentleman.addCollection(theMAN);
		Offer ladiesonly = new Offer("Ladies Only", 0);
		ladiesonly.addCollection(theWoman);
		
				
		//add order
		Order Order1 = new Order(customer1);
		Order1.addOffer(gentleman);
		Order Order2 = new Order(customer2);
		Order2.addOffer(ladiesonly);
				
		System.out.print(Order1.toString());
		System.out.print(Order2.toString());
	}
		
}
