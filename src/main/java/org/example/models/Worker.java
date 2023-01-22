package org.example.models;
public abstract class Worker {
    private static int id;
    private int idCurrent;
    String name;
    String otdel;
    String tel;

    static {
        id = 1;
    }

    public Worker(String name, String otdel, String tel) {
        this.name = name;
        this.otdel = otdel;
        this.tel = tel;
        this.idCurrent = id;
        id ++;
    }

    public int getIdCurrent() {
        return idCurrent;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s %s", idCurrent, name, otdel, tel);
    }

    public abstract void addSalary(int salary);
}
