package BinarySearch.BS2DArrsy;
/*
LeetCode 240: Search a 2D Matrix II

Problem Statement:
You are given an m x n integer matrix where:
- Each row is sorted in ascending order from left to right.
- Each column is sorted in ascending order from top to bottom.

Given an integer target, return true if target is found in the matrix,
otherwise return false.

You must design an algorithm with O(m + n) time complexity.
*/

public class _3searchMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;      // move down
            } else {
                col--;      // move left
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        _3searchMatrix2 sm = new _3searchMatrix2();

        int[][] matrix = {
                {1,  4,  7, 11, 15},
                {2,  5,  8, 12, 19},
                {3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 5;

        System.out.println("Target found: " + sm.searchMatrix(matrix, target));
    }
}

