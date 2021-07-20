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
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

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
     * @param ioService
     */
    public void writeEmployeePayrollData(IOService ioService)
    {
        if (ioService.equals(IOService.CONSOLE_IO))
        {
            System.out.println("\nWriting Employee Payroll To Console:\n" + employeePayrollDataList);
        }
        else if (ioService.equals(IOService.FILE_IO))
        {
            new EmployeePayrollFileIOService().writeData(employeePayrollDataList);
        }
    }

    /**
     * Name : printData
     *
     * Description : Printing employee data to console.
     *
     * @param ioService
     *
     * Modification : First Commit 20-July-2021.
     */
    public void printData(IOService ioService)
    {
        if (ioService.equals(IOService.FILE_IO))
        {
            new EmployeePayrollFileIOService().printData();
        }
    }

    /**
     * Name : countEntries
     *
     * Description : Counting the total number of records present in file.
     *
     * @param ioService
     * @return
     *
     * Modification : First Commit 20-July-2021
     */
    public long countEntries(IOService ioService)
    {
        if (ioService.equals(IOService.FILE_IO))
        {
            return new EmployeePayrollFileIOService().countEntries();
        }
        return 0;
    }

    public long readEmployeePayrollData(IOService ioService)
    {
        if (ioService.equals(IOService.FILE_IO))
        {
            this.employeePayrollDataList = new EmployeePayrollFileIOService().readData();
            return employeePayrollDataList.size();
        }
        return 0;
    }

    public static void main(String[] args)
    {
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    }
}
