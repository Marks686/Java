import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-12
 * Time: 22:09
 */
public class JunitTest {
    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(1,"张三"),
            Arguments.arguments(2,"李四"),
            Arguments.arguments(3,"王五")
        );
    }

    @Test
    void Test01(){
        System.out.println("这是JunitTest里面的Test01");
    }
    @Test
    void Test02(){
        System.out.println("这是JunitTest里面的Test02");
    }
    @Disabled
    void Test03(){
        System.out.println("这是JunitTest里面的Test03");
    }
    @BeforeAll
    static void SetUp(){
        System.out.println("这是我们BeforeAll里面的语句");
    }
    @AfterAll
    static void TearDown(){
        System.out.println("这是AfterAll里面的语句");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void Test04(int num){
        System.out.println(num);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test01.csv")
       void Test06(String name){
        System.out.println(name);
    }

    @ParameterizedTest
    @MethodSource("Generator")
    void Test07(int num, String name){
        System.out.println(num + ":" + name);
    }
}
