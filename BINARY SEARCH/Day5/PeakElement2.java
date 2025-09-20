package Day5;

import java.util.Scanner;

public class PeakElement2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int start = 0;
        int end = m - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            int row = findMax(mat, mid, n);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                System.out.println(row + " " + mid);
                break;
            }

            else if (mat[row][mid] < left) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

    }

    public static int findMax(int[][] mat, int col, int n) {

        int max = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                ans = i;
            }
        }

        return ans;
    }
}

//use same approach as peak element 1
//find the col using that approach
//then  find the max el in that col

