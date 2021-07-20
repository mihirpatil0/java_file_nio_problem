package com.bridgelab.javaioemployeepayrollservicetest;

import com.bridgelab.javaioemployeepayrollservice.EmployeePayrollData;
import com.bridgelab.javaioemployeepayrollservice.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**********************************************************
 * @author mihir
 *
 * @since 20-July-2021
 *
 * This class hold all the test cases for the same project.
 *********************************************************/

public class EmployeepayrollServiceTest
{
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries()
    {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "Naruto", 1000000.0),
                new EmployeePayrollData(2, "Hinata", 2000000.0),
                new EmployeePayrollData(3, "Sasuke", 3000000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entries);
    }
}
