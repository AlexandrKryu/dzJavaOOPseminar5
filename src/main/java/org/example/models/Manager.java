package org.example.models;

public class Manager extends Worker {
    private int salary;

    public Manager(String name, String otdel, String tel, int salary) {
        super(name, otdel, tel);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s %s %d", getIdCurrent(), name, otdel, tel, salary);
    }

    @Override
    public void addSalary(int salary) {
        this.salary = salary;
    }
}
