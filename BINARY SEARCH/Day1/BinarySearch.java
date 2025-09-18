import java.util.*;

import static java.lang.System.in;

public class BinarySearch {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int start = 0;
        int end = n - 1;

        boolean found = false;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println(mid + 1);
                found = true;
                break;
            }

            else if (arr[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        if (!found) System.out.println(-1);
    }
}

//https://leetcode.com/problems/binary-search/