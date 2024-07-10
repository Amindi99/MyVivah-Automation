package Account_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Using_Email {
    //Global variable section
    String BaseURL = "https://www-dev.myvivah.app/";
    WebDriver driver;
    String actualText;
    String expectedText;


    //Before test section
    @BeforeTest
    public void BeforeTestMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //-----------Test case section
    //Test case -  Login to the account via email (TC: 003)
    @Test(priority = 1)
    public void LoginEmail() throws Exception {
        System.out.println("--------------------------------");
        System.out.println("             TC 003             ");
        System.out.println("--------------------------------");

        //Login button
        loginCreateButtonClick();
        System.out.println("User clicked on login create button successfully");

        //Verify the landing page is auth page
        expectedText = "Create Account or Login";
        actualText = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/p[1]")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Verified the customer is in the " + expectedText + " (Auth) Page");
        } else {
            System.out.println("Unsuccessful landing page" + '\n');
        }

        //login using password
        loginUsingPasswordButton();
        System.out.println("User clicked login using password option to direct to the email login");

        //login using email button
        loginUsingEmailButton();
        System.out.println("User selected login method as Email");


    }

    //Supportive method section

    public void loginCreateButtonClick() throws InterruptedException {
        driver.get(BaseURL);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/span")).click();
        Thread.sleep(2000);

    }

    public void loginUsingPasswordButton()throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/span/span")).click();
        Thread.sleep(2000);
    }

    public void loginUsingEmailButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[3]")).click();
        Thread.sleep(2000);


        //Send email
        driver.findElement(By.name("email")).sendKeys("rohith@mailinator.com");
        Thread.sleep(1000);
        System.out.println("User entered the email address");

        //Send password
        driver.findElement(By.name("password")).sendKeys("00000000");
        Thread.sleep(2000);
        System.out.println("User entered the Password");

        // Click fa-fa icon to see the entered password
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/i")).click();
        Thread.sleep(2000);

        //Click login button
        driver.findElement(By.xpath("//*[@id=\"user-login-btn\"]/span[1]")).click();

    }
}
