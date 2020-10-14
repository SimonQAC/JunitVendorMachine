package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vendormachine.users.util.Wallet;

public class WalletTEST {
	
	private String brand = "test";
	private float storedCredit = 0.5f;
	
	private static int activeTest = 1;
	private static StringBuilder sBuilder = new StringBuilder();
	private static String div = "-----";

	@BeforeClass
	public static void beforeTestSuite() {
		System.out.println("BeforeClass: Start of TestSuite\n");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before");
	}
	
	@Test
	public void testWalletConstructor() {
		Wallet wallet = new Wallet();
		assertTrue (wallet instanceof Wallet);
		
		wallet = new Wallet(storedCredit);
		assertTrue (wallet instanceof Wallet);
		
		wallet = new Wallet (brand, storedCredit);
		assertTrue (wallet instanceof Wallet);
	}
	
	@Test
	public void testCredit() {
		Wallet wallet = new Wallet(storedCredit);
		wallet.addCredit(storedCredit);
		assertEquals(1.0, wallet.getAllCredit(),0);
	}
	
	@Test
	public void testGetBrand() {
		Wallet wallet = new Wallet(brand, storedCredit);
		assertEquals(brand, wallet.getBrand());
	}
	
	@Test
	public void testGetCredit() {
		Wallet wallet = new Wallet(storedCredit);
		wallet.getCredit((float) 0.1);
	}
	
	@Test
	public void testSetBrand() {
		Wallet wallet = new Wallet();
		wallet.setBrand(brand);
		assertEquals(brand, wallet.getBrand());
	}

	@Test
	public void testSetCredit() {
		Wallet wallet = new Wallet();
		wallet.setCredit(storedCredit);
		assertEquals(storedCredit, wallet.getAllCredit(), 0);
	}
	
	@Test 
	public void testInsufficientFunds() {
		Wallet wallet = new Wallet(brand, storedCredit);
		assertEquals(0f, wallet.getCredit(20.0f), 0.1f);
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

