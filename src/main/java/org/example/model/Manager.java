package org.example.model;

public class Manager extends AbstractWorker {

    private Integer managerId;

    public Manager(Integer managerId, String name, String department, String tel, Integer salary) {
        super(name, department, tel, salary);
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", managerId, super.toString());
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
