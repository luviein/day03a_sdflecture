package com.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

    public static final String COMMA_DELIMITTER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo, fullName, department, role, emailAddress, salary";

    public List <Employee> employees = null;
    
    public List <Employee> generateEmployees() {
        employees = new ArrayList<>();
        Employee emp1= new Employee("12322", "Arun", "Infrastructure", "Tech", "arun@visa.com", 12000);
        Employee emp2 = new Employee("12322", "Arun", "Infrastructure", "Tech", "arun@visa.com", 12000);
        Employee emp3 = new Employee("12399", "Bob", "Lisa", "PR Manager", "bob@visa.com", 14000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSV(List<Employee> employees, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        //write the FILE_HEADER
        fileWriter.append(FILE_HEADER.toString());
        fileWriter.append(NEWLINE_SEPARATOR);


        //interate through employees to write each employee record to file
        for(Employee emp : employees){ //can try write function
            fileWriter.append(emp.getStaffNo());
            fileWriter.append(COMMA_DELIMITTER);
            fileWriter.append(emp.getFullName());
            fileWriter.append(COMMA_DELIMITTER);
            fileWriter.append(emp.getDepartment());
            fileWriter.append(COMMA_DELIMITTER);
            fileWriter.append(emp.getRole());
            fileWriter.append(COMMA_DELIMITTER);
            fileWriter.append(emp.getEmailAddress());
            fileWriter.append(COMMA_DELIMITTER);
            fileWriter.append(String.valueOf(emp.getSalary())); // cannot put integer so need to convert to String
            fileWriter.append(NEWLINE_SEPARATOR);
        }

        //flush and close the fileWriter
        fileWriter.flush();
        fileWriter.close();
    }


}
