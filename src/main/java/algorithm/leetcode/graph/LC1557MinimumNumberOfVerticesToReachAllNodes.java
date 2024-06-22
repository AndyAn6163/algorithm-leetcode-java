package algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1557MinimumNumberOfVerticesToReachAllNodes {

    public List<List<Integer>> generateTest1() {
        // Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
        // Output: [0,3]
        List<Integer> edge1 = Arrays.asList(0, 1);
        List<Integer> edge2 = Arrays.asList(0, 2);
        List<Integer> edge3 = Arrays.asList(2, 5);
        List<Integer> edge4 = Arrays.asList(3, 4);
        List<Integer> edge5 = Arrays.asList(4, 2);
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        System.out.println("generateTest1 edges = " + edges.toString());
        return edges;
    }

    public List<List<Integer>> generateTest2() {
        // Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
        // Output: [0,2,3]
        List<Integer> edge1 = Arrays.asList(0, 1);
        List<Integer> edge2 = Arrays.asList(2, 1);
        List<Integer> edge3 = Arrays.asList(3, 1);
        List<Integer> edge4 = Arrays.asList(1, 4);
        List<Integer> edge5 = Arrays.asList(2, 4);
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        System.out.println("generateTest2 edges = " + edges.toString());
        return edges;
    }

    public static void main(String[] args) {

        LC1557MinimumNumberOfVerticesToReachAllNodes lc1557 = new LC1557MinimumNumberOfVerticesToReachAllNodes();
        Solution solution = lc1557.new Solution();

        List<Integer> result1 = solution.findSmallestSetOfVertices(6, lc1557.generateTest1());
        List<Integer> result2 = solution.findSmallestSetOfVertices(5, lc1557.generateTest2());


        System.out.println("result.toString() = " + result1.toString());
        System.out.println("result.toString() = " + result2.toString());
    }

    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            List<Integer> list = new ArrayList<>();
            // boolean -> default 0, Boolean -> default null
            // 所以沒有指定成 true 的 index, 都會是放 0, 因此都會是 false
            boolean[] booleanList = new boolean[n];
            for (List<Integer> edge : edges) {
                int i = edge.get(1);
                booleanList[i] = true;
            }

            for (int i = 0; i < n; i++) {
                if (booleanList[i] == false) {
                    list.add(i);
                }
            }
            return list;
        }

        /* Time Limit Exceeded
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(i);
            }

            for(List<Integer> edge : edges){
                list.remove(edge.get(1));
            }
            return list;
        }
         */

    }
}




