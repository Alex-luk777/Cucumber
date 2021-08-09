import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class LoginTest {
    private final String xpathButtonSignIn = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForButtonSubmit = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForVerifyResult = "/html/body/app-root/app-full-layout/div/app-header/div/div/div[1]";

    private final String xpathForLogout="/html/body/app-root/app-full-layout/div/app-header/nav/div[2]/ul[2]/li[3]/button";

    private final String xpathErrorPwWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/app-error/div";

    private final String xpathErrorLoginWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/app-error/div";


   /* public static WebDriver driver() {

        return ;
    }*/

    /*public LoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\BPLA_main\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver = driver;
    }*/









}
