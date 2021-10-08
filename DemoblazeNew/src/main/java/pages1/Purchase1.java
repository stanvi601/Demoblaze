package pages1;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base1.Base1;

public class Purchase1 extends Base1
{

	By placebtn=By.xpath("//button[text()='Place Order']");
	By purname=By.id("name");
	By purcountry=By.id("country");
	By purcity=By.id("city");
	By purcard=By.id("card");
	By purmonth=By.id("month");
	By puryear=By.id("year");
	By purchasebtn=By.xpath("//button[text()='Purchase']");
	By purchaseform=By.id("orderModalLabel");
	By purconfirm=By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
	By okbtn=By.xpath("//button[text()='OK']");
	
//	code to open the place order form
	public void place_order()
	{
		driver.findElement(placebtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(purname).sendKeys("Purple");
		driver.findElement(purcountry).sendKeys("India");
		driver.findElement(purcity).sendKeys("Pune");
		driver.findElement(purcard).sendKeys("42740147104");
		driver.findElement(purmonth).sendKeys("12");
		driver.findElement(puryear).sendKeys("22");
		driver.findElement(purchasebtn).click();
	}
	
//  code to confirm the purchase of the product
	public void purchase_confirm()
	{
		testlog = report.createTest("Purchase product Test");
		
		String str=driver.findElement(purconfirm).getText();
		testlog.log(Status.INFO, "Order confirmation details are: ");
		testlog.log(Status.INFO, str);
		takeScrenShot("Confirmation.png");
		driver.findElement(okbtn).click();
	}
	
}
