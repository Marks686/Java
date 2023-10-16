/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-16
 * Time: 13:23
 */
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你心里所想数除以3的余数：");
        int a = sc.nextInt();
        System.out.print("请输入你心里所想数除以5的余数：");
        int b = sc.nextInt();
        System.out.print("请输入你心里所想数除以7的余数：");
        int c = sc.nextInt();
        System.out.println("让我想想...");
        int d=70*a+21*b+15*c;
        while(d>105){
            d=d-105;
        }
        System.out.print("你心里想的数是"+d);
    }
}
