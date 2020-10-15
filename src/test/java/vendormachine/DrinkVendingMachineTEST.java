package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTEST {
	

	private BRANDS brandName = null;
	private DefaultSnacks snackList;
	private Wallet wallet;
	private Person user;
	private DrinkVendingMachine dvm;
	private float availableCredit = 0;
	private ArrayList<Snack> drinkList = new ArrayList<Snack>();
	private String div = "-----";
	private String name = "test";
	
	private static ExtentReports report;
	private ExtentTest test;
	

	@BeforeClass
	public static void beforeTestSuite() {
		System.out.println("BeforeClass: Start of TestSuite\n");
		
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "\\target\\reports\\DVMReport.html");
		
		System.out.println(filePath.toString());
		
		report = new ExtentReports(filePath.toString(), true);
	}
	
	@Before
	public void beforeTest() {
		this.dvm = new DrinkVendingMachine();
		this.wallet = new Wallet();
		this.wallet.setCredit(availableCredit);
		this.user = new Person(this.name, this.wallet);
	}
	
	@Test
	public void testDrinkVendingMachine() {
		test = report.startTest("testDrinkVendingMachine");
		assertTrue (dvm instanceof DrinkVendingMachine);
		
		dvm = new DrinkVendingMachine(availableCredit, brandName);
		testReport.assertReport(test, true, dvm instanceof DrinkVendingMachine);
		assertTrue (dvm instanceof DrinkVendingMachine);
	}
	
	@Test
	public void testPopulateDrinkList() {
		test = report.startTest("testPopulateDrinkList");
		drinkList.addAll(Arrays.asList(DefaultSnacks.snackList));
		testReport.assertReport(test, true, drinkList != null);
		assertTrue(drinkList != null);
		testReport.assertReport(test, true, !drinkList.isEmpty());
		assertTrue(!drinkList.isEmpty());
	}
	
	@Test
	public void testSelectDrink() {
		test = report.startTest("testSelectDrink");
		availableCredit = 10;
		this.user.addCredit(availableCredit);
		this.dvm.giveCredit(this.user, availableCredit);
		testReport.assertReport(test, true, DefaultSnacks.snackList[1] == this.dvm.selectDrink(1));
		assertEquals(DefaultSnacks.snackList[1], this.dvm.selectDrink(1));
	}
	
	@Test
	public void testGiveCredit() {
		test = report.startTest("testGiveCredit");
		this.dvm.giveCredit(this.user, this.availableCredit);
		testReport.assertReport(test, true, this.user.getWallet().getAllCredit() == availableCredit);
		assertTrue(this.user.getWallet().getAllCredit() == availableCredit);
	}
	
	@Test
	public void testSetGetBrandName() {
		test = report.startTest("testSetGetBrandName");
		this.dvm.setBrandName(brandName);
		testReport.assertReport(test, true, dvm.getBrandName() == this.brandName);
		assertTrue(dvm.getBrandName() == this.brandName);
	}
	
	@Test
	public void testGetAvailableCredit() {
		test = report.startTest("testGetAvailableCredit");
		this.dvm.setAvailableCredit(availableCredit);
		testReport.assertReport(test, true, dvm.getAvailableCredit() == this.availableCredit);
		assertTrue(dvm.getAvailableCredit() == this.availableCredit);
		
	}
		
	@Test
	public void testSetGetDrinkList() {
		test = report.startTest("testSetGetDrinkList");
		this.dvm.giveCredit(user, availableCredit);
		testReport.assertReport(test, true, null == this.dvm.selectDrink(0));
		assertEquals(null, this.dvm.selectDrink(0));
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
