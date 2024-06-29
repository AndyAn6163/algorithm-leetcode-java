package algorithm.leetcode.shortestpath;

import java.util.*;

public class LC2642DesignGraphWithShortestPathCalculator {

    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */

    class Graph {

        private List<List<List<Integer>>> adjacencyList = new ArrayList<>();

        public Graph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                // adjacencyList : 存放 node 相鄰關係的表，每個索引代表每個 node
                // adjacencyList 索引 0 的 list，代表儲存 from 0 to for any end 的邊
                // 例如索引 0 :  [[2, 5], [1, 2]]
                // 例如索引 1 :  [[2, 1]]
                // 例如索引 2 :  []
                // 例如索引 3 :  [[0, 3]]
                adjacencyList.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            System.out.println("edge = " + Arrays.toString(edge));
            List<Integer> edgeList = Arrays.asList(edge[1], edge[2]);
            adjacencyList.get(edge[0]).add(edgeList);
            System.out.println("adjacencyList = " + adjacencyList.toString());
        }

        public int shortestPath(int node1, int node2) {
            int n = adjacencyList.size();
            List<Integer> distances = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                distances.add(Integer.MAX_VALUE);
            }
            distances.set(node1, 0);
            System.out.println("distances = " + distances);

            // Priority queue to efficiently retrieve the node with the minimum distance
            PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(0)));
            List<Integer> priorityQueueElement = new ArrayList<>(n);
            // 索引 0 代表 cost 索引 1 代表 node1
            // 因為是從 node1 出發所以 node1 cost 為 0，索引 0 值為 0
            priorityQueueElement.add(0);
            priorityQueueElement.add(node1);
            priorityQueue.add(priorityQueueElement);
            System.out.println("priorityQueue = " + priorityQueue);

            while (!priorityQueue.isEmpty()) {

                System.out.println("===while====");

                List<Integer> current = priorityQueue.poll();
                int currentNode = current.get(1);
                int currentCost = current.get(0);
                System.out.println("current = " + current + " , currentCost = " + currentCost + " , currentNode = " + currentNode);

                // Skip if a shorter path has already been found
                if (currentCost > distances.get(currentNode)) {
                    System.out.println("skip");
                    continue;
                }

                // If found the target return the cost
                if (currentNode == node2) {
                    System.out.println("find");
                    return currentCost;
                }

                // Explore neighbors and update distances
                for (List<Integer> edge : adjacencyList.get(currentNode)) {
                    // 查閱 node3 的相鄰表，發現有 [0, 3]， node0 跟 length 3
                    int neighbor = edge.get(0);
                    int edgeLength = edge.get(1);
                    int newRouteCost = edgeLength + distances.get(currentNode);
                    System.out.println("neighbor = " + neighbor + " ,edgeLength = " + edgeLength + " ,newRouteCost = " + newRouteCost);

                    // Update distance if a shorter route is found
                    if (distances.get(neighbor) > newRouteCost) {
                        // 查閱 node0 的 distances 如果大於 newRouteCost，update node0 的值
                        distances.set(neighbor, newRouteCost);
                        System.out.println("update distances = " + distances);
                        List<Integer> priorityQueueElement2 = new ArrayList<>(n);
                        priorityQueueElement2.add(newRouteCost);
                        priorityQueueElement2.add(neighbor);
                        priorityQueue.add(priorityQueueElement2);
                        System.out.println("update priorityQueue = " + priorityQueue);
                    }
                }
            }

            // Return the minimum distance or -1 if no path exists
            return ((distances.get(node2) == Integer.MAX_VALUE) ? -1 : distances.get(node2));
        }
    }

    public static void main(String[] args) {
        // "Graph" 4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]
        int[][] edges = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        int[] edge = {1, 3, 4};

        LC2642DesignGraphWithShortestPathCalculator lc2642 = new LC2642DesignGraphWithShortestPathCalculator();

        System.out.println("============================================================");
        System.out.println("Question 1");
        System.out.println("============================================================");
        // Question 1
        // [4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]]
        Graph obj = lc2642.new Graph(4, edges);

        System.out.println("============================================================");
        System.out.println("Question 2");
        System.out.println("============================================================");
        // Question 2
        // return 6.
        // The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
        int question2 = obj.shortestPath(3, 2);
        System.out.println("question2 = " + question2);

        System.out.println("============================================================");
        System.out.println("Question 3");
        System.out.println("============================================================");
        // Question 3
        // return -1. There is no path from 0 to 3.
        int question3 = obj.shortestPath(0, 3);
        System.out.println("question3 = " + question3);

        System.out.println("============================================================");
        System.out.println("Question 4");
        System.out.println("============================================================");
        // Question 4
        // We add an edge from node 1 to node 3
        obj.addEdge(edge);

        System.out.println("============================================================");
        System.out.println("Question 5");
        System.out.println("============================================================");
        // Question 5
        // return 6.
        // The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
        int question5 = obj.shortestPath(0, 3);
        System.out.println("question5 = " + question5);
    }


}
