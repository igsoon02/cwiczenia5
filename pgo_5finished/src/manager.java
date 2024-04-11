import java.util.ArrayList;
import java.util.List;

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