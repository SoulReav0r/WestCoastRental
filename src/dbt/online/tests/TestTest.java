/**
 * 
 */
package dbt.online.tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.*;
import org.junit.Test;
import dbt.online.rental.*;

/**
 * @author Raziel
 * 
 *
 */

public class TestTest {
	
	Item i1 = null;	
	Item i2 = null;	
	Item i3 = null;	
	
	Collection family = new Collection(27, "Family Package");
	Collection testCollection = null;
	
	Customer customer1 = null;
	Offer familySpecial = null;
	Order order1 = null;
	Order order2 = null;
	
	@Before
	public void runBeforeEveryTest() {
		i1 = new Item(10, "bicycle man XL");
		Item i1 = new Item(10, "bicycle man XL");
		Item i2 = new Item(12, "bicycle woman S");
		Item i3 = new Item(5, "bicycle child XS");
		family.addItem(i1);
		family.addItem(i2);
		family.addItem(i3);

		customer1 = new Customer("Chuck Norris", "Texas", "roundhouse@kick.punch");
		
		familySpecial = new Offer("family", 0);
		familySpecial.addCollection(family);
		
		order1 = new Order(customer1);
		order1.addOffer(familySpecial);
	}
	
	@Test
	public void testAvailable() {
		i1.setAvailable(false);
		assertEquals("",false, i1.isAvailable());
	}
	
	@Test
	public void testDiscount() {
		familySpecial.setDiscount(20);
		assertEquals("",20, familySpecial.getDiscount());
	}
	
	@Test
	public void testRentOffer() {
		order2 = new Order(customer1);
		assertEquals("",customer1, order2.getCustomer());
	}

	@Test
	public void testUpdateCustomData() {
		customer1.setAddress("Elmstreet");
		customer1.setEmail("kontakt@schinken.de");
		assertEquals("","Elmstreet", customer1.getAddress());
		assertEquals("","kontakt@schinken.de", customer1.getEmail());
	}	
	@Test
		public void testUpdateCollection() {
			testCollection = new Collection(27, "Test"); 
			assertEquals("","Test", testCollection.getName());
	}
	
	@Test
	public void testOfferAvailability() {
		boolean result = true;
		for (Collection c : familySpecial.getCollections()) {
			for (Item i : c.getItem()) {
				if (!i.isAvailable()){
					result = false;
				}
			}   
		}
		assertTrue(result);
}
	
	@Test
	public void testShapeSingleItem() {
		i1.setShape("Schrott");
		assertEquals("","Schrott", i1.getShape());
	}
}
