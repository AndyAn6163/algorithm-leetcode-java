package algorithm.leetcode.hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.Set;

public class HT128 {

    Logger logger = LogManager.getLogger(getClass());

    class Solution {
        public int longestConsecutive(int[] nums) {
            // 記錄所有迴圈紀錄中最大的 count 數
            // 如果陣列長度為 0 直接顯示 lengthMax = 0
            int lengthMax = 0;
            Set<Integer> hashSet = new HashSet<>();

            for (int num : nums) {
                // 先去掉重複值，hashSet 不會有重複值在 array
                hashSet.add(num);
                logger.info("hashSet= {}", hashSet);
            }

            logger.info("=========================");

            for (int num : hashSet) {
                int count = 1;
                int leftNum = num;
                int rightNum = num;
                logger.info("num= {}", num);
                logger.info("count= {}", count);

                // 這樣的做法會導致重複運算
                // 序列 0, 3, 7, 2, 5, 8, 4, 6, 0, 1
                // 3 不用看，因為 3 的左邊 2 存在，2 可以找右邊的值確認 2 3 連續
                // 同理 2 不用看，因為 2 的左邊 1 存在，1 可以找右邊的值確認 1 2 連續
                // 因此持續下去可以發現只需要看 0，0 能夠確保所有連續
                /*
                while (hashSet.contains(leftNum = leftNum - 1)) {
                    logger.info("leftNum= {}", leftNum);
                    count++;
                    logger.info("count= {}", count);
                }
                 */
                if (hashSet.contains(leftNum = leftNum - 1)) {
                    logger.info("leftNum= {} exists，continue", leftNum);
                    logger.info("=========================");
                    continue;
                }

                while (hashSet.contains(rightNum = rightNum + 1)) {
                    logger.info("rightNum= {}", rightNum);
                    count++;
                    logger.info("count= {}", count);
                }

                lengthMax = Math.max(lengthMax, count);
                logger.info("current lengthMax= {}, current count= {}", lengthMax, count);
                logger.info("=========================");

            }

            return lengthMax;
        }
    }

    public static void main(String[] args) {
        // The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        int[] nums = {100, 4, 200, 1, 3, 2};
        // The longest consecutive elements sequence is [0 1 2 3 4 5 6 7 8]. Therefore its length is 9.
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        HT128 ht128 = new HT128();
        Solution solution = ht128.new Solution();
        solution.longestConsecutive(nums2);

    }
}
