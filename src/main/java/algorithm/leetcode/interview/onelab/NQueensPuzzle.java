package algorithm.leetcode.interview.onelab;

import java.util.Arrays;
import java.util.Scanner;

public class NQueensPuzzle {

    int solutionCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the N-Queens Puzzle size which you want to solve : ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.printf("Output of %d-Queens Puzzle : %n%n", n);
        NQueensPuzzle nQueensPuzzle = new NQueensPuzzle();
        nQueensPuzzle.solveNQueensPuzzle(n);
    }

    public void solveNQueensPuzzle(int n) {
        int[] solution = new int[n];
        solveNQueensPuzzleUsingBackTrack(0, n, solution);
    }

    private void solveNQueensPuzzleUsingBackTrack(int row, int n, int[] solution) {
        if (row == n) {
            solutionCounter++;
            formatSolution(solution, solutionCounter);
        } else {
            for (int i = 0; i < n; i++) {
                solution[row] = i;
                if (checkDistinct(row, solution)) {
                    solveNQueensPuzzleUsingBackTrack(row + 1, n, solution);
                }
            }
        }
    }

    private boolean checkDistinct(int row, int[] solution) {
        for (int i = 0; i < row; i++) {
            if ((solution[row] == solution[i]) || (row - i == Math.abs(solution[row] - solution[i]))) {
                return false;
            }
        }
        return true;
    }

    private void formatSolution(int[] solution, int solutionCounter) {
        System.out.println("//Solution " + solutionCounter);
        for (int i = 0; i < solution.length; i++) {
            char[] row = new char[solution.length];
            Arrays.fill(row, '.');
            row[solution[i]] = 'Q';
            System.out.println(row);
        }
        System.out.printf("%n%n");
    }
}