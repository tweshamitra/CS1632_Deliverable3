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


    /**
        This is the first test for number 5 of the requirements
        We will go to the Fibonacci page and enter the value 
        "sproing" and see if the value is 1
    */
    @Test
    public void fibStrTest(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textBox = driver.findElement(By.id("tb1"));
        textBox.sendKeys("sproing");

        WebElement submit = driver.findElement(By.id("sub"));
        submit.click();

        WebElement textArea = driver.findElement(By.className("jumbotron"));
        String actual = textArea.getText();

        assertTrue(actual.contains("1!"));
    }

    /**
        This will be another test for number 5 of the requirements that
        will test the factorial page. We will enter a floating point number
        in to the text box.
    */

    @Test
    public void facStrTest(){
        WebElement fac = driver.findElement(By.linkText("Factorial"));
        fac.click();

        WebElement textBox = driver.findElement(By.cssSelector("input[name='value']"));
        textBox.sendKeys("1.0");

        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.click();

        WebElement textArea = driver.findElement(By.className("jumbotron"));
        String actual = textArea.getText();

        assertTrue(actual.contains("1!"));
    }

    /**
        This will be a test for number 6 in the requirments.
        We will go to the URL https://cs1632ex.herokuapp.com/hello
        and see if the large text displayed says "Hello CS1632, from Prof. Laboon!"
    */
    @Test 
    public void helloURLTest(){
         driver.get("https://cs1632ex.herokuapp.com/hello");

         WebElement jumbotron = driver.findElement(By.className("jumbotron"));
         String actual = jumbotron.getText();

         assertTrue(actual.equals("Hello CS1632, from Prof. Laboon!"));
    }

        /**
        This will be a test for number 7 in the requirments.
        We will go to the URL https://cs1632ex.herokuapp.com/hello/meow
        and see if the large text displayed says "Hello CS1632, from meow!"
    */
    @Test 
    public void trailingURLTest(){
         driver.get("https://cs1632ex.herokuapp.com/hello/meow");

         WebElement jumbotron = driver.findElement(By.className("jumbotron"));
         String actual = jumbotron.getText();

         assertTrue(actual.equals("Hello CS1632, from meow"));
    }
    
}