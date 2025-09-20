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

        Arrays.sort(stalls);  //since we need to find the max difference this is better

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, stalls[i]);
        }

        //we will be checking for all the possible differences, the min one possible will be the answer

        int start = 1;  //this could be the possible minimum difference between any two stalls
        int end = max - stalls[0]; //this could be the maximum difference between any two stalls

        int ans = 0;
        int count = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            int minDiff = Integer.MAX_VALUE;
            int prev = 0;

            for (int i = 0; i < n - 1; i++) {
                if (stalls[i] - stalls[prev] >= mid) {
                    minDiff = Math.min(minDiff, stalls[i] - stalls[prev]);
                    prev = i;
                    count++;
                }
            }

            if (stalls[n - 1] - stalls[prev] >= mid) {
                minDiff = Math.min(minDiff, stalls[n - 1] - stalls[prev]);
                count++;
            }

            if (count >= k) { //if that much cows can be arranged with particular max diff we check for higher diff
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
