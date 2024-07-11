package Account_Create;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New_Account_Create {
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
    //Test case -  Create a new account (TC: 005)
    @Test(priority = 1)
    public void UserSignUp() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("                     TC 005                     ");
        System.out.println("------------------------------------------------");

        //login/ create button click
        loginCreateButtonClick();
        System.out.println("User clicked login/ create button");

        //select country code
        selectCountryCode();
        System.out.println("Country code selected");

        //Enter user mobile number
        enterMobileNumber();
        System.out.println("User entered his/ her mobile number ");

        //Add OTP
        enterOTP();
        System.out.println("User added OTP");

        //select account create by option from the dropdown
        account_CreateBy();
        System.out.println("User selected account create by from options");

        //click account create button
        createAccountButton();
        System.out.println("Successfully user entered to account create flow");


    }

    //Supportive method section
    public void loginCreateButtonClick() throws InterruptedException {
        driver.get(BaseURL);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/span")).click();
        Thread.sleep(2000);
    }

    public void  selectCountryCode() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("Sri Lanka");
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/p/span[1]"));
        Thread.sleep(2000);
        dropdownOption.click();
    }

    public void enterMobileNumber() throws InterruptedException{
        // Test number : 716000004
        driver.findElement(By.name("phone")).sendKeys("716000004");
        driver.findElement(By.xpath("//*[@id=\"user-register-btn\"]/span[1]")).click();
        Thread.sleep(2000);
    }

    public void enterOTP() throws InterruptedException{
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

        } finally {
            System.out.println("OTP Entered");
        }
        Thread.sleep(2000);

    }

    // select account create by option
    public void account_CreateBy() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/select")).click();
        Thread.sleep(2000);

        //Select options
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/select/option[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/select/option[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/select/option[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/div[3]/select/option[5]")).click();
        Thread.sleep(2000);
    }

    //Click account Create button
    public void createAccountButton() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]/div/div/div/button/span[1]")).click();
    }
}

