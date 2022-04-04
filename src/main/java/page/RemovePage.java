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

	@FindBy(how=How.CSS,using = " body > div.controls > input[type=submit]:nth-child(1)")
	WebElement REMOVEBUTTON_ELEMENT;
	@FindBy(how=How.CSS,using = "input[name='todo[1]']")
	WebElement SINGLEITEM_ELEMENT;
	@FindBy(how=How.XPATH,using = "//*[@id=\"todos-content\"]/form/ul/li[2]/text()")
	WebElement LISTITEM_ELEMENT;
//	@FindBy(name = "todo[1]")
//	WebElement singleItem; 
	
	public void clickRemoveButton() {
		REMOVEBUTTON_ELEMENT.click();
		
	}
	public boolean clickSingleItem() {							 
		SINGLEITEM_ELEMENT.click();
		return true;											 
	}
	public  void listItemElement() {
		LISTITEM_ELEMENT.getText();
	}
	 
	public void verifyItemRemoved() {
	 
		 List<WebElement> Element = driver.findElements(By.cssSelector("input[name='todo[0]']"));
		 
		if (Element.size() !=0 ) {  

			System.out.println("Element Removed");
		} else {  

			System.out.println("Element not Removed");
		}
		 

	}
	 
}
