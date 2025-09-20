import java.util.*;

import static java.lang.System.in;

public class SearchInsertPosition {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(searchInsertPosition(arr, target));
    }

    public static int searchInsertPosition(int[] arr, int target) {
        // code here

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans == -1 ? arr.length : ans;
    }
}

//https://leetcode.com/problems/search-insert-position/description/
