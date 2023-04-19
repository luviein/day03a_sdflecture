package com.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<Employee> readCSV(String fileName) throws IOException{
        BufferedReader br = null;

        String line = "";
        List<Employee> employees = new ArrayList<Employee>();
        br = new BufferedReader(new FileReader(fileName));


        //Skip the FILE_HEADER
        line = br.readLine(); //reads first line and skips it

        //Read each line of CSV record
        //Format them into an Employee Object
        //add employee object into the list of employees
        while((line = br.readLine()) != null){ //br read line starts from second line onwards
            String [] lineData = line.split(CSVWriter.COMMA_DELIMITTER);
            if (lineData.length > 0){
                Employee emp = new Employee(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], Integer.parseInt(lineData[5]));
                employees.add(emp);
            }

        }


        //close BufferedReader and FileReader
        br.close(); //file reader is part of br so no need to close

        return employees;
    }



}
