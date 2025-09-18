package Day3;

import java.util.Scanner;

public class SmallestDivisor {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int threshold = sc.nextInt();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int start = 1;
        int end = max;
        int ans = max + 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;
            }

            if (sum <= threshold) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
