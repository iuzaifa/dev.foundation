package org.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TotalSalaryEmployees {

    public static void main(String[] args) throws IOException {


        /*
            "In this assignment, I will calculate all employees' salaries by reading a CSV file."
        */

        String filePath = "src/main/resources/input/CommaSeparatedEmployeeFile.csv"; // Check if the file path is correct whenever the local package path changes

        BufferedReader reader = null; // Reader initialization. If the file path is not available, a try-catch error will be generated.
        String line = ""; // Read Row is initialized as empty because it will be used to store lines read from a file.


        try {
            reader = new BufferedReader(new FileReader( filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int nextSalary = 0;
        line = reader.readLine(); // The first line will be read initially to ignore the header of the file.
        while ( (line = reader.readLine()) != null ){  // if line not
            String [] splitArr = line.split(","); //
            String lastSalary = splitArr[2];
            nextSalary += Integer.parseInt(lastSalary);


        }

        System.out.println("Total Salary of the all Employees : " + nextSalary);




    }
}
