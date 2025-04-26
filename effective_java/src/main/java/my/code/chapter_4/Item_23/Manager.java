package my.code.chapter_4.Item_23;

public class Manager extends Employee {
    private final double baseSalary;
    private final double bonus;

    public Manager(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
