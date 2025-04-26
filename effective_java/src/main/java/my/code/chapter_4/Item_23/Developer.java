package my.code.chapter_4.Item_23;

public class Developer extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public Developer(double hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
