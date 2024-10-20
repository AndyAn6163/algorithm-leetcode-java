package algorithm.leetcode.binarysearchtree;

public class LC0278FirstBadVersion {

    class VersionControl {

        boolean isBadVersion(int version){
            /*
            version 4 以上版本都是錯的，所以 version > 3 都 return true

            Example 1:

            Input: n = 5, bad = 4
            Output: 4
            Explanation:
            call isBadVersion(3) -> false
            call isBadVersion(5) -> true
            call isBadVersion(4) -> true
            Then 4 is the first bad version.
             */
            return version > 3;
        };

    }

    /* The isBadVersion API is defined in the parent class VersionControl. boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {

            // 這個不是陣列，所以 left right 不是寫成 0 ~ array.length - 1
            int left = 1;
            int right = n;
            // 假設從 1 開始
            int badVersion = 1;

            while (left <= right){
                int mid = left + (right - left) / 2;
                System.out.printf("left = %d , right = %d , mid = %d %n", left, right, mid);
                if(isBadVersion(mid)){
                    System.out.printf("mid = %d is bad version %n", mid);
                    // update badVersion
                    badVersion = mid;
                    // 代表 mid 的右邊全部都是 badVersion，因此查詢範圍由 left ~ mid - 1
                    right = mid - 1;
                } else {
                    System.out.printf("mid = %d is not bad version %n", mid);
                    // 如果不是 badVersion，代表 mid 的右邊還有可能有好的 version，因此查詢範圍由 mid + 1 ~ left
                    left = mid + 1;
                }
                System.out.printf("=========================== %n");
            }

            // while 都跑完，表示找到最終的 badVersion
            return  badVersion;
        }
    }

    public static void main(String[] args) {
        LC0278FirstBadVersion lc0278FirstBadVersion = new LC0278FirstBadVersion();
        Solution solution = lc0278FirstBadVersion.new Solution();
        int result = solution.firstBadVersion(5);
        System.out.println(result);
    }
}
