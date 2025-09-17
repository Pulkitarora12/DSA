package Day3;

import java.util.Scanner;

public class KokoEatingBanana {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        int h = sc.nextInt();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int start = 1;
        int end = max;  //because h >= length
        long ans = Integer.MAX_VALUE;

        while (start <= end) {

            int mid = (start + end) / 2;
            long currCount = 0;

            for (int i = 0; i < piles.length; i++) {

                currCount += (piles[i] + mid - 1) / mid;
            }

            if (currCount <= h) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        System.out.println((int)ans);


    }
}
