package pomClassess;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClassess.UtilityClass;

public class ProfilePage extends UtilityClass {

	
	WebDriver driver;     //declaring as global so we can use in whole class and not initiate 

	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;                   
	//giving xpath by using @FindBy so we will use only emailID and perform action on it.it will reduce rework/retype

	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement AddNewAddressText;

	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement Address;
	
	@FindBy(xpath="(//div[@class='_1XFPmK'])[2]")
	private WebElement RadioWork;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> AddressCount;


	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public void ClickOnManageAddress()
	{
		IsElementVisible(driver,manageAddress);
		manageAddress.click();
	}



	public void ClickOnAddNewAddress()
	{
		IsElementVisible(driver,AddNewAddressText);
		AddNewAddressText.click();
	}

	
	public int getAddressCount()
	{
	
		return AddressCount.size();
	}
	
	public void GetDataForAddress(List<String> a) throws EncryptedDocumentException, IOException
	{
		
		//List<String> list = GetMultipleDataFromExcel(0,3);
				
		for(int i=1;i<=4;i++)
		{
			
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			
			element.sendKeys(a.get(i-1));
		}
	}
	
	public void AdressField()
	{
		Address.sendKeys("near pvr takies ,vaishavi bhavan,buliding no.2,latur");
	}
	
	public void ClickOnRadio()
	{
		RadioWork.click();
	}
	
	public void ClickOnSave()
	{
		Save.click();
	}

}
