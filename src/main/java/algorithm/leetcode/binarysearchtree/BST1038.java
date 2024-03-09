package algorithm.leetcode.binarysearchtree;

public class BST1038 {

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

    class Solution {

        /*
            4 right 6 right 7  right 8
                               left  null
                    6 left  5  right null
                               left  null
            4 right-> 6 right-> 7 right-> 8 right-> null
            8 sum 8
            8 left-> null
            7 sum 15
            7 left-> null
            6 sum 21
            6 left-> 5

            5 right-> null
            5 sum 26
            5 left-> null

            4 sum 30
            4 left-> 1

            1 right-> 2 right-> 3 right-> null
            3 sum 33
            3 left-> null

            2 sum 35
            2 left-> null

            1 sum 36
            1 left-> 0

            0 right-> null
            0 sum 36
            0 left-> null

            由左而右越加越多
            8
            8+7
            8+7+6
            8+7+6+5
            8+7+6+5+4
            8+7+6+5+4+3
            所以先全力往右，然後再慢慢往左把東西加回來

         */
        private int sum = 0;

        public TreeNode bstToGst(TreeNode root) {

            if (root == null) {
                System.out.println("node 值為 null，開始返回遞迴");
                return null;
            }

            System.out.printf("node 值為 %d，往 right %n", root.val);
            bstToGst(root.right);

            sum += root.val;
            System.out.printf("node: %d、sum: %d，指定該 root 為 %d %n",root.val, sum, sum);
            root.val = sum;

            System.out.println("往 left");
            bstToGst(root.left);
            return root;

        }
    }

    public static void main(String[] args) {
        BST1038 bst1038 = new BST1038();

        TreeNode treeNode3 = bst1038.new TreeNode(3);
        TreeNode treeNode8 = bst1038.new TreeNode(8);

        TreeNode treeNode0 = bst1038.new TreeNode(0);
        TreeNode treeNode2 = bst1038.new TreeNode(2, null, treeNode3);
        TreeNode treeNode5 = bst1038.new TreeNode(5);
        TreeNode treeNode7 = bst1038.new TreeNode(7, null, treeNode8);

        TreeNode treeNode1 = bst1038.new TreeNode(1, treeNode0, treeNode2);
        TreeNode treeNode6 = bst1038.new TreeNode(6, treeNode5, treeNode7);

        TreeNode treeNode4 = bst1038.new TreeNode(4, treeNode1, treeNode6);

        Solution solution = bst1038.new Solution();
        TreeNode treeNodeResult = solution.bstToGst(treeNode4);
        System.out.printf("result %d %n", treeNodeResult.val);
    }
}
