package basic.string;


public class FindTargetChar {

    public static void main(String[] args) {
        System.out.println(targetChar("abuhuzaifa@gmail.com", 'A'));
    }


    public  static boolean targetChar(String str, char target) {

        char ch = 0;
        for (int i=0; i<str.length(); i++){
            if (target == str.charAt(i)) ch = str.charAt(i);
        }

        return  target == ch;
    }
}
