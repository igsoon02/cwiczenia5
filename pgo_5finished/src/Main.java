import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Developer dev = new Developer();
        Technology t = new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);
        dev.imie = "John";
        dev.nazwisko = "Doe";
        dev.adres = "New York";
        dev.email = "john@doe.com";
        dev.pesel = "123456789";
        dev.rokzatrudnienia = 2020;

        Tester tester = new Tester();
        tester.addTestType("UI/UX");
        employees.add(tester);
        tester.imie = "Jane";
        tester.nazwisko = "Smith";
        tester.adres = "Los Angeles";
        tester.email = "jane@Smith.com";
        tester.pesel = "987654321";
        tester.rokzatrudnienia = 2021;

        Manager manager = new Manager();
        Goal g = new Goal(2024, 4, 15, "Implementing FB login", 1000);
        manager.addGoals(g);
        employees.add(manager);
        manager.imie = "Bob";
        manager.nazwisko = "Johnson";
        manager.adres = "Chicago";
        manager.email = "bob@johnson.com";
        manager.pesel = "1122334455";
        manager.rokzatrudnienia = 2019;

        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}

class Employee {
    String imie;
    String nazwisko;
    String adres;
    String email;
    String pesel;
    int rokzatrudnienia;

    public int calculateSalary() {
        int baseSalary = 3000;
        int yearsWorked = LocalDate.now().getYear() - rokzatrudnienia;
        int additionalSalary = yearsWorked * 1000;
        return baseSalary + additionalSalary;
    }
}

class Developer extends Employee {
    List<Technology> technologies = new ArrayList<>();

    public void addTechnology(Technology tech) {
        technologies.add(tech);
    }

    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        for (Technology tech : technologies) {
            bonus += tech.getBonus();
        }
        return baseSalary + bonus;
    }
}

class Tester extends Employee {
    List<String> testTypes = new ArrayList<>();

    public void addTestType(String testType) {
        testTypes.add(testType);
    }

    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        return baseSalary + (testTypes.size() * 300);
    }
}

class Manager extends Employee {
    List<Goal> goals = new ArrayList<>();

    public void addGoals(Goal goal) {
        goals.add(goal);
    }

    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        for (Goal goal : goals) {
            if (goal.isAchievedThisMonth()) {
                bonus += goal.getBonus();
            }
        }
        return baseSalary + bonus;
    }
}

class Technology {
    String name;
    int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Goal {
    int year;
    int month;
    int day;
    String description;
    int bonus;

    public Goal(int year, int month, int day, String description, int bonus) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.bonus = bonus;
    }

    public boolean isAchievedThisMonth() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() == year && currentDate.getMonthValue() == month;
    }

    public int getBonus() {
        return bonus;
    }
}
