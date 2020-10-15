package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import vendormachine.users.util.Wallet;

public class WalletTEST {
	
	private String brand = "test";
	private float storedCredit = 0.5f;
	
	private static int activeTest = 1;
	private static StringBuilder sBuilder = new StringBuilder();
	private static String div = "-----";
	
	private static ExtentReports report;
	private ExtentTest test;

	@BeforeClass
	public static void beforeTestSuite() {
		System.out.println("BeforeClass: Start of TestSuite\n");
		
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "\\target\\reports\\WalletReport.html");
		
		System.out.println(filePath.toString());
		
		report = new ExtentReports(filePath.toString(), true);
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before");
	}
	
	@Test
	public void testWalletConstructor() {
		test = report.startTest("testWalletConstructor");
		Wallet wallet = new Wallet();
		testReport.assertReport(test, true, wallet instanceof Wallet);
		assertTrue (wallet instanceof Wallet);
		
		wallet = new Wallet(storedCredit);
		testReport.assertReport(test, true, wallet instanceof Wallet);
		assertTrue (wallet instanceof Wallet);
		
		wallet = new Wallet (brand, storedCredit);
		testReport.assertReport(test, true, wallet instanceof Wallet);
		assertTrue (wallet instanceof Wallet);
	}
	
	@Test
	public void testCredit() {
		test = report.startTest("testCredit");
		Wallet wallet = new Wallet(storedCredit);
		wallet.addCredit(storedCredit);
		testReport.assertReport(test, true, 1.0 == wallet.getAllCredit());
		assertEquals(1.0, wallet.getAllCredit(),0);
	}
	
	@Test
	public void testGetBrand() {
		test = report.startTest("testGetBrand");
		Wallet wallet = new Wallet(brand, storedCredit);
		testReport.assertReport(test, true, brand == wallet.getBrand());
		assertEquals(brand, wallet.getBrand());
	}
	
	@Test
	public void testGetCredit() {
		test = report.startTest("testGetCredit");
		Wallet wallet = new Wallet();
		testReport.assertReport(test, true, 0 == wallet.getCredit(0));
		assertEquals(0, wallet.getCredit(0), 0);
	}
	
	@Test
	public void testSetBrand() {
		test = report.startTest("testSetBrand");
		Wallet wallet = new Wallet();
		wallet.setBrand(brand);
		testReport.assertReport(test, true, brand == wallet.getBrand());
		assertEquals(brand, wallet.getBrand());
	}

	@Test
	public void testSetCredit() {
		test = report.startTest("testSetCredit");
		Wallet wallet = new Wallet();
		wallet.setCredit(storedCredit);
		testReport.assertReport(test, true, storedCredit == wallet.getAllCredit());
		assertEquals(storedCredit, wallet.getAllCredit(), 0);
	}
	
	@Test 
	public void testInsufficientFunds() {
		test = report.startTest("testInsufficientFunds");
		Wallet wallet = new Wallet(brand, storedCredit);
		testReport.assertReport(test, true, 0f == wallet.getCredit(20.0f));
		assertEquals(0f, wallet.getCredit(20.0f), 0.1f);
	}
	
	@After
	public void afterTest() {
		System.out.println(div);
		report.endTest(test);
	}
	
	@AfterClass
	public static void afterTestSuite() {
		System.out.println("AfterClass: End of TestSuite");
		report.flush();
		report.close();
	}
}

