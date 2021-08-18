import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonCheck {
   /* public void testSignUpPublicInfo() throws Exception {
        instance.get(urlSignUp);
        WebElement href1 = instance.findElement(By.id("publicInfo"));
        assertTrue((href1.isDisplayed()));*/

    WebDriver driver=Main.driver();
    @AfterClass
    public void afterClass(){driver.close();}

    @Given("^open startPage:(.*)$")
    public void openPage1(String url){
        driver.get(Main.URL_CORE+url);
    }



    @Then("^button is displayed check:(.*),(.*)$")
    public void pressBtn(String buttonId, String assertUrl1) throws InterruptedException {
       try {WebElement href1 = driver.findElement(By.id(buttonId));
        }
         catch (Exception e) {
             driver.close();
        };
        driver.findElement(By.id(buttonId)).click();
        //assertTrue(href1.isDisplayed());
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(Main.URL_CORE+assertUrl1);
        assertEquals(driver.getCurrentUrl(),(Main.URL_CORE+assertUrl1));
        driver.close();
    }



    @Then("^new window displayed check:(.*),(.*)$")
    public void pressBtnWithLink(String buttonId, String assertUrl1) throws InterruptedException {
        try {WebElement href1 = driver.findElement(By.id(buttonId));
        }
        catch (Exception e) {
            driver.close();
        };
        driver.findElement(By.id(buttonId)).click();
        //assertTrue(href1.isDisplayed());
        String[] linkAfter= driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(linkAfter[1]);
        Thread.sleep(2000);
       //driver.switchTo().window(driver.getWindowHandle());
       //driver.navigate().forward();
       //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        System.out.println(driver.getCurrentUrl()+ "     "+ driver.getWindowHandles());
        System.out.println(assertUrl1);
        assertEquals(driver.getCurrentUrl(),(assertUrl1));
        driver.close();
        driver.switchTo().window(linkAfter[0]);
        driver.close();
    }

}