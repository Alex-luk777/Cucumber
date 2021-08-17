import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\MyProject\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alex\\Desktop\\MyProject\\WebDriver\\geckodriver.exe");
        WebDriver instance= new FirefoxDriver();*/
        System.out.println(Main.URL_CORE);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        return driver;

    }

}