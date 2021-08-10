import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class LoginTest {
    private final String xpathButtonSignIn = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForButtonSubmit = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForVerifyResult = "/html/body/app-root/app-full-layout/div/app-header/div/div/div[1]";

    private final String xpathForLogout="/html/body/app-root/app-full-layout/div/app-header/nav/div[2]/ul[2]/li[3]/button";

    private final String xpathErrorPwWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/app-error/div";

    private final String xpathErrorLoginWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/app-error/div";

    WebDriver driver=null;

    @Given("^open logInPage:(.*)$")
    public void openLoginPage(String url)  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\BPLA_main\\src\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^type to input login text:(.*)$")
    public void fillInLogin(String login){
        WebElement webElementLogin = driver.findElement(By.id("login"));
        webElementLogin.clear();
        webElementLogin.sendKeys(login);
    }

    @And("^type to input with name password text:(.*)$")
    public void fillInPassword(String password){
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

    }
    @And("^press element with value Submit$")
    public void submit(){
        driver.findElement(By.xpath(xpathForButtonSubmit)).click();
    }

    @Then("^The element with tag Welcome should exist:(.*),(.*)$")
    public boolean checkWelcomeExist(boolean result, String testName) throws InterruptedException {
        boolean flag=true;
        System.out.println(testName);
        try {
            driver.findElement(By.xpath(xpathErrorPwWrong));
            driver.findElement(By.xpath(xpathErrorLoginWrong));
        } catch (Exception e){
            flag=true;
            //System.out.println("Error" );
        }
        try {
            driver.findElement(By.xpath(xpathForVerifyResult));
            driver.findElement(By.xpath(xpathForLogout));
        } catch (Exception e) {
            flag = false;
        }

        if (flag) {
            driver.findElement(By.xpath(xpathForLogout)).click();
            //Thread.sleep(500);
            //System.out.println("logout" );
        }
        Assert.assertEquals(flag,result);
        driver.close();
        return flag;
    }

}
