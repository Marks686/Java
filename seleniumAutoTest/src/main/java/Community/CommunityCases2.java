package Community;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
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
public class CommunityCases2 extends InitAndEnd{

    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(
                "http://1.14.165.126:58080/index.html",
                "智翎社",
                "【JavaSE】抽象类和接口 （抽象类概念 抽象类语法 抽象类和普通类区别 抽象类的作用 接口使用 接口特性 实现多个接口 接口的继承）"
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
        webDriver.get("http://1.14.165.126:58080/sign-in.html");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 输入账号 likaixuan
        webDriver.findElement(By.cssSelector("#username")).sendKeys(username);
        sleep(2000);

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 输入密码 123456
        webDriver.findElement(By.cssSelector("#password")).sendKeys(password);
        sleep(2000);

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 点击提交按钮
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(2000);

        // 跳转到列表页
        //获取当前页面的url
        String cur_url = webDriver.getCurrentUrl();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // 如果url=http://1.14.165.126:58080/index.html 测试通过，否则测试不通过
        Assertions.assertEquals(blog_list_url,cur_url);
        // 列表页展示用户信息是likaixuan
        // 用户名是likaixuan测试通过，否则测试不通过
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String cur_admin = webDriver.findElement(By.cssSelector("#artical-items-body > div:nth-child(1) > div > div.col > div.text-muted.mt-2 > div > div.col > ul > li:nth-child(1)")).getText();
        Assertions.assertEquals(username,cur_admin);
    }

    /**
     * 文章列表页博客数量不为0
     */
    @Order(2)
    @Test
    void BlogList() throws InterruptedException {

        webDriver.get("http://1.14.165.126:58080/index.html");
        // 获取页面上所有文章标题对应的元素
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        int title_num = webDriver.findElements(By.cssSelector(".article_list_a_title")).size();
        // 如果元素数量不为0，测试通过
        Assertions.assertNotEquals(0 ,title_num);
        sleep(3000);

    }


    /**
     *
     * 写博客
     */
    @Order(3)
    @Test
    void EditBlog() throws InterruptedException {
        // 找到写博客按钮,点击
        webDriver.findElement(By.cssSelector("#bit-forum-content > div.page-header.d-print-none > div > div > div.col-auto.ms-auto.d-print-none > div > a.btn.btn-primary.d-none.d-sm-inline-block.article_post")).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        // 通过Js进行输入
//        ((JavascriptExecutor)webDriver).executeScript("document.getElementById(\"article_post_title\").value=\"自动化测试\"");
//        sleep(6000);

//        // 通过Js进行输入
//        ((JavascriptExecutor)webDriver).executeScript("document.getElementById(\"article_post_content\").value=\"自动化测试\"");
//        sleep(6000);

        // 输入标题
        webDriver.findElement(By.cssSelector("#article_post_title")).sendKeys("自动化测试");
        sleep(6000);
//        // 输入内容
//        webDriver.findElement(By.cssSelector("#article_post_content")).sendKeys("自动化测试");

        // 通过Js进行输入
        ((JavascriptExecutor)webDriver).executeScript("document.getElementById(\"article_post_content\").value=\"自动化测试\"");
        sleep(3000);




        // 点击发布
        webDriver.findElement(By.cssSelector("#article_post_submit")).click();
        sleep(3000);
        // 获取当前页面url
        String cur_url = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://1.14.165.126:58080/index.html", cur_url);
    }



    /**
     *
     * 删除和刚才发布的博客
     */
    @Order(4)
    @Test
    void DeleteBlog() throws InterruptedException {
        // 打开博客列表页面
        webDriver.get("http://1.14.165.126:58080/index.html");
        // 找到第一篇博客对应的产看全文按钮
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"artical-items-body\"]/div[1]/div/div[2]/div[1]/a/strong")).click();
        sleep(2000);

        // 点击删除按钮
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#bit-forum-content > div.page-body > div > div > div:nth-child(1) > div.col-9.card.card-lg > div.card-footer.bg-transparent.mt-auto.justify-content-end > div > div:nth-child(3) > div > a")).click();
        sleep(3000);



        webDriver.findElement(By.cssSelector("#details_delete_modal > div > div > div.modal-footer > div > div > div:nth-child(2)")).click();


        // 博客列表页第一篇博客标题不是“自动化测试”
        String first_blog_title = webDriver.findElement(By.xpath("//*[@id=\"artical-items-body\"]/div[1]/div/div[2]/div[1]")).getText();

        // 校验当前博客标题不等于“自动化测试”
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertNotEquals(first_blog_title, "自动化测试");
    }

    /**
     * 注销
     */
    @Order(5)
    @Test
    void Logout() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("body > div.page > header.navbar.navbar-expand-md.navbar-light.d-print-none > div > div > div.nav-item.dropdown")).click();
        sleep(2000);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.findElement(By.cssSelector("#index_user_logout")).click();


        sleep(2000);

        // 校验url(登录url)
        String cur_url = webDriver.getCurrentUrl();
        System.out.println(cur_url);
        Assertions.assertEquals("http://1.14.165.126:58080/sign-in.html", cur_url);
        // 校验提交按钮
        WebElement webElement = webDriver.findElement(By.cssSelector("#submit"));
        Assertions.assertNotNull(webElement);
    }

}
