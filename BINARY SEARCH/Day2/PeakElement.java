package Day2;

import java.util.Scanner;

public class PeakElement {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(helper(arr));
    }

    public static int helper(int[] nums) {

        if (nums.length == 1) return 0;

        if (nums[0] > nums[1]) return 0;

        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int start = 1;
        int end = nums.length - 2;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;

            else if (nums[mid] < nums[mid - 1]) end = mid - 1;

            else start = mid + 1;
        }

        return -1;
    }
}

//https://leetcode.com/problems/find-peak-element/description/
