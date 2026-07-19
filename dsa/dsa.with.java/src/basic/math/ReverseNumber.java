package basic.math;

public class ReverseNumber {
    public static void main(String[] args) {


        System.out.println(reverseNumber(45));
    }

    //  brute force approach
    public static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10; // find last digit
            rev = rev * 10 + digit;
            n = n / 10;
        }

        return  rev;
    }

    /**
     *  56 reverse 65
     *  65 reverse 56
     *  89 reverse 98
     *
     *  56 % 10 = 6 => 6 * 10  = 60
     *  n += n / 10 = 5
     *
     * */

}
