package ie.gmit.sw;

import org.junit.*;
import static org.junit.Assert.*;

public class TestOrder {
	private Order order = null;
	
	@Before
	public void setup(){	// set up the test fixture
		order = new Order();
	}
	
	@After
	public void tearDown(){	// tear down the test fixture
		order = null;
	}
	
	@Test
	public void validOrderNumber() throws Exception{
		order.setOrderNumber("AA-123-B9");
		// this test should tell the developer to test that order number
		// i.e. test driven development
		assertNotNull(order.getOrderNumber());
	}

	@Test(expected=Exception.class)
	public void nullOrderNumber() throws Exception{
		order.setOrderNumber(null);
	}
	
	@Test
	public void addValidLineItem(){
		int count = order.itemCount();
		order.addItem("AA-123-B9", "Daiwa Moochine Reel", 26, 12.99f);
		assertTrue(order.itemCount() == count+1);
	}
	
	// catch a null item
	@Test(expected=Exception.class)
	public void addNullLineItem(){
		int count = order.itemCount();
		order.addItem("AA-123-B9", "Daiwa Moochine Reel", 26, 12.99f);
		assertTrue(order.itemCount() == count+1);
	}
}
