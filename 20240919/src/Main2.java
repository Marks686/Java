
import java.util.Scanner;

public class Main2 {
    public static String canFinllBox(int i, int[] toys, int fillers, int capacity){
        int totalToySize = 0;
        for(int toySize : toys){
            totalToySize += toySize;
        }
        if (totalToySize + fillers == capacity){
            return "YES";
        }else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i =0; i <t; i++){
            int capacity = scanner.nextInt();
            int n = scanner.nextInt();
            int fillers = scanner.nextInt();
            int[] toys = new int[n];
            for (int j = 0; j < n; j++){
                toys[j] = scanner.nextInt();
            }
//            System.out.println(canFinllBox(n,toys,fillers,capacity));
            System.out.println("YES");
            System.out.println("NO");
        }
        scanner.close();
    }
}
