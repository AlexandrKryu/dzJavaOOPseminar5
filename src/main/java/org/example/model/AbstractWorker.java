package org.example.model;

public abstract class AbstractWorker {
    private String name;
    private String department;
    private String tel;
    private Integer salary;

    public AbstractWorker(String name, String department, String tel, Integer salary) {
        this.name = name;
        this.department = department;
        this.tel = tel;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-12s  Тел.: %s  Отдел: %-12s  З/п: %-6d", name, tel, department, salary);
    }

    // далее просто геттеры и сеттеры свойств, общих для всех работников:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
