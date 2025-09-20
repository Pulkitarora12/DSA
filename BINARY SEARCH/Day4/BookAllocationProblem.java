package Day4;

import java.util.Scanner;

public class BookAllocationProblem {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }


        //we are traversing between the number of pages at which we can pick books
        int start = max;   //so that each book can be allocated
        int end = sum;

        while (start <= end) {

            int mid = (start + end) / 2;

            int student = 1;
            int currSum = 0;

            for (int i = 0; i < n; i++) {
                if (currSum + arr[i] <= mid) {
                    currSum += arr[i];
                } else {
                    student++;
                    currSum = arr[i];
                }
            }

            if (student <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}

// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
