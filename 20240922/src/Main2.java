import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] appleWeights = new int[n];
        for(int i = 0; i < n; i++){
            appleWeights[i] = scanner.nextInt();
        }

        for (int i =0; i < q; i++){
            int w = scanner.nextInt();
            boolean found = false;
            for (int l = 1; l <= n; l++){
                for (int r = l; r <= n; r++){
                    int totalWeight = 0;
                    for (int j = l -1; j < r; j++){
                        totalWeight += appleWeights[j];
                    }

                    if (totalWeight == w){
                        found = true;
                        break;
                    }
                }
                if (found){
                    System.out.println("Yes");
                    break;
                }
            }
            if (!found){
                System.out.println("No");
            }
        }
        scanner.close();
    }
}
