package pages1;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base1.Base1;

public class Home1 extends Base1
{
	String str;
	By hmpg =By.xpath("//img[@src='bm.png']");
	By signlink=By.linkText("Sign up");
	By signform=By.id("signInModalLabel");
	By vsignuser=By.id("sign-username");
	By vsignpass=By.id("sign-password");
	By signbtn=By.xpath("//button[text()='Sign up']");
	By loginlink=By.linkText("Log in");
	By vloginuser=By.id("loginusername");
	By vloginpass=By.id("loginpassword");
	By loginbtn=By.xpath("//button[text()='Log in']");
	By loginform=By.id("logInModalLabel");
	By cntlink=By.linkText("Contact");
	By cntEmail=By.id("recipient-email");
	By cntName=By.id("recipient-name");
	By cntMsg=By.id("message-text");
	By cntbtn=By.xpath("//button[text()='Send message']");
	By cartlink=By.linkText("Cart");
	By placebtn=By.xpath("//button[text()='Place Order']");
	By phnlink=By.linkText("Phones");
	By slider=By.xpath("//div[@class='carousel-inner']");
	
//	code to open the URL of the website 
	public void openURL()
	{
		driver.get(prop.getProperty("url"));
		try 
		{
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
//	code to validate the home page of the website
	public void validate_hmpg()
	{
		if(driver.findElement(slider).isDisplayed())
		{
			System.out.println("User is on home page");
		}
		else
		{
			driver.findElement(By.id("hmpg")).click();
		}
	}
	
//	code to open the signUp form
	public void open_signup()
	{
		driver.findElement(signlink).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	code to enter the invalid details in signUp form
	public void invalid_signup() throws AWTException
	{
		driver.findElement(vsignuser).sendKeys("White");
		driver.findElement(vsignpass).sendKeys("White@123");
		driver.findElement(signbtn).click();
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        str=alert.getText();
        alert.accept();
        driver.findElement(vsignuser).clear();
        driver.findElement(vsignpass).clear();
	}
	
//	code to check the signUp form status
	public void signup_status()
	{
		testlog = report.createTest("SignUp Test (Valid & Invalid)");
		if(str.contains("Sign up successful."))
		{
		//System.out.println("SignUp successful");
			testlog.log(Status.PASS, "Entered valid details-Sign up successful");
		}
		else
		{
		//System.out.println("SignUp unsuccessful");
			testlog.log(Status.FAIL, "Entered invalid details-Sign up unsuccessful");
		}
		
	}
	
//	code to open validate the signUp form
	public void navigate_signup()
	{
		if(driver.findElement(signform).isDisplayed())
		{
			System.out.println("On sign up form");
		}
		else
		{
			open_signup();
		}
	}
	
//	code to enter the valid details in signUp form
	public void valid_Reg() throws AWTException
	{
		driver.findElement(vsignuser).sendKeys("Execution43");
		driver.findElement(vsignpass).sendKeys("user@123");
		driver.findElement(signbtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        str=alert.getText();
        alert.accept();
       
	}
	
//	code to open the login form
	public void open_login()
	{
		driver.findElement(loginlink).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	code to enter the invalid details in login form	
	public void invalid_login(String username, String password) throws AWTException
	{
		driver.findElement(vloginuser).sendKeys(username);
		driver.findElement(vloginpass).sendKeys(password);
		driver.findElement(loginbtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        str=alert.getText();
        alert.accept();
        driver.findElement(vloginuser).clear();
        driver.findElement(vloginpass).clear();
	}
	
//	code to check the login form status	
	public void login_status()
	{
		testlog = report.createTest("Login Test (Valid & Invalid)");
		
		if(str.contains("User does not exist.") || str.contains("Wrong password.") )
		{
			testlog.log(Status.FAIL, "Entered invalid details-Login unsuccessful");
		}
		else
		{
			testlog.log(Status.PASS, "Entered valid details-Login successful");
		}
		
	}
	
//	code to validate the login form
	public void login_form()
	{
		if(driver.findElement(loginform).isDisplayed())
		{
			System.out.println("On login form");
		}
		else
		{
			open_login();
		}
	}
	
//	code to enter the valid details in login form	
	public void valid_login(String username1, String password1) throws AWTException
	{
		driver.findElement(vloginuser).sendKeys(username1);
		driver.findElement(vloginpass).sendKeys(password1);
		driver.findElement(loginbtn).click();
		str="";
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		takeScrenShot("ValidLogin.png");
	}
	
//	code to open the contactUs form
	public void contact_us()
	{
		driver.findElement(cntlink).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(cntEmail).sendKeys("Purple123@gmail.com");
		driver.findElement(cntName).sendKeys("Purple");
		driver.findElement(cntMsg).sendKeys("Kindly mail me the status of my purchased product");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(cntbtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        str=alert.getText();
        alert.accept();
	}
	
//	code to check the contactUs messgase status
	public void msg_status()
	{
		testlog = report.createTest("ContactUS Test");
		
		if(str.contains("Thanks for the message!!"))
		{
			testlog.log(Status.PASS, "Message sent successful");
		}
		else
		{
			testlog.log(Status.FAIL, "Message sent unsuccessful");
		}
	}
	
//	code to select the category
	public void category() throws IOException 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(phnlink).click();
	}
	
//	code to read the list of products from the selected category
	public void read_products() throws IOException
	{
		FileInputStream file=new FileInputStream("C:/Java_project/DemoblazeNew/Demoblaze.xlsx");  
		XSSFWorkbook wb=new XSSFWorkbook(file); 
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		testlog = report.createTest("Read Products Test");
		
		List<WebElement> list=driver.findElements(By.xpath("//a[@class='hrefch']"));
		 Row row;
		 
		 for(int r=0;r<list.size();r++)       
		 {
			 	testlog.log(Status.INFO, list.get(r).getText());
			 	row=ws.createRow(r);
			    str=list.get(r).getText();
			    row.createCell(0).setCellValue(r+1);
			    row.createCell(1).setCellValue(str);
			  
		 } 
		 FileOutputStream fout=new FileOutputStream("C:/Java_project/DemoblazeNew/Demoblaze.xlsx");
			wb.write(fout);
			wb.close();
			
	}
	
}
