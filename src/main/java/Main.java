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

    public void loginTest2() {
        LoginTest loginTest = new LoginTest();

        loginTest.
    }
}
