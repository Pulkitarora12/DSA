package Day3;

import java.util.Scanner;

public class MakeMBouquet {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] bloomDay = new int[n];

        for (int i = 0; i < n; i++) {
            bloomDay[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        if (bloomDay.length < m * k) {
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int start = min;
        int end = max;
        int ans = max + 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            int freq = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {

                if (bloomDay[i] <= mid) {
                    freq++;
                } else {
                    freq = 0;
                }

                if (freq == k) {
                    count++;
                    freq = 0;
                }
            }

            if (count >= m) {
                ans = Math.min(mid, ans);
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        System.out.println(ans == max + 1 ? -1 : ans);
    }
}


//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/