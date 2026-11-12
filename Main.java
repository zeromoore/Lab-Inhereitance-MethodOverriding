import java.util.Scanner;

class Employee {
    double calculateSalary() {
        return 0.0;
    }
}

class FullTimeEmployee extends Employee {
    //fields are now private so they can only be set through the constructor
    private double basePay;
    private double bonus;

    //constructor so the object always has real values when it is created
    FullTimeEmployee(double basePay, double bonus) {
        this.basePay = basePay;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basePay + bonus;
    }
}

class PartTimeEmployee extends Employee {
    //private fields, same reason as above
    private double hourlyRate;
    private double hoursWorked;

    //constructor that stores the user's input in the object
    PartTimeEmployee(double hourlyRate, double hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee type (full-time / part-time): ");
        String type = input.nextLine();

        //one Employee reference that can hold either subclass (polymorphism)
        Employee emp;

        //if / else if / else so only one branch runs
        if (type.equalsIgnoreCase("full-time")) {
            System.out.print("Enter base pay: ");
            double basePay = input.nextDouble();

            System.out.print("Enter bonus: ");
            double bonus = input.nextDouble();

            //pass the input into the object (this was the main bug,
            // before, the values were read but never given to the object)
            emp = new FullTimeEmployee(basePay, bonus);

        } else if (type.equalsIgnoreCase("part-time")) {
            //prompt clarifies the hours are for the month, so the "Monthly Salary" label below is accurate
            System.out.print("Enter hourly rate: ");
            double hourlyRate = input.nextDouble();

            System.out.print("Enter hours worked this month: ");
            double hoursWorked = input.nextDouble();

            //pass the input into the object
            emp = new PartTimeEmployee(hourlyRate, hoursWorked);

        } else {
            //handle invalid input instead of silently doing nothing
            System.out.println("Invalid employee type.");
            input.close();
            return; // stop here so emp is never used unassigned
        }

        //a single call works for either type because of polymorphism
        System.out.println("Monthly Salary: " + emp.calculateSalary());

        //close the Scanner when finished
        input.close();
    }
}
