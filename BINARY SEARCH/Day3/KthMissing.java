package Day3;

import java.util.*;

public class KthMissing {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] - (mid + 1) < k) {  //we find for the index at which the missing elements are equal to k
                start = mid + 1;
            }

            else {   //even if missing elements = k, we find the lowest index at which it is possible
                end = mid - 1;
            }
        }

        int remaining = k - (arr[end] - (end + 1));   //loop ends when end is before start
        int ans = arr[end] + remaining;

        //since end can be -1
        ans = k + end + 1;  //start = end + 1
        ans = k + start;

        System.out.println(ans);

    }
}
