package Day2;

import java.util.Scanner;

public class SearchInARotatedSortedArray2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(helper(arr, target));
    }

    public static boolean helper(int[] nums, int target) {

        /*let first half be the part which comes to the begining after rotation
        and let second half me the part which goes to end after rotating
        ex " 1 2 3 4 5 6
            4 5 6 1 2 3 => 4 5 6(first half) 1 2 3(second half)
         */

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) return true;

            //if this condition satisfies, we wont be able to identify the sorted part;
            if (nums[mid] == nums[start] && nums[start] == nums[end]) {
                start++;
                end--;
            }

            //the first task is to identify which half is rotated
            //if nums[start] <= nums[mid] => first half is sorted
            //if nums[start] >= nums[mid] => second half is sorted

            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) { //means target is in the first half
                    end = mid - 1;
                } else {
                    start = mid + 1;  //means target is either smaller than start or greated than end
                }
            }

            else {
                if (target <= nums[end] && target >= nums[mid]) {//means target is in the second half
                    start = mid + 1;
                } else {
                    end = mid - 1;  //means target is either greater than end or smaller than mid
                }
            }
        }

        return false;
    }
}

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
