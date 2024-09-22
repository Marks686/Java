import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MagicAppleShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] weights = new int[n + 1];
        long[] prefixSum = new long[n + 1];
        Set<Long> sumSet = new HashSet<>();

        for(int i = 0; i <= n; i++){
            weights[i] = scanner.nextInt();
        }

        for(int i = 1; i <= n; i++){
            int w = scanner.nextInt();
            if (sumSet.contains(w)){
                System.out.println("YES");
            }else {
                for (int j = 1; j <= n; j++){
                    if (sumSet.contains(w + prefixSum[j])){
                        System.out.println("YES");
                        break;
                    }
                }
                if (i < q-1){
                    System.out.println("NO");
                }
            }
        }
        scanner.close();
    }
}
