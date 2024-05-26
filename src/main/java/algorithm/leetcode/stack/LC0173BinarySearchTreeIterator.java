package algorithm.leetcode.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;

public class LC0173BinarySearchTreeIterator {

    private static final Logger logger = LogManager.getLogger(LC0173BinarySearchTreeIterator.class);

    public static void main(String[] args) {

        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode15 = new TreeNode(15, treeNode9, treeNode20);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7, treeNode3, treeNode15);

        BSTIterator bSTIterator = new BSTIterator(treeNode7);
        int param_1 = bSTIterator.next();    // return 3
        int param_2 = bSTIterator.next();    // return 7
        boolean param_3 = bSTIterator.hasNext(); // return True
        int param_4 = bSTIterator.next();    // return 9
        boolean param_5 = bSTIterator.hasNext(); // return True
        int param_6 = bSTIterator.next();    // return 15
        boolean param_7 = bSTIterator.hasNext(); // return True
        int param_8 = bSTIterator.next();    // return 20
        boolean param_9 = bSTIterator.hasNext(); // return False

        logger.info("result = {} : {} : {} : {} : {} : {} : {} : {} : {}",
                param_1, param_2, param_3, param_4, param_5, param_6, param_7, param_8, param_9);

        logger.info("=== second solution =======================");

        BSTIterator2 bstIterator2 = new BSTIterator2(treeNode7);
        int param_10 = bstIterator2.next();    // return 3
        int param_11 = bstIterator2.next();    // return 7
        boolean param_12 = bstIterator2.hasNext(); // return True
        int param_13 = bstIterator2.next();    // return 9
        boolean param_14 = bstIterator2.hasNext(); // return True
        int param_15 = bstIterator2.next();    // return 15
        boolean param_16 = bstIterator2.hasNext(); // return True
        int param_17 = bstIterator2.next();    // return 20
        boolean param_18 = bstIterator2.hasNext(); // return False

        logger.info("result = {} : {} : {} : {} : {} : {} : {} : {} : {}",
                param_10, param_11, param_12, param_13, param_14, param_15, param_16, param_17, param_18);
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

class BSTIterator {

    private static final Logger logger = LogManager.getLogger(BSTIterator.class);

    private Stack<Integer> treeNodeStack = new Stack<>();

    public BSTIterator(TreeNode root) {

        // Using In-Order Traversal
        inorderTraversal(root);

    }

    public void inorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            logger.info("treeNode: {}", treeNode.val);
            inorderTraversal(treeNode.right);
            treeNodeStack.push(treeNode.val);
            logger.info("treeNodeStack: {}", treeNodeStack);
            inorderTraversal(treeNode.left);

            /*
             inorderTraversal(treeNode.left);
             treeNodeStack.push(treeNode.val);
             inorderTraversal(treeNode.right);

             In-order Traversal 結果 : [3, 7, 9, 15, 20]
             但因為此資料結構是 FIFO，變成 NEXT 會先取 20，因此改用 reverse In-order Traversal
             reverse In-order Traversal 結果 : [20, 15, 9, 7, 3]
             */

        }

    }

    public int next() {
        return treeNodeStack.pop();
    }

    public boolean hasNext() {
        if (treeNodeStack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}

class BSTIterator2 {

    private static final Logger logger = LogManager.getLogger(BSTIterator2.class);

    // 因為無法一次紀錄完整的 traversal，因此 Stack 必須存的是 TreeNode
    private Stack<TreeNode> treeNodeStack2 = new Stack<>();

    public BSTIterator2(TreeNode root) {
        // Using Partial In-Order Traversal
        partialInorderTraversal(root);
    }

    public void partialInorderTraversal(TreeNode treeNode){
        if(treeNode!=null) {
            logger.info("treeNode2 : {}", treeNode.val);
            treeNodeStack2.push(treeNode);
            logger.info("treeNodeStack2 : {}", treeNodeStack2.stream().map(treeNode1 -> treeNode1.val).toList());
            partialInorderTraversal(treeNode.left);
        }
    }

    public int next() {
        logger.info("===== find next");
        TreeNode treeNode = treeNodeStack2.peek();
        treeNodeStack2.pop();
        logger.info("pop peak : {}", treeNode.val);
        partialInorderTraversal(treeNode.right);
        return treeNode.val;
    }

    public boolean hasNext() {
        if (treeNodeStack2.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */