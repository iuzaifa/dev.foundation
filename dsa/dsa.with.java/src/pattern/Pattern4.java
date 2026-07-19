package pattern;

public class Pattern4 {
    public static void main(String[] args) {
        pattern4(4);
    }

    public static void pattern4(int n) {

        for (int i = 0; i< n; i++){
            for (int j=0; j<= i; j++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
}
