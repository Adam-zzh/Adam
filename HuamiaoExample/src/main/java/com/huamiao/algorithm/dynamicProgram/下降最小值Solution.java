package com.huamiao.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/8/10
 * @since 1.0.0
 */
public class 下降最小值Solution {

    public static void main(String[] args) {
        int[][] grids = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minSumVal(grids));
    }
    static int minSumVal(int[][] grids){
        int n = grids.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = grids[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + grids[i][k]);
                }

            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ret = Math.min(ret, dp[n-1][i]);
        }
        return ret;
    }
}