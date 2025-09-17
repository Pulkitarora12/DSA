package Day3;

import java.util.Scanner;

public class Sqrt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x <= 1) {
            System.out.println(x);
            return;
        }

        int start = 1;
        int end = x;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (x / mid == mid) {
                System.out.println(mid);
                return;
            }

            else if (x / mid > mid) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
