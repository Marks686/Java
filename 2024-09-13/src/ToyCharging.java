import java.util.Scanner;

public class ToyCharging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int maxCount = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n){
            sum += a[end];
            while (sum > m){
                sum -= a[start];
                start++;
            }
            maxCount = Math.max(maxCount,end - start + 1);
            end++;
        }
        System.out.println(maxCount);
    }
}
