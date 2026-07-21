package basic.math;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmstrongIst(371));
        System.out.println(isArmstrongIInd(371));

    }

    public static boolean isArmstrongIst(int n) {
        int original = n, sum = 0;
        int digits = String.valueOf(n).length();

        while (n != 0) {
            int mod = n % 10;
            sum += (int) Math.pow(mod, digits);
            n = n / 10;
        }
        return original == sum;
    }

    public static boolean isArmstrongIInd(int n) {
        int original = n, temp = n;
        int count = 0, sum = 0;

        if (n == 0) return true;

        while (temp > 0) {
            count++;
            temp /= 10;
        }
        temp = n;

        while (temp != 0) {
            int digit = temp % 10;
            int power = 1;

            for (int i = 0; i < count; i++) {
                power *= digit;
            }

            sum += power;
            temp /= 10;
        }



        return original == sum;
    }

}
