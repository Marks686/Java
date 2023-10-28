/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-23
 * Time: 12:40
 */
public class Demo2 {
    //猴子吃桃问题
    public static void main(String[] args) {
        int a = 1;
        for(int i=9;i>=1;i--){
            a = (a+1)*2;
        }
        System.out.println("原来有"+a+"个桃子");
    }
}