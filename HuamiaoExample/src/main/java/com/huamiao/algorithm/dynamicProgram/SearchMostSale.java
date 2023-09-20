package com.huamiao.algorithm.dynamicProgram;

import java.util.Arrays;
import java.util.Comparator;

public class SearchMostSale {

    public static void main(String[] args) {
        int[] start = new int[]{1,2,3,3};
        int[] end = new int[]{3,4,5,6};
        int[] profits = new int[]{50,10,40,70};
        SearchMostSale dynimic = new SearchMostSale();
        System.out.println(dynimic.findMast(start, end, profits));

    }

    public int findMast(int[] start, int[] end, int[] profits){
        int length = start.length;

        int[][] jobs = new int[length][];
        for (int i = 0; i < length; i++) {
            jobs[i] = new int[]{start[i], end[i], profits[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            int k = binarySearch(jobs, i-1, jobs[i-1][0]);
            dp[i] = Math.max(dp[i-1], dp[k] + jobs[i - 1][2]);
        }

        return dp[length];
    }

    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while(left < right){
            int mid = (left + right)/2;
            if (jobs[mid][1] > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}