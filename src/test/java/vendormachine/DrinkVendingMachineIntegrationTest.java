package vendormachine;

import static org.junit.Assert.assertEquals;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineIntegrationTest {

	private String brand = "Generic";
	private float storedCredit = 0.5f;
	private String name = "test";
	
	private static ExtentReports report;
	private ExtentTest test;
	
	@Mock
	private static Wallet wallet;
	
	@InjectMocks
	private static Person person;
	
	private static DefaultSnacks snackList;
	
	@BeforeEach
	void init() {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "\\target\\reports\\WalletIntegrationReport.html");
		System.out.println(filePath.toString());
		report = new ExtentReports(filePath.toString(), true);	
	}
	
//	 @Test
//	 public void selectDrinkTest() {
//		 test = report.startTest("selectDrinkTest");
//		 Snack snack = new Snack("Water", 0.20f);
//		 Snack newSnack = snackList.contains
//		 testReport.assertReport(test, true, snack == newSnack);
//		 assertEquals(snack, newSnack);
//	}
	
	@Test
	public void giveCreditTest() {

		
	}
	
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
