package Day5;

import java.util.Scanner;

public class RowsWithMaxOnes {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = -1;
        int max = 0;

        for (int i = 0; i < n; i++) {

            int start = 0;
            int end = m - 1;

            while (start <= end) {

                int mid = (start + end) / 2;

                if (arr[i][mid] == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            int count = arr[0].length - end;

            if (count > max) {
                ans = i;
                max = count;
            }
        }

        System.out.println(ans);
    }
}
