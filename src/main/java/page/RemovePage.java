package page;

 

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemovePage  {
	
	WebDriver driver;
	
	public RemovePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how=How.CSS,using = "input[value='Remove']")
	WebElement REMOVEBUTTON_ELEMENT;
//	@FindBy(how=How.CSS,using = "input[name='todo[1]']")
//	WebElement SINGLEITEM_ELEMENT;
	@FindBy(how=How.XPATH,using = "//*[@id=\"todos-content\"]/form/ul/li[2]/a")
	WebElement SINGLEITEM_ELEMENT;
//	@FindBy(name = "todo[1]")
//	WebElement singleItem; 
	
	public void clickRemoveButton() {
		REMOVEBUTTON_ELEMENT.click();
		
	}
	public boolean clickSingleItem() {
		SINGLEITEM_ELEMENT.click();
		return false;
	}
	 
	public void verifyItemRemoved() {
		 List<WebElement> Element = driver.findElements( By.xpath("//ul[contains(@style,'list-style-type')]//li//input"));
		if (Element.size() !=0) {  

			System.out.println("Element not Removed");
		} else {  

			System.out.println("Element Removed");
		}
		 

	}
	 
}
