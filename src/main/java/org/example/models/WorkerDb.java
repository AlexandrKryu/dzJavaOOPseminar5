package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerDb /* implements Iterable<Worker> */ {
    private List<Worker> listWorkers;

    private WorkerDb() {
        this.listWorkers = new ArrayList<>();
    }

    // public void addWorker(Worker worker) {
    // this.listWorkers.add(worker);
    // }

    public void addWorkers(Worker... workers) {
        this.listWorkers.addAll(Arrays.asList(workers));
    }

    public List<Worker> getAll() {
        return listWorkers;
    }

    public static WorkerDb getInitializedDb() {
        WorkerDb workerDb = new WorkerDb();
        workerDb.addWorkers(
                new Manager("Maks", "manager", "4531321", 100500),
                new Manager("Sanya", "it", "112", 10000),
                new Manager("Alexey", "pro", "112", 12312),
                new Manager("Petya", "pro", "112", 50010),
                new Manager("Vasya", "nub", "11", 55),
                new Manager("Sveta", "pro", "112", 30040),
                new Manager("Kolya", "pro", "112", 5456),
                new Manager("Pasha", "pro", "112", 7894));
        return workerDb;
    }

    // @Override
    // public Iterator<Worker> iterator() {
    // return new Iterator<>() {
    // int counter = 0;

    // @Override
    // public boolean hasNext() {
    // return counter < listWorkers.size();
    // }

    // @Override
    // public Worker next() {
    // Worker w = listWorkers.get(counter);
    // counter++;
    // return w;
    // }
    // };
    // }
}
