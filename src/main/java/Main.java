import io.cucumber.core.snippets.SnippetType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/features/guessword.feature",
        glue = "mainPackage",
        tags = "@all",
        dryRun = false,
        //snippets = SnippetType.UNDERSCORE,
        name = ("^Успешное|Успешная.*$")
)


public class Main {
    public static final String URL_CORE="https://bpla.mpsdevelopment.com";

    public static WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\BPLA_main\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        return driver;
    }

}