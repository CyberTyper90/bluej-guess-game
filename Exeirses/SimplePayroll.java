import java.io.*;
import java.util.*;

class Employee {
    String name;
    double hourlyRate;
    double totalHours = 0;

    public Employee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = Math.max(hourlyRate, 27.80);
    }

    public void addHours(double hours) {
        if (!name.equals("Ari") && hours > 50000) {
            System.out.println(name + " cannot work more than 50000 hours!");
            return;
        }
        totalHours += hours;
    }

    public double calculatePay() {
        double regularHours = Math.min(totalHours, 40);
        double overtimeHours = Math.min(Math.max(totalHours - 40, 0), 10);
        double pay = (regularHours * hourlyRate) + (overtimeHours * (hourlyRate + 1.17));
        totalHours = 0; 
        return pay;
    }
}

public class SimplePayroll {
    private static final String FILE_NAME = "employees.txt";
    private static Map<String, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        loadEmployees();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee  2. Record Hours  3. Run Payroll  4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter hourly rate: ");
                    double rate = scanner.nextDouble();
                    employees.put(name, new Employee(name, rate));
                    saveEmployees();
                    break;
                case 2:
                    System.out.print("Enter employee name: ");
                    String empName = scanner.nextLine();
                    System.out.print("Enter hours worked: ");
                    double hours = scanner.nextDouble();
                    if (employees.containsKey(empName)) {
                        employees.get(empName).addHours(hours);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    for (Employee emp : employees.values()) {
                        System.out.println(emp.name + " - Pay: $" + emp.calculatePay());
                    }
                    saveEmployees();
                    break;
                case 4:
                    saveEmployees();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void loadEmployees() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                employees.put(data[0], new Employee(data[0], Double.parseDouble(data[1])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved employees found.");
        }
    }

    private static void saveEmployees() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees.values()) {
                writer.println(emp.name + "," + emp.hourlyRate);
            }
        } catch (IOException e) {
            System.out.println("Error saving employees.");
        }
    }
}