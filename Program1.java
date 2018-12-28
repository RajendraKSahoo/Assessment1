package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program1 {
	public static void main(String arg[]) throws InterruptedException {
		
		System.out.println("Start of coding...");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		driver.get("https://datatables.net/");
		
		WebElement showEle= driver.findElement(By.xpath("//select[@name='example_length']/option[3]"));
		showEle.click();
		System.out.println("The count for show entries is selected as 50...");
		
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int noOfRows=rows.size();
		
		int total=0;
		for(int i=1;i<=noOfRows;i++)
		{
		WebElement nameEle= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
		nameEle.click();
		
		WebElement ageEle= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]"));
		String age = ageEle.getText();
		int Age = Integer.parseInt(age);
		System.out.println(Age);
		
		WebElement salEle = driver.findElement(By.xpath("//span[@class='dtr-data']"));
		String salary = salEle.getText().trim().replace("$", "").replace(",", "");
		int Salary = Integer.parseInt(salary);
		System.out.println(Salary);
		nameEle.click();
		}
		
		System.out.println("The total salary of all the employee: " +total);
		
		System.out.println("End of Program!!!");
	}
}