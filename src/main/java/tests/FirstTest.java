package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.get("https://selenium.dev");
		driver.get("https://admin-demo.nopcommerce.com/login");
//		String title=driver.getTitle();
//		System.out.println(title);
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@value='admin']")).sendKeys("admin");
		WebElement lg=driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(lg.getText());
		lg.click();
//		driver.quit();;

	}

}
