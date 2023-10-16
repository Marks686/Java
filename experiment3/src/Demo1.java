/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-16
 * Time: 13:22
 */
import java.util.Arrays;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a = new int[]{1,2,3,4,5,6,7,8};
        int n=a.length;
        System.out.println("请输入后移位数：");
        int k = sc.nextInt();
        XHHY(a,n,k);
        System.out.println(Arrays.toString(a));
    }
    public static void Change(int[] a,int i,int j)
    {
        for(;i<j;i++,j--)
        {
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
    }
    //数组循环后移操作
    public static void XHHY(int[] a,int n,int k)
    {
        Change(a,0,n-k-1);//54321678
        Change(a,n-k,n-1);//54321876
        Change(a,0,n-1);//67812345
    }
}