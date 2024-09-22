
import java.util.Scanner;

public class Main {
    public static int findMinNUmber(int n){
        if (n > 9){
            return n;
        }

        int num = 1;
        int digitSum = 1;

        while (digitSum < n){
            num *= 10;
            digitSum += 9;
        }

        int remainder = n - (digitSum - 9);

        if (remainder <= 9){
            num += remainder;
        }else {
            num += 10;
            num += remainder - 10;
        }

        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findMinNUmber(n));
        scanner.close();
    }
}
