package basic.math;

public class CountOddDigits {
    public static void main(String[] args) {

        System.out.println(countOddDigit(25));
    }

    public static int countOddDigit(int n) {

        int count = 0;

        while (n != 0 ) {
            int digit = n % 10;
            if (digit % 2 != 0) {
                count++;
            }
            n = n / 10;
        }

        return count;
    }
}
