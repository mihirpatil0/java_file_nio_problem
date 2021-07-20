package com.bridgelab.javaioemployeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/******************************************************************************
 * @author mihir
 *
 * @since 20-July-2021
 * This class holds all the necessary methods that are required for the project.
 ******************************************************************************/

public class EmployeePayrollService
{
    //To Store employee data.
    private List<EmployeePayrollData> employeePayrollDataList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList)
    {
        this.employeePayrollDataList = employeePayrollDataList;
    }

    /**
     * Name : readEmployeePayrollData
     *
     * Description : Asking user to input data from console.
     *
     * @param consoleInputReader : Scanner to get the data from console.
     *
     * Algorithm : Asking user to provide data of an employee from console.
     * storing it inside list and writing it back down to console.
     *
     * Modification : First commit : 20-July-2021.
     */
    private void readEmployeePayrollData(Scanner consoleInputReader)
    {
        System.out.print("Enter Employee-Id : ");
        int id = consoleInputReader.nextInt();
        System.out.print("Enter Employee-Name : ");
        String name = consoleInputReader.next();
        System.out.print("Enter Employee-Salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }

    /**
     * Name : writeEmployeePayrollData
     *
     * Description : Writing employee data back to console.
     *
     * Modification : First commit 20-July-2021.
     */
    private void writeEmployeePayrollData()
    {
        System.out.println("\nWriting Employee Payroll To Console:\n" + employeePayrollDataList);
    }

    public static void main(String[] args)
    {
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }
}
