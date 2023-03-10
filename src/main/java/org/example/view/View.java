package org.example.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
	private final Scanner scanner;

	public View() {
		this.scanner = new Scanner(System.in);
	}

	public void showMenu(Map<Integer, String> menuViewModel) {
		System.out.println();
		System.out.println("Меню: \n");
		for (var integerStringEntry : menuViewModel.entrySet()) {
			printMenuItem(integerStringEntry.getKey(), integerStringEntry.getValue());
		}
		System.out.println();
		printMenuItem(0, "Выйти");
	}

	private void printMenuItem(Integer key, String menuName) {
		System.out.printf("%d: %s %n", key, menuName);
	}

	public String getUserAnswer(String prompt) {
		System.out.println();
		System.out.print(prompt);
		return scanner.nextLine();
	}

	public void printText(String text) {
		System.out.println(text);
	}

	public void printList(List<String> lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
