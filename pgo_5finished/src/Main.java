import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Developer dev = new Developer("John", "Doe", "NewYork", "john@doe.com", "123456789", 2020);
        Technology t=new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);

        Tester tester = new Tester("Jane", "Smith", "LosAngeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);

        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        Goal g=new Goal(2010, 10, 15, "Implementing FB login",  1000);
        manager.addGoals(g);
        employees.add(manager);


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

    public Employee(String imie, String nazwisko, String adres, String email, String pesel, int rokzatrudnienia){

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.email = email;
        this.pesel = pesel;
        this.rokzatrudnienia = rokzatrudnienia;


    }

    public int calculateSalary() {
        int baseSalary = 3000;
        int yearsWorked = LocalDate.now().getYear() - rokzatrudnienia;
        int additionalSalary = yearsWorked * 1000;
        return baseSalary + additionalSalary;
    }
}

class Developer extends Employee {
    List<Technology> technologies = new ArrayList<>();
    public Developer(String imie, String nazwisko, String adres, String email, String pesel, int rokzatrudnienia){
        super(imie,nazwisko,adres,email,pesel,rokzatrudnienia);
    }
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
    public Tester(String imie, String nazwisko, String adres, String email, String pesel, int rokzatrudnienia){
        super(imie,nazwisko,adres,email,pesel,rokzatrudnienia);
    }

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
    public Manager(String imie, String nazwisko, String adres, String email, String pesel, int rokzatrudnienia){
        super(imie,nazwisko,adres,email,pesel,rokzatrudnienia);
    }

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