import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Writer {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> hashMap = new HashMap<>();
//        HashMap<>
        BufferedReader reader = null;
        String line = "";


        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Abu Huzaifa\\cars.csv"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        line = reader.readLine();
        while ((line = reader.readLine()) != null){
            String [] splitArr = line.split(",");

            String model = splitArr[0];
            int price = Integer.parseInt(splitArr[3]);



           if (hashMap.containsKey(model)){
               int oldValue = hashMap.get(model);
               hashMap.put(model, oldValue + price);



           }else {
               hashMap.put(splitArr[0], price);

           }

        }
        reader.close();


        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println( "Car Name : " +key + " --|--  Total Price :" + value);
        }

    }


}
