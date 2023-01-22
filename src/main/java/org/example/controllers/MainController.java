package org.example.controllers;

import java.util.List;

import org.example.models.WorkerDb;
import org.example.view.View;

public class MainController {

	private final WorkerDb workerDb;
	private final View view;

	public MainController(WorkerDb workerDb, View view) {
		this.workerDb = workerDb;
		this.view = view;
	}

	public void run() {

		String userAnswer = "";
		while (!userAnswer.equals("0")) {
			view.showMainMenu();
			userAnswer = view.getUserAnswer("Введите пункт: ");
			routeMenuAction(userAnswer);
		}

	}

	private void routeMenuAction(String menuItem) {
		switch (menuItem) {
			case "1":
				System.out.println("Выбрано действие 1");
				pause();
				break;
			case "2":
				System.out.println("Выбрано действие 2");
				pause();
				break;
			case "3":
				showAllWorkers();
				pause();
				break;
			case "0":
				exit();
				break;

			default:
				notifyWrongMenuItem();
				break;
		}
	}

	private void pause() {
		view.getUserAnswer("Нажмите Ввод чтобы продолжить..");
	}

	private void showAllWorkers() {
		var workers = workerDb.getAll();
		List<String> workersViewModel = workers.stream().map(w -> w.toString()).toList();
		view.printText("\nСписок работников:");
		view.printList(workersViewModel);
	}

	private void notifyWrongMenuItem() {
		view.printText("Некорректный пункт меню! Повторите...");
	}

	private void exit() {
		view.printText("Спасибо. Работа завершена.\n");
	}

}
