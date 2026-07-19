import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SaleYearWise {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, HashMap<String, Integer>> saleYearWiseMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Abu Huzaifa\\cars.csv"));
        String line = "";
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            // Year check
            String[] splitLine = line.split(",");
            int year = Integer.parseInt(splitLine[2]);
            String model = splitLine[0];
            int sellingPrice = Integer.parseInt(splitLine[3]);
            if (saleYearWiseMap.containsKey(year)) {
                HashMap<String, Integer> oldMap = saleYearWiseMap.get(year);
                if (oldMap.containsKey(model)) {  //  (Existing model available)
                    int newPrice = oldMap.get(model) + sellingPrice;
                    oldMap.put(model, newPrice);
                } else {                    // if model not available
                    oldMap.put(model, sellingPrice);
                }

            } else {
                HashMap<String, Integer> modelSellingPriceMap = new HashMap<>(); // Internal Map (Model, SellingPrice)
                modelSellingPriceMap.put(model, sellingPrice);
                saleYearWiseMap.put(year, modelSellingPriceMap);

            }
        }


        for (HashMap.Entry<Integer, HashMap<String, Integer>> entry : saleYearWiseMap.entrySet()) {
            Integer year = entry.getKey();
            HashMap<String, Integer> brandSellingPriceMap = entry.getValue();
            for (HashMap.Entry<String, Integer> finalEntry : brandSellingPriceMap.entrySet()) {
                String model = finalEntry.getKey();
                Integer price = finalEntry.getValue();
                System.out.println("Year => " + year + " : Model => " + model + " : Price => " + price);
            }

        }
        reader.close();
    }
}
