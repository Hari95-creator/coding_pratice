import java.util.List;

import javax.management.RuntimeErrorException;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSalary {

    public static class Employee {

        private String empId;
        private String empName;
        private double empSalary;

        public Employee(String empId, String empName, double empSalary) {

            this.empId = empId;
            this.empName = empName;
            this.empSalary = empSalary;

        }

        public void setEmpId(String empId) {

            this.empId = empId;
        }

        public String getEmpId() {

            return empId;
        }

        public void setEmpName(String empName) {

            this.empName = empName;
        }

        public String getEmpName() {

            return empName;
        }

        public void setEmpSalary(double empSalary) {

            this.empSalary = empSalary;
        }

        public double getEmpSalary() {

            return empSalary;
        }

    }

    public static void secondHighestSalary(List<Employee> employee) {

        double firstHighestSalary = Double.MIN_VALUE;
        Double secondHighestSalary = Double.MIN_VALUE;

        Employee EMPLOYEEDETAILS = null;

        for (Employee e : employee) {

            double sal = e.getEmpSalary();

            if (sal > firstHighestSalary) {

                secondHighestSalary = firstHighestSalary;
                firstHighestSalary = sal;

            } else if (sal > secondHighestSalary && sal < firstHighestSalary) {

                secondHighestSalary = sal;

            }

        }

        if (secondHighestSalary == Double.NEGATIVE_INFINITY) {

            System.out.println("No second highest salary found");

        } else {

            for (Employee details : employee) {

                if (details.getEmpSalary() == secondHighestSalary) {

                    EMPLOYEEDETAILS = details;
                    break;

                }

            }

            System.out.println("**********************************************************************");
            System.out.println("Employee Name :" + EMPLOYEEDETAILS.getEmpName());
            System.out.println("Employee Id :" + EMPLOYEEDETAILS.getEmpId());
            System.out.println("Second Highest salary : " + secondHighestSalary);
            System.out.println("**********************************************************************");

        }

    }

    public static void secondHighestSalryWithStreams(List<Employee> employees) {

        double secondHighest = employees.stream()
                .map(Employee::getEmpSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No salary found"));

        System.out.println("**********************************************************************");

        List<Employee> employeeDetails = employees.stream()
                .filter(empdata -> empdata.getEmpSalary() == secondHighest)
                .map(data -> new Employee(data.getEmpId(), data.getEmpName(), secondHighest))
                .toList();

        employeeDetails.forEach(eData -> {
            System.out.println("Id :" + eData.getEmpId());
            System.out.println("Name :" + eData.getEmpName());
            System.out.println("Salary :" + eData.getEmpSalary());
        });

        System.out.println("**********************************************************************");

        List<Employee> employeeData = employees.stream()
                .filter(eObj -> eObj.getEmpSalary() == secondHighest)
                .toList();

        employeeData.forEach(eData -> {
            System.out.println("Id :" + eData.getEmpId());
            System.out.println("Name :" + eData.getEmpName());
            System.out.println("Salary :" + eData.getEmpSalary());
        });

        System.out.println("**********************************************************************");

        List<Employee> employeeD = employees.stream()
                .filter(obj -> obj.getEmpSalary() == secondHighest)
                .peek(eData ->

                {
                    System.out.println("Id using peek :" + eData.getEmpId());
                    System.out.println("Name using peek:" + eData.getEmpName());
                    System.out.println("Salary using peek:" + eData.getEmpSalary());
                }).toList();
        System.out.println("**********************************************************************");

        // peek() is like forEach, but it’s an intermediate operation, so the stream can still be collected into a list afterward.

        // forEach → consumes the stream, returns void.

        // toList() (or collect(Collectors.toList())) → gives you a list.

        // peek() → good if you want to log/print while still collecting.

    }

    public static void main(String args[]) {

        List<Employee> employeeData = Arrays.asList(
                new Employee("1", "Hari", 75000),
                new Employee("2", "krishnan", 50000),
                new Employee("3", "Sajin", 85000),
                new Employee("4", "Sudha", 5000));

        secondHighestSalary(employeeData);
        secondHighestSalryWithStreams(employeeData);

    }

}