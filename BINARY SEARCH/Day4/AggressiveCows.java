package Day4;

import java.util.*;

public class AggressiveCows {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(stalls);

        int start = 1;  //min diff between any two stalls;
        int end = stalls[n - 1] - stalls[0];  //max diff between any two stalls;

        int ans = 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            //we need to check at every minimum distance we can maintain which will give us the max ans

            int prev = 0;
            int minDiff = Integer.MAX_VALUE;
            int count = 0;

            for (int i = 1; i < n; i++) {
                if (stalls[i] - stalls[prev] >= mid) {
                    minDiff = Math.min(minDiff, stalls[i] - stalls[prev]);
                    prev = i;
                    count++;
                }
            }

            if (count >= k) {   //we will find the maximum distance at which we can place all the k cows
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(ans);
    }
}

//https://www.geeksforgeeks.org/problems/aggressive-cows/1
