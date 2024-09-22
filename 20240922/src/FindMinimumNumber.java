import java.util.Scanner;

public class FindMinimumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 9){
            System.out.println(n);
            return;
        }

        int num = 10;
        while (true){
            int digitSum = getDigitSum(num);
            if (digitSum >= n){
                System.out.println(num);
                break;
            }
            num++;
        }
    }
    public static int getDigitSum(int num){
        int sum = 0;
        while (num>0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
