import java.util.ArrayList;
import java.util.List;

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