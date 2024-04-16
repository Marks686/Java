import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5,2,7,4,1,3,8,9};
        bubble(a);
        System.out.println(Arrays.toString(a));
    }
    public static void bubble(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            boolean m = false;
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] > a[j+1]){
                    swap(a,j,j+1);
                    m = true;
                }
            }
            if (!m){
                break;
            }
        }
    }

    private static void swap(int[] a, int j, int i) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
