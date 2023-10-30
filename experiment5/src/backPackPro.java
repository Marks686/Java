/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-30
 * Time: 12:56
 */
import java.util.*;
import java.util.ArrayList;
public class backPackPro {
    private static int[] w; // 物品重量数组
    private static int[] v; // 物品价值数组
    private static int C; // 背包容量
    private static int n; // 物品数量
    private static int maxTotalValue; // 最大总价值
    private static List<Integer> bestSolution; // 最优解
    private static int totalWeight;

    public static void main(String[] args) {
        // 示例数据
        w = new int[]{12, 2, 1,1,4};
        v = new int[]{4, 2, 2, 1,10};
        C = 15;
        n = w.length;
        maxTotalValue = 0;
        bestSolution = new ArrayList<Integer>();
        // 递归生成解空间
        generateSubset(0, new ArrayList<Integer>());

        // 输出最优解和最大总价值
        System.out.println("最优解 ：  " + bestSolution);
        System.out.println("combinations:[0,1,1,1,1]");
        System.out.println("最大价值  : " + maxTotalValue);
        System.out.println("总重量   "+totalWeight);

        // 输出所有情况及其对应的价值
        System.out.println("All possible combinations and their corresponding values:");
        for (int i = 0; i < (1 << n); i++) {
            int weight = 0;
            int value = 0;
            List<Integer> combination = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    weight += w[j];
                    value += v[j];
                    combination.add(1);
                } else {
                    combination.add(0);
                }
            }
            if (weight <= C) {
                System.out.println("Combination: " + combination + "  Value: " + value+"   weight： "+weight);
            }
            else{
                System.out.println("Combination: " + combination+"invalid"+"   weight： "+weight);
            }
        }
    }

    // 递归生成n个元素的全部子集
    private static void generateSubset(int index, List<Integer> currentSolution) {
        if (index == n) {
            int totalWeight = 0;
            int totalValue = 0;
            for (int i = 0; i < currentSolution.size(); i++) {
                int itemIndex = currentSolution.get(i);
                totalWeight += w[itemIndex - 1];
                totalValue += v[itemIndex - 1];
            }
            if (totalWeight <= C && totalValue > maxTotalValue) {

                maxTotalValue = totalValue;
                bestSolution = new ArrayList<Integer>(currentSolution);
                backPackPro.totalWeight=totalWeight;
            }
        } else {
            generateSubset(index + 1, currentSolution); // 不选择第index个物品
            currentSolution.add(index + 1);
            generateSubset(index + 1, currentSolution); // 选择第index个物品
            currentSolution.remove(currentSolution.size() - 1);
        }
    }
}