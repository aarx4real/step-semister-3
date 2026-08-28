package week3.assignments;

public class M5_EmployeeStaticDemo {
    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Asha", 50000);
        new Employee("Bharat", 55000);
        new Employee("Chitra", 60000);

        Employee.printCompanyInfo();
    }
}
