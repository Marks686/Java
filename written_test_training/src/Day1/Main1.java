package Day1;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int count = 0;
        for(int i = l; i <= r; i++){
            int tmp = i;
            while (tmp != 0){
                if(tmp % 10 == 2){
                    count++;
                }
                tmp /= 10;
            }
        }
        System.out.println(count);
    }
}