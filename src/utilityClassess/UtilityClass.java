package utilityClassess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	
	
	WebDriver driver;
	
	
	public static void MoveToElement(WebDriver driver,WebElement element)
	{
	
	Actions act = new Actions(driver);
	
	act.moveToElement(element).pause(2000).build().perform();

	}
	
	
	public static void MoveByOffset(WebDriver driver)
	{
	
	Actions act = new Actions(driver);
	
	act.moveByOffset(200, 0).release().build().perform();

	}
	
	@SuppressWarnings("deprecation")
	public static boolean IsElementVisible(WebDriver driver,WebElement element)
	{
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

	}
	
	
	public static List<String> GetMultipleDataFromExcel (int firstRow,int lastRow) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("F:\\Pandit\\Required Document\\Selenium\\SELENIUM\\My_Excel\\XL-Sheet\\Book1.xlsx");
		
		List<String> dataList = new ArrayList<>();
		
		Sheet sheet = WorkbookFactory.create(file).getSheet("sheet3");
		
		for(int i=firstRow; i<=lastRow; i++)
		{
			try
			{
				String StringData = sheet.getRow(i).getCell(1).getStringCellValue();
				
				dataList.add(StringData);
			}
			
			catch(Exception e)
			
			{
			long intData =  (long) sheet.getRow(i).getCell(1).getNumericCellValue();
			
			String string = String.valueOf(intData);
			
			dataList.add(string);
			}
	
		}
		
		return dataList;
	}

}
