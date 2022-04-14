package com.hzh.class05;

/*// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
//前缀和 + 归并排序 + 滑动窗口
区间和的个数
*/
public class Code01_CountOfRangeSum_01 {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null ) {
            return 0;
        }
            //计算nums的所有数的累加和
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        return process(sum, 0, sum.length - 1, lower, upper);
    }

    public static int process(long[] sum, int L, int R, int lower, int upper) {

        if (L == R) {
            if (sum[L] >= lower && sum[R] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = L + ((R - L) >> 1);
        return process(sum, L, mid, lower, upper)
                + process(sum, mid + 1, R, lower, upper)
                + merge(sum, L, mid, R, lower, upper)
                ;

    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {

        int res = 0;

        int windowL = L;
        int windowR = L;


        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }

            res += windowR - windowL;
        }

        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

}
