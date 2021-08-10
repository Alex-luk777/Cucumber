import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonCheck {

    WebDriver driver=Main.driver();
    @AfterClass
    public void afterClass(){driver.close();}

    @Given("^open startPage:(.*)$")
    public void openPage(String url){
       driver.get(Main.URL_CORE+url);
    }
    @Then("^button is displayed check:(.*),(.*/)$")
    public void pressBtn(String buttonId, String assertUrl1) throws InterruptedException {
       /* try {WebElement href1 = driver.findElement(By.id(id));
        }
         catch (Exception e) {
             driver.close();
        };*/
        driver.findElement(By.id(buttonId)).click();
        //assertTrue(href1.isDisplayed());

        Thread.sleep(500);
        assertTrue(equals(driver.getCurrentUrl(),assertUrl1));
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }

    private boolean equals(String currentUrl, String assertUrl) {
        if (currentUrl==(Main.URL_CORE+assertUrl))
            return true;
        else {
            return false;
        }

    }

}
