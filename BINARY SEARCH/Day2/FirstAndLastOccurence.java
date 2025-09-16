package Day2;

import java.util.*;

import static java.lang.System.in;

public class FirstAndLastOccurence {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(firstOcc(arr, target) + " " + secOcc(arr, target));
    }

    public static int firstOcc(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int first = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                end = mid - 1;
                first = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return first;
    }

    public static int secOcc(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int sec = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                sec = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return sec;
    }

}
