package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program2 {
	public static void main (String arg[]) throws InterruptedException {
		System.out.println("Start of coding...");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		driver.get("https://moneycontrol.com/");
		Thread.sleep(1000);
		
		WebElement stocksEle = driver.findElement(By.xpath("(//a[@title='Stocks'])[1]"));
		stocksEle.click();
		Thread.sleep(1000);
		WebElement alphaEle = driver.findElement(By.xpath("//a[@title='A']"));
		alphaEle.click();
		
		List<WebElement> alinksEle=driver.findElements(By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr/td"));
		int noOfLinks = alinksEle.size();
		System.out.println("The total number of links starting with A: " +noOfLinks);
		System.out.println("The links are as below:");
		
		for(int i=0; i<noOfLinks; i++)
		{
			WebElement linkEle= alinksEle.get(i);
			String link = linkEle.getAttribute("href");
						
			String text= linkEle.getText();
			System.out.println(text);
			
		}
		
		WebElement alEle = driver.findElement(By.xpath("//a[@title='Ashok Leyland']"));
		alEle.click();
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		
	}
}
