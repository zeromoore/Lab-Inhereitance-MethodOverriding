import java.util.Scanner;

class Employee {
    double calculateSalary() {
        return 0.0;
    }
}

class FullTimeEmployee extends Employee {
    double basePay;
    double bonus;
    @Override
    double calculateSalary() {
        return basePay + bonus;
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    double hoursWorked;
    @Override
    double calculateSalary() {
        return (hourlyRate * hoursWorked);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee type (full-time / part-time): ");
        String type = input.nextLine();

        if (type.equalsIgnoreCase("full-time")) {
            System.out.print("Enter base pay: ");
            double basePay = input.nextDouble();

            System.out.print("Enter bonus: ");
            double bonus = input.nextDouble();

            FullTimeEmployee fte = new FullTimeEmployee();

            System.out.println("Monthly Salary: " + fte.calculateSalary());

        }

        if (type.equalsIgnoreCase("part-time")) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = input.nextDouble();

            System.out.print("Enter hours worked: ");
            double hoursWorked = input.nextDouble();

            PartTimeEmployee pte = new PartTimeEmployee();

            System.out.println("Monthly Salary: " + pte.calculateSalary());

        }

        }
    }