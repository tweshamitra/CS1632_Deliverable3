import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HerokuAppTest{
    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setup(){
        driver.get("https://cs1632ex.herokuapp.com/");
    }
    @Test
    public void Test(){
        String title = driver.getTitle();
        assertTrue(title.contains("CS1632"));
    }

    @Test
    public void testWelcomeMsg(){
        WebElement e = driver.findElement(By.className("lead"));
        String msg = e.getText();
        assertTrue(msg.contains("Welcome, friend,"));
    }
}