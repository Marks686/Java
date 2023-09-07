/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-06
 * Time: 19:15
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(12);
        binarySearchTree.insert(21);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(9);

        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        BinarySearchTree.TreeNode ret = binarySearchTree.find(12);
        System.out.println(ret.val+" ");
        System.out.println("========================");


        binarySearchTree.remove(12);
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
    }
}
