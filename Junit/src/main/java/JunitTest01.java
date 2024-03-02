import org.junit.jupiter.api.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-01
 * Time: 18:54
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class JunitTest01 {
    @Order(3)
    @Test
    void Test01(){
        System.out.println("Test01测试用例");
    }
//    @Disabled
    @Order(4)
    @Test
    void Test02(){
        System.out.println("Test02测试用例");

    }
    @Order(1)
    @Test
    void A(){
        System.out.println("A");
    }
    @Order(2)
    @Test
    void B(){
        System.out.println("B");
    }
//    @BeforeAll
//    static void SetUp(){
//        System.out.println("SetUp方法");
//    }
//    @AfterAll
//    static void TearDown(){
//        System.out.println("TearDown方法");
//    }
//    @BeforeEach
//    void BeforeEachTest(){
//        System.out.println("BeforeEachTest方法");
//    }
//    @AfterEach
//    void AfterEachTest(){
//        System.out.println("AfterEachTest方法");
//    }
}
