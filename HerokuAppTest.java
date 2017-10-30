import static org.junit.Assert.*;

import java.util.logging.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import java.util.*;

public class HerokuAppTest{
    static WebDriver driver;

    @BeforeClass
    public static void setUpDriver(){
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        driver = new HtmlUnitDriver();
    }

    //Start at the home page for each test
    @Before
    public void setup() throws Exception{
        driver.get("https://cs1632ex.herokuapp.com/");
    }

    /**
        This tests requirement 1.
        It tests to check if the homepage displays the text "Welcome, friend,
        to a land of pure calculation".
     */
    @Test
    public void testWelcomeMsg(){
        WebElement e = driver.findElement(By.className("lead"));
        String msg = e.getText();
        assertTrue(msg.contains("Welcome, friend," + "\n" + "to a land of pure calculation."));
    }

    /**
        This tests requirement 1.
        It tests to check if the homepage displays the text "Used for CS1632 Sofware Quality Assurance,
        taught by Bill Laboon""
     */
    @Test
    public void testWelcomeMsg2(){
        WebElement e = driver.findElement(By.className("row"));
        String msg = e.getText();
        assertTrue(msg.contains("Used for CS1632 Software Quality Assurance, taught by Bill Laboon"));

    }

    /**
        This tests requirement 2.
        It looks for the five links at the top of the home page.
     */
    @Test
    public void testHeaderLinksHome() throws Exception{
        try{
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        } catch(Exception e){
            fail();
        }
    }

    /**
        This tests requirement 2.
        We navigate to the Factorial page and check if the five
        links are at the top of the page. 
    */
    @Test
    public void testHeaderLinksFactorialPage() throws Exception{
        WebElement w = driver.findElement(By.linkText("Factorial"));
        w.click();
         try{
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        } catch(Exception e){
            fail();
        }
    }
    

    /**
        This tests requirement 2.
        We navigate to the Fibonacci page and check if the five
        links are at the top of the page. 
    */    
    @Test
    public void testHeaderLinksFibonacciPage() throws Exception{
        WebElement w = driver.findElement(By.linkText("Fibonacci"));
        w.click();
        try{
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        } catch(Exception e){
            fail();
        }
    }

    /**
        This tests requirement 2.
        We navigate to the Hello page and check if the five
        links are at the top of the page. 
    */ 
    @Test
    public void testHeaderLinksHelloPage() throws Exception{
        WebElement w = driver.findElement(By.linkText("Hello"));
        w.click();        
        try{
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        } catch(Exception e){
            fail();
        }
    }

    /**
        This tests requirement 2.
        We navigate to the Cathedral Pics page and check if the five
        links are at the top of the page. 
    */
    @Test
    public void testHeaderLinksCathyPage() throws Exception{
        WebElement w = driver.findElement(By.linkText("Cathedral Pics"));
        w.click();         
        try{
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        } catch(Exception e){
            fail();
        }
    }

    /**
        This tests requirement 3. 
        We navigate to the Factorial page and enter 1, a boundary value.
        The answer should be 1.
     */
    @Test
    public void testFactorialOne(){
        WebElement factorial = driver.findElement(By.linkText("Factorial"));
        factorial.click();

        WebElement textArea = driver.findElement(By.xpath("//input[@type='text']"));
        textArea.sendKeys("1");
        
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Factorial of 1 is 1!", answer);

    }
    /**
        This tests requirement 3. 
        We navigate to the Factorial page and enter 100, a boundary value.
        The answer should be 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000.
     */
    @Test 
    public void testFactorialHundred(){
        WebElement factorial = driver.findElement(By.linkText("Factorial"));
        factorial.click();

        WebElement textArea = driver.findElement(By.xpath("//input[@type='text']"));
        textArea.sendKeys("100");
        
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!", answer);
    }

     /**
        This tests requirement 3. 
        We navigate to the Factorial page and enter 5, an interior value.
        The answer should be 120.
     */
    @Test 
    public void testFactorialFive(){
        WebElement factorial = driver.findElement(By.linkText("Factorial"));
        factorial.click();

        WebElement textArea = driver.findElement(By.xpath("//input[@type='text']"));
        textArea.sendKeys("5");
        
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Factorial of 5 is 120!", answer);
    }

    /**
        This tests requirement 4.
        We navigate to the Fibonacci page and enter 1, a boundary value. 
        The answer should be 1.
     */
    @Test  
    public void testFibOne(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textArea = driver.findElement(By.id("tb1"));
        textArea.sendKeys("1");

        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Fibonacci of 1 is 1!", answer);
    }

    /**
        This tests requirement 4.
        We navigate to the Fibonacci page and enter 100, a boundary value.
        The answer should be 354224848179261915075.
     */
    @Test
    public void testFibHundred(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textArea = driver.findElement(By.id("tb1"));
        textArea.sendKeys("100");

        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Fibonacci of 100 is 354224848179261915075!", answer);
    }

    /**
        This tests requirement 4.
        We navigate to the Fibonacci page and enter 30, an interior value.
        The answer should be 1346269.
     */
    @Test
    public void testFibInterior(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textArea = driver.findElement(By.id("tb1"));
        textArea.sendKeys("30");

        WebElement submitButton = driver.findElement(By.id("sub"));
        submitButton.click();

        WebElement text = driver.findElement(By.className("jumbotron"));
        String answer = text.getText();

        assertEquals("Fibonacci of 30 is 1346269!", answer);
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
        This is the first test for number 5 of the requirements
        We will go to the Fibonacci page and enter the value 
        "1.02" and see if the value is 1
    */
    @Test
    public void fibFloatTest(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textBox = driver.findElement(By.id("tb1"));
        textBox.sendKeys("1.02");

        WebElement submit = driver.findElement(By.id("sub"));
        submit.click();

        WebElement textArea = driver.findElement(By.className("jumbotron"));
        String actual = textArea.getText();

        assertTrue(actual.contains("1!"));
    }

    /**
        This is the first test for number 5 of the requirements
        We will go to the Fibonacci page and enter a large integer
        and see if the value is 1
    */
    @Test
    public void fibBigTest(){
        WebElement fib = driver.findElement(By.linkText("Fibonacci"));
        fib.click();

        WebElement textBox = driver.findElement(By.id("tb1"));
        textBox.sendKeys("100000000000000000000000000000");

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
    public void facFloatTest(){
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
        This will be another test for number 5 of the requirements that
        will test the factorial page. We will enter a string "stuff"
        in to the text box.
    */

    @Test
    public void facStrTest(){
        WebElement fac = driver.findElement(By.linkText("Factorial"));
        fac.click();

        WebElement textBox = driver.findElement(By.cssSelector("input[name='value']"));
        textBox.sendKeys("stuff");

        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.click();

        WebElement textArea = driver.findElement(By.className("jumbotron"));
        String actual = textArea.getText();

        assertTrue(actual.contains("1!"));
    }

    /**
        This will be another test for number 5 of the requirements that
        will test the factorial page. We will enter a large integer
        in to the text box.
    */

    @Test
    public void facBigTest(){
        WebElement fac = driver.findElement(By.linkText("Factorial"));
        fac.click();

        WebElement textBox = driver.findElement(By.cssSelector("input[name='value']"));
        textBox.sendKeys("10000000000000000000000000000000000000000000");

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

    /**
        This will be a test for number 7 in the requirments.
        We will go to the URL https://cs1632ex.herokuapp.com/hello/22
        and see if the large text displayed says "Hello CS1632, from meow!"
    */
    @Test 
    public void trailingURLNumTest(){
         driver.get("https://cs1632ex.herokuapp.com/hello/22");

         WebElement jumbotron = driver.findElement(By.className("jumbotron"));
         String actual = jumbotron.getText();

         assertTrue(actual.equals("Hello CS1632, from 22"));
    }


    /**
        This will go to the cathy page and count how many pictures there are and 
        make sure there are 3.
    */
    @Test
    public void cathyCountTest(){

        WebElement cathyButton = driver.findElement(By.linkText("Cathedral Pics"));
        cathyButton.click();

        List<WebElement> picList = driver.findElements(By.cssSelector("img"));
        int actual = picList.size();
        assertEquals(actual, 3);
    }
    
}