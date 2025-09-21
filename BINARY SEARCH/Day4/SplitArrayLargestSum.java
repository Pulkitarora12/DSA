package Day4;

import java.util.Scanner;

import static java.lang.System.in;

public class SplitArrayLargestSum {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
    }

    //we need to find the maximum posisble sum
    //so we traverse through all the possible sums
    //in order add every element into some subarray, the subarray sum must atleast be equal to the larget element
    //and the largest possible subarray is the array itself
    public static int helper(int[] arr, int k) {

        int max = 0;
        int total = 0;

        for (int num : arr) {

            max = Math.max(max, num);
            total += num;
        }

        int start = max;
        int end = total;
        int ans = 0;

        while (start <= end) {

            int mid = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int num : arr) {

                if (sum + num <= mid) {
                    sum += num;
                } else {
                    count++;
                    sum = num;
                }

                if (count > k) {
                    break;
                }
            }

            //why is  < also a valid case
            //since count is less than k means we had a subarray with sum <= mid which can be further broker to increase the count
            //without disturbing the max sum
            if (count <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

