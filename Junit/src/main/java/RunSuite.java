import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-01
 * Time: 19:58
 */
@Suite
// 通过class测试用例运行
//@SelectClasses({JunitTest03.class,JunitTest.class,JunitTest01.class})
@SelectPackages(value = {"Test09","Test08"})
public class RunSuite {
}
