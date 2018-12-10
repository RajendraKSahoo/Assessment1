package demo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {
	public static void main (String arg[])
	{
		System.out.println("Start of coding...");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://datatables.net");
		
		WebElement showEle = driver.findElement(By.xpath("//select[@name='example_length']/option[3]"));
		showEle.click();
		
		//RowCount
		WebElement rows = driver.findElement(By.xpath("//table[@id='example']/tbody/tr"));
		//int rowCount = rows.getSize();
		
		
		//WebElement nameEle = driver.findElements(By.xpath(""));
		
		
	}

}
