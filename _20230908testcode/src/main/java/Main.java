/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-08
 * Time: 11:39
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //test01();
        //test02();
        //test03()会报错 因为点击的是百度中新闻超链接 这个超链接没有放到form标签中
        //test03();
        //test04();
        test05();
    }

    private static void test05() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com/");
        String url = webDriver.getCurrentUrl();
        String title = webDriver.getTitle();
        if (url.equals("https://www.baidu.com/") && title.equals("百度一下，你就知道")){
            System.out.println("当前页面url=" + url + ", 当前页面title: " + title);
            System.out.println("测试通过");
        }else {
            System.out.println("测试不通过");
        }
    }

    private static void test04() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com/");
        String button_value = webDriver.findElement(By.cssSelector("#su")).getAttribute("value");
        //System.out.println(button_value);
        if (button_value.equals("百度一下")){
            System.out.println("测试通过");
        } else {
            System.out.println(button_value);
            System.out.println("测试不通过");
        }
    }

    private static void test03() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.xpath("//a[text()=(\"新闻\")]")).click();
    }

    private static void test02() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //允许所有的请求
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com/");
        sleep(3000);
        //找到百度搜索输入框 输入"java107"
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("java107");
        //点击百度一下按钮
        webDriver.findElement(By.cssSelector("#su")).submit();
        //隐式等待
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.DAYS);
        //清空百度搜索输入框数据
        webDriver.findElement(By.cssSelector("#kw")).clear();
    }

    private static void test01() throws InterruptedException {

        int flag = 0;
        ChromeOptions options = new ChromeOptions();
        //允许所有的请求
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        //打开百度首页
        webDriver.get("https://www.baidu.com/");
        //找到百度搜索输入框
        //WebElement element = webDriver.findElement(By.cssSelector(".s_ipt"));
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        //输入软件测试
        element.sendKeys("软件测试");
        //找到百度一下按钮
        // 点击
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(3000);
        // 校验
        // 找到搜索结果
        List<WebElement> elements = webDriver.findElements(By.cssSelector("a em"));
        for (int i = 0; i < elements.size(); i++) {
            //如果返回结果有软件测试 证明测试通过,否则测试不通过
            if (elements.get(i).getText().equals("软件测试")) {
                flag = 1;
                System.out.println("测试通过");
                break;
            }
        }
        if (flag == 0){
            System.out.println("测试不通过");
        }
    }
}
