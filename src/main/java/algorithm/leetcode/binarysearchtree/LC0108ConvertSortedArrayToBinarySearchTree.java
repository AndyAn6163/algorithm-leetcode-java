package algorithm.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0108ConvertSortedArrayToBinarySearchTree {

    private int[] generateTest1() {
        int[] nums = {-10, -3, 0, 5, 9};
        return nums;
    }

    private int[] generateTest2() {
        int[] nums = {1, 3};
        return nums;
    }

    public class TreeNode {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode resultTreeNode = createTreeNode(nums, 0, nums.length - 1);
            System.out.println("BinarySearchTree : " + LC0108ConvertSortedArrayToBinarySearchTree.printBinarySearchTreeByLevelOrderTraversal(resultTreeNode));
            return resultTreeNode;
        }

        public TreeNode createTreeNode(int[] nums, int left, int right) {

            // 終止條件
            if (left > right) {
                System.out.println("* terminal condition");
                return null;
            }

            // midpoint formula
            // left + (right - left)/2 = left + right/2 - left/2 = left/2 + right/2 = (left+right)/2
            // https://stackoverflow.com/questions/25113506/why-m-l-r-l-2-instead-of-m-lr-2-avoid-overflow-in-c
            int mid = left + (right - left) / 2;

            System.out.printf("create TreeNode, nums[%d] = %3d %n", mid, nums[mid]);
            TreeNode rootTreeNode = new TreeNode(nums[mid]);

            System.out.printf("rootTreeNode %3d,  left search start, range %2d ~ %2d %n", rootTreeNode.val, left, mid - 1);
            rootTreeNode.left = createTreeNode(nums, left, mid - 1);

            System.out.printf("rootTreeNode %3d, right search start, range %2d ~ %2d %n", rootTreeNode.val, mid + 1, right);
            rootTreeNode.right = createTreeNode(nums, mid + 1, right);

            return rootTreeNode;
        }
    }

    public static void main(String[] args) {
        LC0108ConvertSortedArrayToBinarySearchTree lc0108 = new LC0108ConvertSortedArrayToBinarySearchTree();
        Solution solution = lc0108.new Solution();
        solution.sortedArrayToBST(lc0108.generateTest1());
        System.out.println("**************************************************************************************************");
        solution.sortedArrayToBST(lc0108.generateTest2());

    }


    public static List<List<Integer>> printBinarySearchTreeByLevelOrderTraversal(TreeNode treeNode) {
        // https://leetcode.com/problems/binary-tree-level-order-traversal/description/
        // https://www.geeksforgeeks.org/level-order-tree-traversal/
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        if (treeNode == null) {
            return resultList;
        }

        while (true) {
            int queueSize = queue.size();
            if (queueSize == 0) {
                return resultList;
            }
            List<Integer> data = new ArrayList<>();
            while (queueSize > 0) {
                TreeNode temp = queue.poll();
                data.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                queueSize--;
            }
            resultList.add(data);
        }
    }


}
