/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-23
 * Time: 12:39
 */
public class Demo1 {
    //兔子繁殖问题
    public static void main(String[] args) {
        int a=1,b=1;
        System.out.println("一年中，每个月的兔子对数分别为：");
        System.out.println(a);
        System.out.println(b);
        for(int i=1;i<=5;i++){
            a = a+b;
            b = a+b;
            System.out.println(a);
            System.out.println(b);
        }
    }

    public static void main2(String[] args) {
        int a=1,b=1;
        int c;
        System.out.println("一年中，每个月的兔子对数分别为：");
        System.out.println(a);
        System.out.println(b);
        for(int i=1;i<=10;i++){
            c = a +b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}

