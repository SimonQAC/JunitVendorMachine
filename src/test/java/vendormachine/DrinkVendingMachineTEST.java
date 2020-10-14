package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTEST {
	

	private BRANDS brandName = null;
	private float availebleCredit = 0;
	private ArrayList<Snack> drinkList = new ArrayList<Snack>();
	private String div = "-----";
	

	@BeforeClass
	public static void beforeTestSuite() {
		System.out.println("BeforeClass: Start of TestSuite\n");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before");
	}
	
	@Test
	public void testDrinkVendingMachine() {
		DrinkVendingMachine dvm = new DrinkVendingMachine();
		assertTrue ()
		
	}
	
	
	@After
	public void afterTest() {
		System.out.println(div);
	}
	
	@AfterClass
	public static void afterTestSuite() {
		System.out.println("AfterClass: End of TestSuite");
	}
}
