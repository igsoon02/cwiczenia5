import java.time.LocalDate;

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