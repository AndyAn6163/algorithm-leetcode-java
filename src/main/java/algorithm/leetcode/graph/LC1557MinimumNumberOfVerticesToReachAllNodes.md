# LC1557MinimumNumberOfVerticesToReachAllNodes

## Hint

1. Hint 1

   A node that does not have any incoming edge can only be reached by itself.
   例如 [[0,1],[0,2],[2,5],[3,4],[4,2]]，代表 1,2,5,4 可以被其他 vertices 造訪，
   但 0,3 不行，因此只要找到沒有人能造訪的 vertices 即可

2. Hint 2

   Any other node with incoming edges can be reached from some other node.

3. Hint 3

   We only have to count the number of nodes with zero incoming edges.

## Solution

1. Solution 1

   https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/solutions/3537551/simple-sol-daily-leetcoding-challenge-may-day-18-java/