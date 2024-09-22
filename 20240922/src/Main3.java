import jdk.management.cmm.SystemResourcePressureMXBean;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main3 {
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
            int left = 0;
            int right = 0;
            int sum = 0;
            while (right < n){
                sum += appleWeights[right];
                while (sum > w && left <= right){
                    sum -= appleWeights[left];
                    left++;
                }

                if (sum == w){
                    found = true;
                    break;
                }
                right++;
            }
            if (found){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
        scanner.close();
    }
}
