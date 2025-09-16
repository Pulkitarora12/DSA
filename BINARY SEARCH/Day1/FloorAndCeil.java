import java.util.*;

import static java.lang.System.in;

public class FloorAndCeil {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] ans = new int[2];
        int target = sc.nextInt();

        ans[0] = ceil(arr, target);
        ans[1] = floor(arr, target);
    }

    public static int ceil(int[] nums, int x) {

        int start = 0;
        int end = nums.length - 1;
        int ceil = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceil;
    }

    public static int floor(int[] nums, int x) {

        int start = 0;
        int end = nums.length - 1;
        int floor = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return floor;
    }
}