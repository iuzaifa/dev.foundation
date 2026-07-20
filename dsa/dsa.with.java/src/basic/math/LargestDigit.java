package basic.math;

public class LargestDigit {
    public static void main(String[] args) {

        System.out.println(largestDigit(9));
        System.out.println(largestDigit(98));
        System.out.println(largestDigit(987));
        System.out.println(largestDigit(87965));
        System.out.println(largestDigit(903));

    }

    public static int largestDigit(int n) {
        n = Math.abs(n);
        int largest_n = 0;
        while ( n != 0 ) {
            int mod = n % 10; // last
            if (mod > largest_n) {
                largest_n = mod;
            }
            n = n / 10;
        }

        return largest_n;
    }
}
