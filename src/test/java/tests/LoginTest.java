package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void testValidLogin() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("admin@yourstore.com","admin");
	}
	
}
