/**
 * 
 */
package dbt.online.tests;

import static org.junit.Assert.*;
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
	@Before
	public void runBeforeEveryTest() {
		i1 = new Item(10, "bicycle man XL");	
	}
	
	@Test
	public void testAvailable() {
		i1.setAvailable(false);
		assertEquals("Not yet implemented",false, i1.isAvailable());
	}
}
