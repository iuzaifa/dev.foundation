package pattern;

public class Pattern1 {

    public static void main(String[] args) {
        pattern1(4);

    }

    public static void pattern1(int n) {

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++){
                System.out.printf("* ");
            }
            System.out.println();
        }

    }
}
