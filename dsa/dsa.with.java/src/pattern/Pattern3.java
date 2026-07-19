package pattern;

public class Pattern3 {
    public static void main(String[] args) {
        pattern3(4);
    }

    public static void pattern3(int n) {

        for (int i = 0; i< n; i++){
            for (int j=0; j<= i; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
    // 1
    // 12
    // 123
    // 1234
}
