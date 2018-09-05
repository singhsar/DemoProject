/**Summary--
 *  * This Class contains the methods to implement data driver testing with iterations for different data sets present in the data bank.
 *  * method purchaseMagicMouse - for different set of data- performs all the steps to buy the product Magic Mouse as specified in the Test Case.
 *  
  */
package scripts;

import java.io.IOException;

import actions.CheckOutProduct;
import actions.EnterContactOrBillingDtls;
import actions.OpenToolsQAwebSite;
import actions.ProductAddtoCart;
import actions.SelectProductCategory;
import actions.ViewTransactionDtls;
import utility.DriverUtil;
import utility.ExcelUtils;
import utility.TestNG_Reports;

public class DataDrivenClass {
    static String countryCode;
    static String provinceCode;
    static String emailID;
    static String firstName;
    static String lastName;
    static String address;
    static String city;
    static String province;
    static String postalCode;
    static String phoneNo;
	public static void placeOrderMagicMouse(int iTestCaseRow) {
		for (int i = 1; i <= iTestCaseRow; i++) {

			System.out.println(i);
			System.out.println(iTestCaseRow);
			try {
			countryCode = ExcelUtils.getCellData(i, 1);

			provinceCode = ExcelUtils.getCellData(i, 2);
			emailID = ExcelUtils.getCellData(i, 3);
			firstName = ExcelUtils.getCellData(i, 4);
			lastName = ExcelUtils.getCellData(i, 5);
			address = ExcelUtils.getCellData(i, 6);
			city = ExcelUtils.getCellData(i, 7);
			province = ExcelUtils.getCellData(i, 8);
			postalCode = ExcelUtils.getCellData(i, 9);
			phoneNo = ExcelUtils.getCellData(i, 10);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println(countryCode + provinceCode + emailID + firstName
					+ lastName + address + city + province + postalCode
					+ phoneNo);
			OpenToolsQAwebSite.openURL();
			SelectProductCategory.selectProductCategory();
			ProductAddtoCart.addToCartMagicMouse();
			CheckOutProduct.checkOutProduct();
			CheckOutProduct.continueAfterCheckout();
			EnterContactOrBillingDtls.enterContactBillingDtls(countryCode, provinceCode,
					emailID, firstName, lastName, address, city, province,
					postalCode, phoneNo);
			ViewTransactionDtls.viewTransactionDtls();
			DriverUtil.deleteCookies();
			try {
				TestNG_Reports.Take_TestOutput_Backup();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
