import java.util.*;

import static java.lang.System.in;

//first index at which the value of element is  > the target
public class UpperBound {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(upperBound(arr, target));
    }

    public static int upperBound(int[] arr, int target) {
        // code here

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans == -1 ? arr.length : ans;
    }
}
