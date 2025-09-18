package Day3;

import java.util.Scanner;

import static java.lang.System.in;

public class ShipPackagesWithinDdays {

    public static Scanner sc = new Scanner(in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        int days = sc.nextInt();

        int total = 0;
        int max = 0;

        for (int weight : weights) {
            total += weight;
            max = Math.max(max, weight);
        }

        int start = max;
        int end = total;
        int ans = total;

        while (start <= end) {

            int mid = (start + end) / 2;
            int sum = 0;
            int daysReq = 0;

            for (int i = 0; i < weights.length; i++) {

                if (sum + weights[i] <= mid) {
                    sum += weights[i];
                }

                else {
                    daysReq++;
                    sum = weights[i];
                }
            }

            daysReq++;

            if (daysReq <= days) {
                ans = mid;
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
