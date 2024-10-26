package algorithm.leetcode.datastructure;

public class TreeNode {

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

    /**
     * 原本存取修飾子是 deafult (no modifier)，同一個package內的類別都可以存取，不同package存取不到
     * 為了統一，將資料結構統一放入 package algorithm.leetcode.datastructure
     * 但其他程式碼是存放在其他 package，所以當其他 package 的程式碼要 import 這個 package 存放的資料結構
     * 會無法進行構造函數宣告以及使用成員變數，因此要全部修改成 public
     */

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


