package Blog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-01
 * Time: 20:36
 */
public class InitAndEnd {
    static WebDriver webDriver;
    @BeforeAll
    static void SetUp(){
        webDriver = new ChromeDriver();
    }
    @AfterAll
    static void TearDown(){
        webDriver.quit();
    }
}
