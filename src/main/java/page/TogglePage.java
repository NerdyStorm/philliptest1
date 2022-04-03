package page;

 
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TogglePage   {

	WebDriver driver;
	
	public TogglePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using = "/html/body/div[3]/input[3]")
	WebElement TOGGLE_ELEMENT;
	@FindBy(how=How.CSS,using = "input[value ='on']")
	WebElement TOGGLE_ELEMENT_ON;
	@FindBy(how=How.XPATH,using = " /html/body/div[4]/input[2]")
	WebElement ADD_ELEMENT_BTN;
	@FindBy(how=How.XPATH,using = "/html/body/div[4]/input[1]")
	WebElement ADD_ELEMENT; 
	
	public void checkToggleBox() {
		TOGGLE_ELEMENT.click();
	}
	public void addItems() {

		int i = 0;
		while (i < 2) {

			int min = 0;
			int max = 10000000;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);  

			String random = String.valueOf(random_int);  

			ADD_ELEMENT.sendKeys("Panda".concat(random)); 
			ADD_ELEMENT_BTN.click();

			i++;
		}

	}
	public boolean verifyChecked() {

		 List<WebElement> elements = driver
				.findElements(By.xpath("//ul[contains(@style,'list-style-type')]//li//input"));

		// System.out.println(elements.size());

		int selected = 0;

		Iterator<WebElement> elementIterator = elements.iterator();
		while (elementIterator.hasNext()) {
			// System.out.println(elementIterator.next().isSelected());

			if (elementIterator.next().isSelected() == true) {
				selected++;
			}

		}

		System.out.println("Found " + elements.size() + " checkboxes");
		System.out.println("Found " + selected + " checkboxes were selected");

		if (selected == elements.size()) { // if not true will switch to else block and else block will return false
			return true;
		} else
			return false;
	}
}
