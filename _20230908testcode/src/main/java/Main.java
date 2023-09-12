/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-08
 * Time: 11:39
 */
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        //test01();
        //test02();
        //test03()会报错 因为点击的是百度中新闻超链接 这个超链接没有放到form标签中
        //test03();
        //test04();
        //test05();
        // test07();
        //test08();
        //test09();
        //page01();
        //test10();
        //test11();
        //test12();
    }

    private static void test12() throws InterruptedException, IOException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("软件测试");
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(3000);
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D://20230521jietu.png"));
    }

    private static void test11() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        sleep(3000);
        // getWindowHandles此操作获取所有的窗口句柄 getWindowHandle获取get打开的页面窗口句柄
        Set<String> handles = webDriver.getWindowHandles();
        String target_handle = "";
        for (String handle:handles){
            target_handle = handle;
        }
        webDriver.switchTo().window(target_handle);
        sleep(3000);
        webDriver.findElement(By.cssSelector("#ww")).sendKeys("新闻联播");
        webDriver.findElement(By.cssSelector("#s_btn_wr")).click();
    }

    private static void test10() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        sleep(4000);
        //webDriver.quit();
        webDriver.close();
    }

    private static void page01() {

    }

    private static void test09() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("520");
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(3000);
        // 找到图片按钮
        WebElement webElement = webDriver.findElement(By.cssSelector("#s_tab > div > a.s-tab-item.s-tab-item_1CwH-.s-tab-pic_p4Uej.s-tab-pic"));
        // 鼠标右击
        Actions actions = new Actions(webDriver);
        sleep(3000);
        actions.moveToElement(webElement).contextClick().perform();
    }

    private static void  test08() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.baidu.com/");
        //搜索521
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("521");
        // control + A
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"A");
        sleep(3000);
        // control + X
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"X");
        sleep(3000);

        // control + V
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"V");
        sleep(3000);


    }

    private static void test07() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.baidu.com/");
        sleep(3000);
        //搜索521
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("521");
        webDriver.findElement(By.cssSelector("#su")).click();
        //强制等待3秒
        sleep(3000);
        //浏览器后退
        webDriver.navigate().back();
        //强制等待3s
        sleep(3000);
        webDriver.navigate().refresh();
        //浏览器前进
        webDriver.navigate().forward();
        sleep(3000);
        ((JavascriptExecutor)webDriver).executeScript("document.documentElement.scrollTop=10000");
        webDriver.manage().window().maximize();
        sleep(3000);
        webDriver.manage().window().fullscreen();
        sleep(3000);
        webDriver.manage().window().setSize(new Dimension(600,1000));
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
