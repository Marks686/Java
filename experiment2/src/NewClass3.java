import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-09
 * Time: 12:59
 */
public class NewClass3 {
    public static void main(String[] args) {
        int[] arr = {1,2,9,3,4,5,6,7,8};
        int[] res = bubble(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }
}
