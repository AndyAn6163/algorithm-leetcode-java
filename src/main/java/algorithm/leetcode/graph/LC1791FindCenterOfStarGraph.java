package algorithm.leetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1791FindCenterOfStarGraph {

    public int[][] generateTest1(){
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        return edges;
    }

    public static void main(String[] args) {

        LC1791FindCenterOfStarGraph lc1791 = new LC1791FindCenterOfStarGraph();
        Solution solution = lc1791.new Solution();

        int result = solution.findCenter(lc1791.generateTest1());
        System.out.println("result = " + result);
    }

    class Solution {
        public int findCenter(int[][] edges) {

            Set<Integer> setCounter = new HashSet<>();

            for (int[] edge : edges) {
                System.out.printf("edge = %s, edge[0] = %d, edge[1] = %d%n", Arrays.toString(edge), edge[0], edge[1]);
                if (setCounter.contains(edge[0])) {
                    return edge[0];
                }
                if (setCounter.contains(edge[1])) {
                    return edge[1];
                }
                setCounter.add(edge[0]);
                setCounter.add(edge[1]);
            }
            return -1;
        }
    }
}


