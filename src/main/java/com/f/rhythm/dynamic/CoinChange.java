package com.f.rhythm.dynamic;

/**
 * created by f at 3/28/21 18:55
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{5, 2, 7}, 6));
    }

    public static int coinChange(int[] arr, int m) {
        int[] f = new int[m + 1];
        f[0] = 0;

        int i, j;
        for (i = 1; i <= m; ++i) {
            f[i] = Integer.MAX_VALUE;
            // f[x] = min([arr[0]+1,...arr[n-1]+1)
            for (j = 0; j < arr.length; ++j) {
                if (i >= arr[j] && f[i - arr[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - arr[j]] + 1, f[i]);
                }
            }
        }

        if (f[m] == Integer.MAX_VALUE) {
            f[m] = -1;
        }
        return f[m];
    }
}
