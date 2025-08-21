import java.util.List;
import java.util.Arrays;

public class EmployeeSalary{

    public static class Employee{

        private String empId;
        private String empName;
        private double empSalary;


        public Employee(String empId,String empName,double empSalary){

            this.empId=empId;
            this.empName=empName;
            this.empSalary=empSalary;

        }

        public void setEmpId(String empId){

            this.empId=empId;
        }

        public String getEmpId(){

            return empId;
        }

        public void setEmpName(String empName){

            this.empName=empName;
        }

        public String getEmpName(){

            return empName;
        }

        public void setEmpSalary(double empSalary){

            this.empSalary=empSalary;
        }

        public double getEmpSalary(){

            return empSalary;
        }


    }

    public static void secondHighestSalary(List<Employee> employee){



        double firstHighestSalary=Double.MIN_VALUE;
        Double secondHighestSalary=Double.MIN_VALUE;

        for(Employee e : employee){

            double sal=e.getEmpSalary();

            if(sal > firstHighestSalary){

                secondHighestSalary = firstHighestSalary;
                firstHighestSalary = sal;  

            }else if(sal > secondHighestSalary && sal < firstHighestSalary){

                secondHighestSalary = sal;

            }

        }

        if (secondHighestSalary == Double.NEGATIVE_INFINITY) {

            System.out.println("No second highest salary found");

        } else {


            
            System.out.println("Second Highest salary : " + secondHighestSalary);
        }


    }

    public static void main(String args[]){

        
        List<Employee> employeeData=Arrays.asList(
            new Employee("1","Hari",75000),
            new Employee("2","krishnan",50000),
            new Employee("3","Sajin",85000),
            new Employee("4","Sudha",5000)
            );


        secondHighestSalary(employeeData);


    }

}