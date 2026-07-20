package basic.math;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(3456543));
        System.out.println(isPalindrome(125));
    }

    public static boolean isPalindrome(int n) {
        if (n < 0) return false;
        int left = n, right = 0;
        while (left != 0){
            int mod = left % 10;
            right = (right * 10) + mod;
            left = left / 10;
        }
        return n == right;

    }
}
