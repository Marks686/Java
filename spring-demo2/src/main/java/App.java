import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-13
 * Time: 22:29
 */
public class App {
    public static void main(String[] args) {
        //1.得到Spring的上下文 创建的时候需要配置Spring 配置信息
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从Spring中取出Bean对象
        //User user = (User) context.getBean("user");//根据bean 名称来得到Bean对象
        User user = context.getBean(User.class);// 根据bean类型获取 Bean
        //3.使用Bean(可选)
        System.out.println(user.sayHi());
    }
}
