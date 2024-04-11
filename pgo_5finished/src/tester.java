import java.util.ArrayList;
import java.util.List;

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