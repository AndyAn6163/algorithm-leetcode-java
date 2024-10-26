package algorithm.leetcode.binarytree;

import algorithm.leetcode.datastructure.TreeNode;

public class LC0572SubtreeOfAnotherTree {

    private TreeNode generateTest1Root() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode1;
        treeNode4.right = treeNode2;

        return treeNode3;
    }

    private TreeNode generateTest1SubRoot() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode4.left = treeNode1;
        treeNode4.right = treeNode2;
        return treeNode4;
    }

    private TreeNode generateTest2Root() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode1;
        treeNode4.right = treeNode2;
        treeNode2.left = treeNode0;

        return treeNode3;
    }

    private TreeNode generateTest2SubRoot() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode4.left = treeNode1;
        treeNode4.right = treeNode2;
        return treeNode4;
    }

    /**
     * two-layer recursive
     * 1 layer : recursive for finding root node of subRoot tree
     * 2 layer : after finding root node of subRoot tree, starting to compare each node val between root tree and subRoot tree recursively
     */

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {

            // recursive 到 null 節點，代表在 root tree 中找不到節點的值與 subRoot tree 的 root 節點值相同，無法跑到 layer 2
            if (root == null) {
                return false;
            }

            // recursive 找到在 root tree 中有節點的值與 subRoot tree 的 root 節點值相同，因此從這個節點開始進行比較
            if (root.val == subRoot.val) {
                // isIdentical 是 layer 2 recursive，
                // 如果 recursive 完發現 root tree 和 subRoot tree 中每個節點值都相同，則回覆 true
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }

            // isIdentical 是 layer 2 recursive，
            // 如果 recursive 完發現 root tree 和 subRoot tree 中有節點值不一樣
            // 則跳過此 root tree 的節點，開始繼續往這個節點的右邊或左邊找例如

            /**
             * root tree
             *         3
             *     4     5
             *   1   2  n n
             *  n n n n
             * 假設跟 subRoot tree 比較
             *         5
             *        n n
             * 1. root tree 中 3 節點跟 subRoot tree root node 的值 5 比較出來不一樣
             * 2.   查找 節點.left 4 -> 不一樣
             * 3.       查找 節點.left.left 1 -> 不一樣
             * 4.           查找 節點.left.left.left null -> return false
             * 5.       查找 節點.left.right 2 -> 不一樣
             * 6.           查找 節點.left.right.left null -> return false
             * 7.       因為 節點.left.left false || 節點.left.right false -> 節點.left return false
             * 8.   查找 節點.right -> 一樣 return true
             * 9.   因為 節點.left false || 節點.left.right true -> 節點 return true
             */

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isIdentical(TreeNode root, TreeNode subRoot) {

        // layer 2 recursive
        // 如果 recursive 到最後 root tree 的節點跟 subRoot tree 節點都是 null，代表對過節點都相同，return true
        if (root == null && subRoot == null) {
            return true;
        }
        // 這裡
        // 狀況 1 root tree 跑到 null 節點，但 subRoot 沒有
        // 狀況 2 root tree 還沒跑完，但 subRoot 跑到 null 節點 (如 example 2)
        // 狀況 3 跑到一半以發現值不一樣
        else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        // 一直往節點的左邊跑到結束，如果最後答案是 false，代表樹不同，答案就是 false
        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }

        // 一直往節點的右邊跑到結束，如果最後答案是 false，代表樹不同，答案就是 false
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        /**
         * root tree
         *      5
         *     n  1
         *       n n
         * 假設跟 subRoot tree 比較
         *         5
         *        n n
         * 1. isIdentical(root.left = n, subRoot.left = n)
         * 2.   因為 root == null && subRoot == null -> return true
         * 3. isIdentical(root.right = 1, subRoot.right = n)
         * 4.   因為 subRoot == null -> return false
         * 5. 因為 isIdentical(root.right = 1, subRoot.right = n) return false
         * 6. -> return false
         *
         */

        return true;

    }

    public static void main(String[] args) {
        LC0572SubtreeOfAnotherTree lc0572 = new LC0572SubtreeOfAnotherTree();
        Solution solution = lc0572.new Solution();
        boolean testResult1 = solution.isSubtree(lc0572.generateTest1Root(), lc0572.generateTest1SubRoot());
        boolean testResult2 = solution.isSubtree(lc0572.generateTest2Root(), lc0572.generateTest2SubRoot());
        System.out.println(testResult1);
        System.out.println(testResult2);
    }
}
