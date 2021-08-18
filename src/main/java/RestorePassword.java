import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RestorePassword {
    private final String xpathForButtonRecover="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-forgot-password/div/div[2]/app-content-container/div/div/form/div/button";

    public final String pushNotificationDivId = "toast-container";

    WebDriver driver=Main.driver();

    @Given("^open forgetLogInPage:(.*)$")
    public void openLoginPage(String url)  {
        System.out.println(Main.URL_CORE+url);
        driver.get(Main.URL_CORE+url);
    }

    @When("^type to input email to recover password:(.*)$")
    public void fillInEmail(String email){
        WebElement webElementLogin = driver.findElement(By.id("email"));
        webElementLogin.clear();
        webElementLogin.sendKeys(email);
    }

    @And("^press element with value Recover$")
    public void recoverBtnPress(){
        driver.findElement(By.xpath(xpathForButtonRecover)).click();
    }
    @Then("^Catch Pushnotification2:(.*)$")
    public void checkResult(boolean result){
        boolean flag = true;

        try{ driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            WebElement element = driver.findElement(By.id(pushNotificationDivId));}
        catch (Exception e){
            flag = false;
        }
        Assert.assertEquals(flag,result);
        //System.out.println(testName);
        driver.close();
    }
}
