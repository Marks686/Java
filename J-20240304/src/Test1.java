/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-05
 * Time: 21:35
 */
class B {
    public B() {
        func();
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    @Override
    public void func() {
        System.out.println("D.func() " + num);
    }
}
public class Test1 {
    public static void main(String[] args) {
        D d = new D();
    }
}

