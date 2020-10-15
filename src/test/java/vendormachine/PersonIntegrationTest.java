package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.item.Snack;

public class PersonIntegrationTest {

	private String brand = "Generic";
	private float storedCredit = 0.5f;
	private String name = "test";
	
	private static ExtentReports report;
	private ExtentTest test;
	
	@BeforeEach
	void init() {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "\\target\\reports\\WalletIntegrationReport.html");
		System.out.println(filePath.toString());
		report = new ExtentReports(filePath.toString(), true);	
	}
	
	@Test
	public void addCreditIntegrationTest() {
		test = report.startTest("addCreditIntegrationTest");
		Wallet wallet = new Wallet (brand, storedCredit);
		Person person = new Person(name, wallet);
		System.out.println(String.valueOf(person.getWallet().getBrand()));
		testReport.assertReport(test, true, 0.5f == person.getWallet().getAllCredit());
		assertTrue(0.5f == person.getWallet().getAllCredit());
		testReport.assertReport(test, true, brand == person.getWallet().getBrand());
		assertTrue(brand == person.getWallet().getBrand());
	}
	
//	@Test
//    public void snackTestOne() {
//        test = report.startTest("snackTestOne");
//        Snack snack = new Snack("test", 0.5f);
//        drinkList.add(snack);
//        assertEquals(DefaultSnacks.snackList[0].name,dvm.selectDrink(0).name);
//        assertEquals(DefaultSnacks.snackList[0].cost(),dvm.selectDrink(0).cost(),0.5);
//    }
	
//	 @Test
//	 public void selectDrinkTest() {
//		 test = report.startTest("selectDrinkTest");
//		 Snack snack = new Snack("test", 0.5f);
//		 drinkList.add(snack);
//		 Snack  newSnack = drinkList.get(0);
//		 testReport.assertReport(test, true, snack == newSnack);
//		 assertEquals(snack, newSnack);
//
//	}
	
	@After
	public void afterTest() {
		report.endTest(test);
	}
	
	@AfterClass
	public static void adterTestSuite() {
		report.flush();
		report.close();
	}
}
