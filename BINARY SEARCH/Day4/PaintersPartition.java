package Day4;

import java.util.Scanner;

import static java.lang.System.in;

public class PaintersPartition {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(helper(arr, k));
    }

    public static int helper(int[] arr, int k) {

        int max = 0;
        int total = 0;

        for (int num : arr) {

            max = Math.max(max, num);
            total += num;
        }

        int start = max;
        int end = total;

        while (start <= end) {

            int mid = (start + end) / 2;
            int count = 1;
            int hrs = 0;

            for (int num : arr) {

                if (hrs + num <= mid) {
                    hrs += num;
                } else {
                    count++;
                    hrs = num;
                }

                if (count > k) {
                    break;
                }
            }

            if (count <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
