package algorithm.leetcode.binarysearchtree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {

    /*
        BST 中序遍歷一定是一個遞增序列
        () 表示節點的 value
        1. 7 <= (10) <= 15，加入，並往左右子樹查詢
        2. (5) <= 7，表示左邊子樹一定沒有 7，往右邊子樹看
        2.1 7 <= (7) <= 15，加入，並往左右子樹查詢
        3. 7 <= (15) <= 15，加入，並往左右子樹查詢
        3.1 (18) >= 15，表示右子樹一定沒有 15，往右邊子樹看，但右邊子樹為 null
     */

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        System.out.printf("本節點 value = %d %n", root.val);

        if (root.val < low) {
            System.out.printf("本節點 value = %d < low = %d，代表左邊子樹不會有大於 low 的，往右邊子樹查詢 %n", root.val, low);
            return rangeSumBST(root.right, low, high);

        }

        if (root.val > high) {
            System.out.printf("本節點 value = %d > high = %d，代表右邊子樹不會有小於 high 的，往左邊子樹查詢 %n", root.val, high);
            return rangeSumBST(root.left, low, high);
        }

        System.out.printf("本節點 value = %d 屬於 low = %d 到 high = %d 範圍，因此加總，並往左右子樹查詢 %n", root.val, low, high);
        return  root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

        // 記住每一次遞迴都要 return (if 裡面的記得 return)
    }
}

public class BST938 {


    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode18 = new TreeNode(18);

        TreeNode treeNode5 = new TreeNode(5, treeNode3, treeNode7);
        TreeNode treeNode15 = new TreeNode(15, null, treeNode18);
        TreeNode treeNode10 = new TreeNode(10, treeNode5, treeNode15);

        int low = 7;
        int high = 15;

        Solution solution = new Solution();
        int result = solution.rangeSumBST(treeNode10, low, high);
        System.out.println(result);
    }


}
