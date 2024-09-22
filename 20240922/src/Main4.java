import java.security.DigestException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 9){
            System.out.println(n);
            return;
        }

        int digits = (int)Math.log10(n) + 1;
        int start = (int) Math.pow(10,digits - 1);
        int num = start;

        while (true){
            int digitSum = getDigitSum(num);
            if (digitSum >= n){
                System.out.println(num);
                break;
            }
            num++;
        }
    }


    private static int[] digitSums;

    static {
        digitSums = new int[1000001];
        for (int i = 1; i < digitSums.length; i++){
            digitSums[i] = digitSums[i/10] + i % 10;
        }
    }


    public static int getDigitSum(int num){
        return digitSums[num];
    }
}
