package Day2;

import java.util.Scanner;

public class MinimumElementInRotatedArray {

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

        int start = 0;
        int end = nums.length - 1;
        int smallest = Integer.MAX_VALUE;

        while (start <= end) {

            int mid = (start + end) / 2;

            //if we have mid greater than the start, means we are in the first half which has the rotated smallest element
            // at the start, so we'll look for any smaller element after the first half
            if (nums[mid] >= nums[start]) {
                smallest = Math.min(smallest, nums[start]);
                start = mid + 1;
            }

            //if we have mid smaller than start means mid is in the second half, so we'll look for any smaller element than mid
            //into its left
            else {
                smallest = Math.min(smallest, nums[mid]);
                end = mid - 1;
            }
        }

        return smallest;
    }
}
