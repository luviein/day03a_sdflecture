package com.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

//REMEMBER TO PASS IN ARGUMENT WHEN IN TERMINAL
//c:\Users\tanye\OneDrive\Documents\Software Development Fundamentals\Day Three\day03a_sdflecture\src\main\java\com\edu\nus\iss>java com.edu.nus.iss/App data employee.txt

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        //check dir existence, if null = create new dir
        File newDirectory = new File(dirPath);
        if (newDirectory.exists()){
            System.out.println(dirPath + " Exists");
        }else{
            newDirectory.mkdir();
        }

        //check file existence, if null = create new file
        File myFile = new File(dirPathFileName);
        if (myFile.exists()){
            System.out.println(myFile + " Exists");
        }else{
            myFile.createNewFile();
        }

        CSVWriter csvWriter = new CSVWriter();
        List<Employee> empList = csvWriter.generateEmployees();
        csvWriter.writeToCSV(empList, dirPathFileName);
        
        CSVReader csvReader = new CSVReader();
        List<Employee> retrievedList = csvReader.readCSV(dirPathFileName);
        System.out.println(retrievedList.toString());
    }
}
