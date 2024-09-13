import jdk.nashorn.internal.ir.CaseNode;

import java.util.Scanner;
public class DeliveryRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[][] obstacleMap = new boolean[1000][1000];
        for (int i = 0; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            obstacleMap[x][y] =true;

        }
        int x = 0, y = 0;
        for (int i = 0; i < m; i++){
            String direction = scanner.next();
            int distance = scanner.nextInt();
            switch (direction){
                case "U":
                    for (int j = 1; j <= distance;j++){
                        if (!obstacleMap[x][y-j]){
                            y--;
                        }else {
                            break;
                        }
                    }
                    break;
                case "D":
                for (int j = 1; j <= distance;j++){
                    if (!obstacleMap[x][y+j]){
                        y++;
                    }else {
                        break;
                    }
                }
                break;
                case "L":
                for (int j = 1; j <= distance;j++){
                    if (!obstacleMap[x-j][y]){
                        x--;
                    }else {
                        break;
                    }
                }
                break;
                case "R":
                for (int j = 1; j <= distance;j++){
                    if (!obstacleMap[x+j][y]){
                        x++;
                    }else {
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(x + " " + y);
        scanner.close();
    }
}
