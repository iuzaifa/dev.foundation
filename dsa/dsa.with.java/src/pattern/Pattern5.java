package pattern;

public class Pattern5 {
    public static void main(String[] args) {
        pattern5(4);
    }

    public static void pattern5(int n) {

        for (int i = 0; i < n; i++){
            for (int j=i; j < n; j++){
                System.out.printf("*");
            }
            System.out.println();
        }

    }
}
