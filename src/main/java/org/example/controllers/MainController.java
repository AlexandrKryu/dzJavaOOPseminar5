package org.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.example.model.DbTables;
import org.example.view.View;

public class MainController {

	private final DbTables tables;
	private final View view;

	private final Map<Integer, String> mainMenuViewModel; // можно в константу переделать

	public MainController(DbTables tables, View view) {
		this.tables = tables;
		this.view = view;
		this.mainMenuViewModel = new TreeMap<>(Map.of(
				1, "Показать всех менеджеров",
				2, "Показать всех продавцов",
				3, "Пункт 3",
				4, "Пункт 4"));
	}

	public void run() {

		String userAnswer = "";
		while (!userAnswer.equals("0")) {
			view.showMenu(mainMenuViewModel);
			userAnswer = view.getUserAnswer("Введите пункт: ");
			routeMenuAction(userAnswer);
		}
	}

	private void routeMenuAction(String menuItem) {
		switch (menuItem) {
			case "1":
				showAllManagers();
				pause();
				break;
			case "2":
				showAllSalespersons();
				pause();
				break;
			case "3":
				System.out.println("Выбрано действие 3");
				pause();
				break;
			case "4":
				System.out.println("Выбрано действие 3");
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

	private static <T> List<String> mapToStrings(List<T> list) {
		return list.stream().map(w -> w.toString()).toList();
	}

	private void showAllManagers() {
		var managers = tables.managers();
		List<String> workersViewModel = mapToStrings(managers.getAll());
		view.printText("\nМенеджеры:");
		view.printList(workersViewModel);
	}

	private void showAllSalespersons() {
		var salespersons = tables.salespersons();
		List<String> workersViewModel = mapToStrings(salespersons.getAll());
		view.printText("\nПродавцы:");
		view.printList(workersViewModel);
	}

	private void pause() {
		view.getUserAnswer("Нажмите Ввод чтобы продолжить...");
	}

	private void notifyWrongMenuItem() {
		view.printText("Некорректный пункт меню! Повторите...");
	}

	private void exit() {
		view.printText("Спасибо. Работа завершена.\n");
	}

}
