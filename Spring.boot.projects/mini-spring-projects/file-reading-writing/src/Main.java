import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();

        String str = "Brand,Model,KMDriven,SellingPrice";
        List<String> strList = new ArrayList<>();
        String[] splitArray = str.split(",");
//        strList.addAll(splitArray[0],splitArray[4]);
        strList.add(splitArray[0]);
        strList.add(splitArray[3]);

        System.out.println(strList);




//        String[] splitArr = str.split(",");
//        String tempStr = "";
//
//
//        String newString = "";
//        for(int i = 0; i < splitArr.length; i++){
//             tempStr = splitArr[0];
//        }
//
//       String string = tempStr + ", "  + str2;
//        System.out.println(tempStr);


    }
}