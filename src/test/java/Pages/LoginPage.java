package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    By usernamefield = By.id("user-name");
    By passwordfield = By.id("password");
    By login_btn = By.id("login-button");

    public void setUsername(String user_name){

        driver.findElement(usernamefield).sendKeys(user_name);
    }

    public void setPassword(String password){

        driver.findElement(passwordfield).sendKeys(password);
    }

    public void clickonlogin(){

        driver.findElement(login_btn).click();
    }
}
