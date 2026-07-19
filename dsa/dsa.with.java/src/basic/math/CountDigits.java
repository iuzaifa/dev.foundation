package basic.math;

public class CountDigits {
    public static void main(String[] args) {

        System.out.println(countDigit(455));

    }


    /**
     * brute force approach
    public static int countDigit(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
     */


    /**
     * approach 2 best**
     * */
    public static int countDigit(int n) {
        if (n == 0) return  1;
        int count = 0;
        n = Math.abs(n); // if number is negative
        while (n != 0) {
            n = n/10;
            count++;
        }

        return  count;

    }

    // n = 5
    // n = 55     55/10 => 5 count 1, 5/10 cont 2
    // n = 555

}
