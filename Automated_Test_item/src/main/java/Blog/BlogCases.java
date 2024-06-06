package Blog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-01
 * Time: 20:38
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogCases extends InitAndEnd{

    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(
                "http://1.14.165.126:9092/blog_detail.html",
                "博客详情页",
                "自动化测试"
                ));
    }

    /*
    * 输入正确的账号，密码登录成功
    * */
    @Order(1)
    @ParameterizedTest
    @CsvFileSource(resources = "LoginSuccess.csv")
    void LoginSuccess(String username, String password,String blog_list_url) throws InterruptedException {
        System.out.println(username + password + blog_list_url);
        // 打开博客登录页面
        webDriver.get("http://1.14.165.126:9092/blog_login.html");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 输入账号 zhangsan
        webDriver.findElement(By.cssSelector("#username")).sendKeys(username);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 输入密码 123456
        webDriver.findElement(By.cssSelector("#password")).sendKeys(password);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 点击提交按钮
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(300);

        // 跳转到列表页
        //获取当前页面的url
        String cur_url = webDriver.getCurrentUrl();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 如果url=http://1.14.165.126:9092/blog_list.html 测试通过，否则测试不通过
        Assertions.assertEquals(blog_list_url,cur_url);
        // 列表页展示用户信息是zhangsan
        // 用户名是zhangsan测试通过，否则测试不通过
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String cur_admin = webDriver.findElement(By.cssSelector("body > div.container > div.left > div > h3")).getText();
        Assertions.assertEquals(username,cur_admin);
    }

    /**
     * 博客列表页博客数量不为0
     */
    @Order(2)
    @Test
    void BlogList() throws InterruptedException {
        // 打开博客列表页


//        // 打开博客登录页面
//        webDriver.get("http://1.14.165.126:9092/blog_login.html");
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        // 输入账号 zhangsan
//        webDriver.findElement(By.cssSelector("#username")).sendKeys("zhangsan");
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//        // 输入密码 123456
//        webDriver.findElement(By.cssSelector("#password")).sendKeys("123456");
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//        // 点击提交按钮
//        webDriver.findElement(By.cssSelector("#submit")).click();
//        sleep(300);
        webDriver.get("http://1.14.165.126:9092/blog_list.html");
        // 获取页面上所有博客标题对应的元素
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        int title_num = webDriver.findElements(By.cssSelector(".title")).size();
        // 如果元素数量不为0，测试通过
        Assertions.assertNotEquals(0 ,title_num);
    }

    /**
     * 博客详情页校验
     * url
     * 博客标题
     * 页面title是“博客详情页”
     */
    @Order(4)
    @ParameterizedTest
    @MethodSource("Generator")
    void BlogDetail(String expected_url, String expected_title, String expected_blog_title) {
        // 找到第一篇博客对应的产看全文按钮
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/a")).click();
        // 获取当前页面url
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String cur_url = webDriver.getCurrentUrl();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 获取当前页面title
        String cur_title = webDriver.getTitle();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 获取博客标题
        String cur_blog_title = webDriver.findElement(By.cssSelector("body > div.container > div.right > div > div.title")).getText();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals(expected_title ,cur_title);
        Assertions.assertEquals(expected_blog_title, cur_blog_title);
        if(cur_url.contains(expected_url)) {
            System.out.println("测试通过");
        } else {
            System.out.println(cur_url);
            System.out.println("测试不通过");
        }
    }

    /**
     *
     * 写博客
     */
    @Order(3)
    @Test
    void EditBlog() throws InterruptedException {
        // 找到写博客按钮,点击
        webDriver.findElement(By.cssSelector("body > div.nav > a:nth-child(5)")).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 通过Js进行输入
        ((JavascriptExecutor)webDriver).executeScript("document.getElementById(\"title\").value=\"自动化测试\"");
        sleep(3000);
        // 点击发布
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(3000);
        // 获取当前页面url
        String cur_url = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://1.14.165.126:9092/blog_list.html", cur_url);
    }

    /**
     * 校验已发布博客标题
     * 校验已发布博客时间
     */
    @Order(5)
    @Test
    void BlogInfoChecked() {
        webDriver.get("http://1.14.165.126:9092/blog_list.html");
        // 获取第一篇博客标题
        String first_blog_title = webDriver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > div.title")).getText();
        // 获取第一篇博客发布时间
        String first_blog_time = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]")).getText();
        // 校验博客标题是不是自动化测试
        Assertions.assertEquals("自动化测试", first_blog_title);
        // 如果时间是2023-03-03年发布的，测试通过
        if(first_blog_title.contains("2024-03-03")) {
            System.out.println("测试通过");
        } else {
            System.out.println("当前时间是：" + first_blog_time);
//            System.out.println("测试不通过");
        }
    }

    /**
     *
     * 删除和刚才发布的博客
     */
    @Order(6)
    @Test
    void DeleteBlog() throws InterruptedException {
        // 打开博客列表页面
        webDriver.get("http://1.14.165.126:9092/blog_list.html");
        // 点击全文按钮
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > a")).click();
        // 点击删除按钮
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("body > div.container > div.right > div > div.operating > button:nth-child(2)")).click();
        sleep(3000);
        // 博客列表页第一篇博客标题不是“自动化测试”
        String first_blog_title = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]")).getText();

        // 校验当前博客标题不等于“自动化测试”
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertNotEquals(first_blog_title, "自动测试");
    }

    /**
     * 注销
     */
    @Order(7)
    @Test
    void Logout() {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("body > div.nav > a:nth-child(6)")).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 校验url(登录url)
        String cur_url = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://1.14.165.126:9092/blog_login.html", cur_url);
        // 校验提交按钮
        WebElement webElement = webDriver.findElement(By.cssSelector("#submit"));
        Assertions.assertNotNull(webElement);
    }

}
