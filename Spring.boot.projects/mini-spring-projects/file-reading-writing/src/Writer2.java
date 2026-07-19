import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writer2 {

    public static void main(String[] args) throws IOException {

        HashMap<Integer, HashMap<String, Double>> nestedHashMap = new HashMap<>();
        HashMap<String, Double> modelPriceMap = new HashMap<>();

        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Abu Huzaifa\\cars.csv"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        line = reader.readLine();
        while ((line = reader.readLine()) != null) {

            String[] splitArr = line.split(",");
            String model = splitArr[0];
            double price = Double.parseDouble(splitArr[3]);
            int year = Integer.parseInt(splitArr[2]);

            if (nestedHashMap.containsKey(year)) {     // in first loop Iteration  in HashMap is Empty
                // Year => Model => oldPrice + newPrice
                // Key  => Year
                //         Year - Model  + TotalPrice
                modelPriceMap = nestedHashMap.get(year);

                if (modelPriceMap.containsKey(model)){
                    double  oldPrice = modelPriceMap.get(model) + price;

//                    oldMap.put(model, newPrice);
                }
                else {
                    modelPriceMap.put(model,   price);
                }

            } else {
                modelPriceMap.put(model, price);  // model => CarName, Price => 12345,
                nestedHashMap.put(year, modelPriceMap);  // Year =>  1999 , ( model => CarName, Price => 12345, )
            }
        }
        reader.close();


        for (HashMap.Entry<Integer, HashMap<String, Double>> entry : nestedHashMap.entrySet()) {
            Integer year = entry.getKey();
            HashMap<String, Double> brandSellingPriceMap = entry.getValue();
            for (HashMap.Entry<String, Double> finalEntry : brandSellingPriceMap.entrySet()) {

                String model = finalEntry.getKey();
                Double price = finalEntry.getValue();
                System.out.println("Year => " + year + " : Model => " + model + " : Price => " + price);
            }

        }

    }


}
