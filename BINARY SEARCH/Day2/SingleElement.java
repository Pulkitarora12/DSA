package Day2;

import java.util.Scanner;

public class SingleElement {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(helper(arr));
    }

    /* in an array the pairs will be in the form (i, i + 1) in which i % 2 == 0 if they lie before the single element
    and i % 2 == 1 if they lie after the single element
    means
        if odd, even => pair  -> after element
           even, odd => pair -> before element
     */
    public static int helper(int[] nums) {

        if (nums.length == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];

        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int start = 1;
        int end = nums.length - 2;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            if(mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                }
                else if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                }
            }

            else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                }
                else if (nums[mid] == nums[mid + 1]) {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}

//https://leetcode.com/problems/single-element-in-a-sorted-array/
