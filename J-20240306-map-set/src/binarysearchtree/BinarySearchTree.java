package binarysearchtree;

import sun.reflect.generics.tree.Tree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-06
 * Time: 19:35
 */
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode root;

    /**
     * 最好情况：完全二叉树O(logN)
     * 最坏情况：单
     * @param key
     * @return
     */
    public boolean search(int key){
        TreeNode cur = root;
        while (cur != null){
            if (cur.val < key){
                cur = cur.right;
            }else if (cur.val >key){
                cur = cur.left;
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean insert(int val){
        if (root == null){
            root = new TreeNode(val);
            return true;
        }

        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else if (cur.val >val){
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val > val){
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }
}
