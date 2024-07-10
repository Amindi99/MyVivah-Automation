package Account_Login;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Using_OTP {
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
    //Test case -  Login/ create account using OTP (TC: 001)
    @Test(priority = 1)
    public void LoginOTP() throws Exception {
        System.out.println("--------------------------------");
        System.out.println("             TC 001             ");
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

        //login via mobile
        userLogin();

    }


    //Supportive method section

    public void loginCreateButtonClick() throws InterruptedException {
        driver.get(BaseURL);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/span")).click();
        Thread.sleep(2000);
    }


    public void userLogin() throws InterruptedException {
        //Select country code
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("Sri Lanka");
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/p/span[1]"));
        Thread.sleep(2000);
        dropdownOption.click();

        //Get element name for mobile number and send values
        driver.findElement(By.name("phone")).sendKeys("716000003");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"user-register-btn\"]/span[1]")).click();
        Thread.sleep(2000);

        //Send otp
        try {

            // OTP to be entered
            String otp = "000000";

            // Locate OTP input fields
            WebElement otpField1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[1]"));
            WebElement otpField2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[2]"));
            WebElement otpField3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[3]"));
            WebElement otpField4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[4]"));
            WebElement otpField5 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[5]"));
            WebElement otpField6 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[2]/div/input[6]"));

            // Enter each digit of the OTP into the corresponding field
            otpField1.sendKeys(Character.toString(otp.charAt(0)));
            otpField2.sendKeys(Character.toString(otp.charAt(1)));
            otpField3.sendKeys(Character.toString(otp.charAt(2)));
            otpField4.sendKeys(Character.toString(otp.charAt(3)));
            otpField5.sendKeys(Character.toString(otp.charAt(4)));
            otpField6.sendKeys(Character.toString(otp.charAt(5)));

            //Click login button
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/button")).click();

        } finally {
            System.out.println("Successfully login to the account");
        }
    }

}

