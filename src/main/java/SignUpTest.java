import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertFalse;

public class SignUpTest {
    private final String loginFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/input";
    private final String nameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/input";
    private final String surnameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[3]/div/div/input";
    private final String telFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[4]/div/div/input";
    private final String birthdayFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[5]/div/div/app-date-time/div/input";
    private final String passwordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[9]/div/div/input";
    private final String confirmpasswordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[10]/div/div/input";
    private final String iagreeboxFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[11]/div/div/div[2]/label";
    private final String submitFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/button";
    // private final String newLogin="li" + new Random().nextInt() + "@gmeil.com";
    public final String pushNotificationDivId = "toast-container";
    WebDriver driver=null;
    @Before
    public void initBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\BPLA_main\\src\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }

    @Given("^open SignUp page:(.*)$")
    public void openLoginPage(String url)  {
        driver.get(url);
    }

    @When("^fillInSignUpForm:(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
    public void fillInSignUpForm(String newLogin,String name,String surname, String phone,String birthDate,String password,String confirmpassword) {
        WebElement xpath = driver.findElement(By.xpath(loginFieldXpath));
        xpath.clear();
        String newLoginUpdated="";

        switch (newLogin){
            case "": newLoginUpdated="";
            break;
            case "ok": newLoginUpdated= "test"+new Random().nextInt(100)*10 + "@gmeil.com";
            break;
            case "existed": newLoginUpdated="lilipyt@gmail.com";
            break;
            case ".ru":newLoginUpdated="lilipyt@mail.ru";
            break;
            default:newLoginUpdated="";
        }
        xpath.sendKeys(newLoginUpdated);
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys(name);
        driver.findElement(By.xpath(surnameFieldXpath)).sendKeys(surname);
        driver.findElement(By.xpath(telFieldXpath)).sendKeys(phone);
        driver.findElement(By.xpath(birthdayFieldXpath)).clear();
        driver.findElement(By.xpath(birthdayFieldXpath)).sendKeys(birthDate);
        driver.findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
        driver.findElement(By.xpath(confirmpasswordFieldXpath)).sendKeys(confirmpassword);
    }

    @And("^fill checkbox and press element with value Submit$")
            public void checkBoxandSubmit(){
        driver.findElement(By.xpath(iagreeboxFieldXpath)).click();
        driver.findElement(By.xpath(submitFieldXpath)).click();
    }

    @Then("^Catch Pushnotification:(.*),(.*)$")
            public void checkResult(boolean result, String testName){
        boolean flag = true;

        try{ driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            WebElement element = driver.findElement(By.id(pushNotificationDivId));}
        catch (Exception e){
            flag = false;
            driver.close();
            Assert.assertEquals(flag,result);

            //return flag;
        }
        driver.close();
        Assert.assertEquals(flag,result);
        //return flag;

    }




}
