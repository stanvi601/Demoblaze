package pages1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base1.Base1;

public class Details1 extends Base1
{
	String str,str1,str2;
	int cnt,cnt1;
	By hmpg =By.xpath("//img[@src='bm.png']");
	By prdctlink =By.linkText("Samsung galaxy s6");
	By prdctdetails=By.xpath("//div[@id='tbodyid']");
	By prdctdesp=By.xpath("//div[@class='description description-tabs']");
	By add_cartbtn=By.xpath("//a[@class='btn btn-success btn-lg']");
	By delete=By.linkText("Delete");
	By cartlink=By.linkText("Cart");
	By deletebtn=By.xpath("(//a[text()='Delete'][1])");
	
//	code to select(click) the product from the category
	public void prod_link()
	{
		driver.findElement(prdctlink).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		takeScrenShot("ProductDetails.png");
	}
	
//	code to read the product description 
	public void prod_details()
	{
		testlog = report.createTest("Product details Test");
	
		String str=driver.findElement(prdctdetails).getText();
		testlog.log(Status.INFO, str);
		
	}
	
	public void validate_prdpg()
	{
		if(driver.findElement(prdctdesp).isDisplayed())
		{
			System.out.println("Product details page is displayed");
		}
		else
		{
			driver.findElement(hmpg).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			prod_link();
		}
	}
	
//	code to add product to the cart
	public void add_to_cartbtn()
	{
		driver.findElement(add_cartbtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        driver.findElement(add_cartbtn).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert.accept();
      
	}
	
//	code to check the status of the cart(if product are added or not)
	public void cart_status()
	{
		testlog = report.createTest("Add to cart Test");
	
		driver.findElement(cartlink).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		takeScrenShot("Cart.png");
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		cnt=rows.size();
		if(cnt>=1)
		{
			testlog.log(Status.PASS, "Product is added in the cart");
		}
		else
		{
			testlog.log(Status.FAIL, "Product is not added in the cart");
		}
	}
	
//	code to validate the cart page
	public void validate_cart()
	{
		driver.findElement(cartlink).click();
	}
	
//	code to delete the product added in the cart
	public void delete_product()
	{
		driver.findElement(deletebtn).click();
	}
	
//	code to check the status of cart once the product is deleted
	public void del_cart_status()
	{
		testlog = report.createTest("Delete from cart Test");

		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		cnt1=rows.size();
		if(cnt1>1)
		{
			testlog.log(Status.PASS, "Product is deleted from the cart");
		}
		else
		{
			testlog.log(Status.FAIL, "Product is not deleted from the cart");
		}
	}
	
}
