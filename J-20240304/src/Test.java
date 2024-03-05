import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-04
 * Time: 18:42
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,6,2,8,9};
        int b = binbinarySearchary(arr,9);
        System.out.println(b);
        bubbleSort(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j-1] > arr[j]){
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    private static int binbinarySearchary(int[] arr, int i) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (i < arr[mid]){
                right = mid - 1;
            }else if (i > arr[mid]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
