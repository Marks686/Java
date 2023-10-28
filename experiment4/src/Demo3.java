import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-23
 * Time: 12:40
 */
public class Demo3 {
    //牛顿迭代法
    public static void main(String[] args) {
        double fx;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入系数a,b,c,d:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        fx = f(a,b,c,d);
        System.out.println("方程的根为："+fx);
    }

    private static double f(double a, double b, double c, double d) {
        double x0,f0,f1,x1=1;
        do{
            x0 = x1;
            f0 = ((a * x0 + b) * x0 + c) * x0 + d;
            f1 = (3 * a * x0 + 2 * b) * x0 + c;
            x1 = x0 - f0/f1;
        }while(abs(x1-x0)>=1e-4);
        return x1;
    }

}