package pomClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClassess.UtilityClass;

public class HomePage extends UtilityClass{

	

	WebDriver driver;     //declaring as global so we can use in whole class and not initiate 

	@FindBy(xpath="(//div[@class='exehdJ'])[1]")
	private WebElement ProfileName;                   
	//giving xpath by using @FindBy so we will use only emailID and perform action on it.it will reduce rework/retype

	@FindBy(xpath="//div[text()='My Profile']")
	private WebElement MyProfileText;

	@FindBy(xpath="(//li[@class='_2NOVgj'])[10]")       
	private WebElement LogOutText;
	//first time the element will attach to Dom known as early inntialise


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public void hoverToProfileName() throws InterruptedException
	{
		IsElementVisible(driver,ProfileName);
		Thread.sleep(3000);
		MoveToElement(driver,ProfileName);
	}

	public void ClickOnMyProfileText()
	{
		IsElementVisible(driver,MyProfileText);
		MyProfileText.click();
	}

	public String GetLogOutText()
	{
		return LogOutText.getText();
	}

	public void MovePointer() throws InterruptedException
	{
		MoveByOffset(driver);
		Thread.sleep(3000);
	}
}
