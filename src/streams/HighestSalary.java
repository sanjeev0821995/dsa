package streams;

import java.util.*;
import java.util.stream.Collectors;

public class HighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ravi", 50000, "IT", "E101"),
                new Employee("Shyam", 60000, "HR", "E102"),
                new Employee("Punit", 55000, "Finance", "E103"),
                new Employee("Pinky", 70000, "IT", "E104"),
                new Employee("Amit", 65000, "Sales", "E105"),
                new Employee("Rajesh", 62000, "HR", "E106"),
                new Employee("Suman", 75000, "IT", "E107"),
                new Employee("Karan", 67000, "Finance", "E108"),
                new Employee("Priya", 58000, "Sales", "E109"),
                new Employee("Neha", 72000, "IT", "E110")
        );
        //Max Salary
        employees.stream().max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        //Nth Max
        int n=3;
        employees.stream().map(Employee::getSalary).distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n-1).findFirst().ifPresentOrElse(
                salary -> System.out.println("The " + n + "th largest salary is: " + salary),
                () -> System.out.println("Invalid N value!")
        );

        //SortByNameAndThenSalary->Natural Order
        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        //SortByNameAndThenSalary->Salary by descencending
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .forEach(System.out::println);

        //Count the sum of Salary
        System.out.println("Total Gross Salary = "+employees.stream().mapToDouble(Employee::getSalary).sum());

        //Count the Average Salary
        System.out.println("Average Salary = "+employees.stream().mapToDouble(Employee::getSalary).average());

        //count the Total number of Employee
        System.out.println("Total Number Of Employee = "+employees.stream().count());

        //count the Total number of Employee in each Department
        Map<String,Long> countEmployeeInEachDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
        countEmployeeInEachDept.entrySet().forEach(e-> System.out.println(e.getKey()+" = "+e.getValue()));

        //count the Total Salary of Employee in each Department
        Map<String,Double> sumOfSalaryInEachDept=employees.stream().collect(
                Collectors.groupingBy(Employee::getDept,Collectors.summingDouble(Employee::getSalary)));
        sumOfSalaryInEachDept.entrySet().forEach(e-> System.out.println(e.getKey()+" = "+e.getValue()));

        //count the Average Salary of Employee in each Department
        Map<String,Double> averagefSalaryInEachDept=employees.stream().collect(
                Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
        averagefSalaryInEachDept.entrySet().forEach(e-> System.out.println(e.getKey()+" = "+e.getValue()));

        //Find all employees from the "IT" department
        List<Employee> itEmployees = employees.stream()
                .filter(emp -> emp.getDept().equals("IT"))
                .collect(Collectors.toList());
        itEmployees.forEach(System.out::println);

        //Get the names of employees working in the "Finance" department
        List<String> financeEmployeeNames = employees.stream()
                .filter(emp -> emp.getDept().equals("Finance"))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(financeEmployeeNames);

        // Get the highest salary in the company
        OptionalDouble highestSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();
        highestSalary.ifPresent(salary -> System.out.println("Highest Salary: " + salary));

        //Find the total salary of employees in the Sales department
        double totalSalesSalary = employees.stream()
                .filter(emp -> emp.getDept().equals("Sales"))
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary in Sales Department: " + totalSalesSalary);

        //Get the names of top 3 highest-paid employees
        List<String> top3Earners = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Top 3 Highest Paid Employees: " + top3Earners);


    }
}
