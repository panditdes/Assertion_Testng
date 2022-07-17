package testClassess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseClassess.BaseClass;
import pomClassess.HomePage;
import pomClassess.LoginPage;
import pomClassess.ProfilePage;

public class AddNewAddress {

	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;
	
	
	
	@BeforeClass
	
	public void beforeclass() throws InterruptedException
	{
		driver = BaseClass.getWebDriver();
	}

	
	@BeforeMethod
	
	public void beforemethod()
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	
	@Test
	
	public void VerifyUserCanLogIn() throws InterruptedException
	{
		lp.EnterEmailID();
		lp.EnterPassword();
		lp.ClickOnSubmitButton();
		hp.hoverToProfileName();
		
		String text = hp.GetLogOutText();
		
		Assert.assertEquals(text, "Logout");
		//Assert.assertNotEquals(text, "Login");
		//Assert.assertTrue(false);
		//Assert.assertFalse(false);
		//Assert.fail();
	}
	
	@DataProvider(name="dataset")
	public String[][] dataToTest()
	{
		
	String [][] data = {{"Mahesh","9856412589","411041","Pune City"}, {"Suverna","9856415889","413512","Latur City"}};
	
	return data;
	
	}
	
	@Test(priority=1, dataProvider="dataset")
	
	public void UserCanAddNewAddress(String name,String mobnumber,String pincode,String locality) throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		hp.MovePointer();
		hp.hoverToProfileName();
		hp.ClickOnMyProfileText();
		pp.ClickOnManageAddress();
		pp.ClickOnAddNewAddress();
		
		int oldCount = pp.getAddressCount();
		
		List<String> datalist = new ArrayList<>();
		datalist.add(name);
		datalist.add(mobnumber);
		datalist.add(pincode);
		datalist.add(locality);
		
		pp.GetDataForAddress(datalist);
		pp.AdressField();
		pp.ClickOnRadio();
		pp.ClickOnSave();
		
		int newCount = pp.getAddressCount();
		
		Assert.assertEquals(newCount, oldCount+2);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		//driver.quit();
	}
}
