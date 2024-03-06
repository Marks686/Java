import binarysearchtree.BinarySearchTree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-06
 * Time: 19:35
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,12,3,2,11,15};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println("--");
        System.out.println(binarySearchTree.search(2));
    }


}
