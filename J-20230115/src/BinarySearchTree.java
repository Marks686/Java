/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-06
 * Time: 19:16
 */
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode root = null;

    //查找二叉搜索数中指定的val值
    public TreeNode find(int val){
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == val){
                return cur;
            }else if (cur.val > val){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }
    //插入一个数据
    public void insert(int val){
        if (root == null){
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else if (cur.val > val){
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val < val){
            parent.right = node;
        }else {
            parent.left = node;
        }
    }

    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    //删除值为val的节点
    public void remove(int val){
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if (cur.val == val){
                removeNode(parent,cur);
                return;
            }else if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null){
            if (cur == root){
                root = cur.right;
            }else if (parent.left == cur){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        } else if (cur.right == null){
            if (cur == root){
                root = cur.left;
            }else if (parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left){
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

}
