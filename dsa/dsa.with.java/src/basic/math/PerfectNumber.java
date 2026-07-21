package basic.math;

public class PerfectNumber {

    public static void main(String[] args) {

        System.out.println(isPerfect(28));
    }

    public static boolean isPerfect(int n) {

        int sum = 0, temp = n;
        for(int i =1; i < n; i++) {
            if( n % i == 0){
                sum += i;
            }

        }
        return temp == sum;

    }
}
