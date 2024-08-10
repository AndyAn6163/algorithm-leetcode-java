package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0046Permutations {

    public int[] generateTest1() {
        int[] nums = {1, 2, 3};
        return nums;
    }

    public int[] generateTest2() {
        int[] nums = {0, 1};
        return nums;
    }

    public int[] generateTest3() {
        int[] nums = {1};
        return nums;
    }

    /*
    1

    1 1 X
    1 2

    1 2 1 X
    1 2 2 X
    1 2 3

    1 2 3 O

    1 3

    1 3 1 X
    1 3 2

    1 3 2 O

    1 3 3 X

    2
    ....
     */

    class Solution {

        public List<List<Integer>> permute(int[] nums) {

            // result set
            List<List<Integer>> result = new ArrayList<>();

            // each path
            List<Integer> path = new ArrayList<>();


            // import backTracking
            backTracking(result, path, nums);
            // return result set
            return result;
        }

        public void backTracking(List<List<Integer>> result, List<Integer> path, int[] nums) {

            System.out.println("========================");
            System.out.println("backTracking scope start");
            System.out.println("========================");

            // 終止條件-超出邊界
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                System.out.printf("stop condition arrives, add path to result = %s %n", result);
                System.out.println("=========================");
                System.out.println("backTracking scope return");
                System.out.println("=========================");
                return;
            }

            // 遍歷
            for (int i = 0; i < nums.length; i++) {

            /*
            迭代條件
            i = 0, num[i] = 1, path = [1]

            -> 1backTracking scope start
            i = 0, num[i] = 1, path contains so continue and skip backtracking
            i = 1, num[i] = 2, path = [1, 2]

            -> 2backTracking scope start
            i = 0, num[i] = 1, path contains so continue and skip backtracking
            i = 1, num[i] = 2, path contains so continue and skip backtracking
            i = 2, num[i] = 3, path = [1, 2, 3]

            -> 3backTracking scope start
            stop condition arrives, add path to result = [[1, 2, 3]]
            -> 3backTracking scope return

            -> At 2backTracking
            remove, path = [1, 2]
            因為 for loop i++，i = 3，exit for loop
            -> 2backTracking scope return

            -> At 1backTracking
            remove, path = [1]
            因為 for loop i++，i = 2
            i = 2, num[i] = 3, path = [1, 3]

            -> 4backTracking scope start
            i = 0, num[i] = 1, path contains so continue and skip backtracking
            i = 1, num[i] = 2, path = [1, 3, 2]

            -> 5backTracking scope start
            stop condition arrives, add path to result = [[1, 2, 3], [1, 3, 2]]
            -> 5backTracking scope return

            -> At 4backTracking
            remove, path = [1, 3]
            因為 for loop i++，i = 2
            i = 2, num[i] = 3, path contains so continue and skip backtracking
            因為 for loop i++，i = 3，exit for loop
            -> 4backTracking scope return
            */

                if (path.contains(nums[i])) {
                    System.out.printf("i = %d, num[i] = %d, path contains so continue and skip backtracking %n", i, nums[i]);
                    continue;
                }

                path.add(nums[i]);
                System.out.printf("i = %d, num[i] = %d, path = %s %n", i, nums[i], path);

                backTracking(result, path, nums);
                path.remove(path.size() - 1);
                System.out.printf("remove, path = %s %n", path);
            }

            System.out.println("=========================");
            System.out.println("backTracking scope return");
            System.out.println("=========================");
        }
    }


    public static void main(String[] args) {
        LC0046Permutations lc0046 = new LC0046Permutations();
        Solution solution = lc0046.new Solution();
        List<List<Integer>> result1 = solution.permute(lc0046.generateTest1());
        System.out.println("*********************************************");
        List<List<Integer>> result2 = solution.permute(lc0046.generateTest2());
        System.out.println("*********************************************");
        List<List<Integer>> result3 = solution.permute(lc0046.generateTest3());
        System.out.println("*********************************************");
        System.out.printf("result1 = %s, result2 = %S, result3 = %s", result1, result2, result3);
    }
}
