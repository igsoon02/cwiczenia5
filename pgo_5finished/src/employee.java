import java.time.LocalDate;

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