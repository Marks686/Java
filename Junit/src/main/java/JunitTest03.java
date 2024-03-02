import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-01
 * Time: 19:02
 */
public class JunitTest03 {
    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(
                "1,张三",
                "2,李四"
        ));
    }

    @ParameterizedTest//注册
    @ValueSource(ints = {1})
    void Test01(int num){
        System.out.println(num);
//        Assertions.assertEquals(1,num);
//        Assertions.assertNotEquals(2,num);
//        String str = "nulll";
        String str = null;
//        Assertions.assertNull(str);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, ''"})
    void Test02(String x, String y, int z, String q){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(q);
        System.out.println("======================================");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test02.csv")
    void Test03(int num,String name){
        System.out.println("学号:" + num + ",姓名:" + name);
    }

    @ParameterizedTest
    @MethodSource("Generator")
    void Test04(String num,String name){
        System.out.println(num + name);
    }
}
