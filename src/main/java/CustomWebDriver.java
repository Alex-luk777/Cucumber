import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class CustomWebDriver {

    private static WebDriver instance;


    public static synchronized WebDriver getInstance() {

        if (instance == null) {
          //  log.info("Init ChromeDriver....");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\BPLA_main\\src\\WebDriver\\chromedriver.exe");
            instance = new ChromeDriver();
            instance.manage().window().maximize();
        }

        return instance;
    }

    public static void destroyDriver() {
        instance.close();
       // log.info("ChromeDriver is closed");
    }

}
