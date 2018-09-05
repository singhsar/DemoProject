/**Summary--
 *  * This Class is TestNG class implementing test automation framework type1 (Test Data sheet rows will be iterated on basis on test case names)for this test automation project and also configured in the testng.xml file . 
 *  *@BeforeTest method openBrowser - instantiates driver and opens a new browser
 *  *@Test method main - performs all the steps to buy the product Magic Mouse as specified in the Test Case.
 *   *@AfterTest method closeBrowser - quits the driver instance on which the test case ran.
  */
package automation_framework;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DriverClass;
import scripts.DataDrivenClass;
import utility.Constant;
import utility.DriverUtil;
import utility.ExcelUtils;

public class TestFramework_1 {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  sTestCaseName ="TestCase_1";
		  System.out.println(sTestCaseName);
		  Reporter.log("Start Of TestCase");
		  ExcelUtils.setExcelFile(Constant.testDataFilePath,"TestCase_1");
		  iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		  driver = DriverUtil.OpenBrowser(iTestCaseRow);
		  new DriverClass(driver);
	  }
	  @Test
	  public void main() throws Exception {
		  try{
			  DataDrivenClass.placeOrderMagicMouse(iTestCaseRow);
			  Reporter.log("Test method placeOrderMagicMouse passed");
	  }
		  catch(Exception e){
			  Reporter.log("Test method placeOrderMagicMouse failed");
		  }
			  
		  }
	  @AfterMethod
	  public void afterMethod() {
		  
		    Reporter.log("End Of TestCase");

		    DriverUtil.closeBrowser();
	  		}
}
