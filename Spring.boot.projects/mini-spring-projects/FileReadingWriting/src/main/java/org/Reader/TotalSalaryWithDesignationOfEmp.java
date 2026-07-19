package org.Reader;

import java.io.*;
import java.util.HashMap;

public class TotalSalaryWithDesignationOfEmp {
    public static void main(String[] args) throws IOException {

        /* Calculate salaries based on their designations from a CSV file.  */
        HashMap<String, Float> totalSalaryDesignationWiseMap = new HashMap<>();
        String filePath = "src/main/resources/input/CommaSeparatedEmployeeFile.csv"; // Check if the file path is correct whenever the local package path changes
        String outputPath = "src/main/resources/output/totalSalary.csv";

        String line = "";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            writer = new BufferedWriter(new FileWriter(outputPath));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        line = reader.readLine();
        while((line = reader.readLine()) != null){
            String[] splitArr = line.split(",");
            float lastSalary = Float.parseFloat(splitArr[2]);
            String designationOfEmployee = splitArr[3];

            if (totalSalaryDesignationWiseMap.containsKey(designationOfEmployee)){
                //                totalSalaryDesignationWiseMap.put(designationOfEmployee, lastSalary + nextSalary);
                totalSalaryDesignationWiseMap.compute(designationOfEmployee, (k, nextSalary) -> lastSalary + nextSalary);

            }else {
                totalSalaryDesignationWiseMap.put(designationOfEmployee, lastSalary);
            }

        }

        String outPutHeader = "Designation, Total Salary With Designation \n";
        writer.write(outPutHeader);
        for (HashMap.Entry<String, Float> e : totalSalaryDesignationWiseMap.entrySet()){
            String designation = e.getKey();
            float salary = e.getValue();
//            String outputLine = "Department : " + designation + " Total Salary :=> " +salary;

            String outputLine = designation + ", " +salary;

            System.out.println(outputLine);
            writer.write(outputLine);
            writer.newLine();
//            System.out.println("Department : " + designation + " Total Salary :=> " +salary);
        }

        reader.close();
        writer.close();



    }



}
