package org.example.model;

import java.util.Arrays;

public class DbTables {

	public static DbTables getExampleTables() {
		var dbTables = new DbTables();
		initManagers(dbTables.managers);
		initSalespersons(dbTables.salespersons);
		return dbTables;
	}

	private DbTable<Manager> managers;
	private DbTable<Salesperson> salespersons;

	public DbTable<Manager> managers() {
		return managers;
	}

	public DbTable<Salesperson> salespersons() {
		return salespersons;
	}

	private DbTables() {

		managers = new AbstractDbTable<Manager>() {

			@Override
			protected Integer getId(Manager manager) {
				return manager.getManagerId();
			}

			@Override
			protected void setId(Manager manager, int id) {
				manager.setManagerId(id);
			}
		};

		salespersons = new AbstractDbTable<Salesperson>() {

			@Override
			protected Integer getId(Salesperson salesperson) {
				return salesperson.getSalespersonId();
			}

			@Override
			protected void setId(Salesperson salesperson, int id) {
				salesperson.setSalespersonId(id);
			}
		};

	}

	private static void initManagers(DbTable<Manager> managers) {
		managers.addAll(Arrays.asList(
				new Manager(0, "Василий", "Кадры", "+7-100-123-44-55", 50_000),
				new Manager(0, "Фёдор", "Кадры", "+7-200-444-12-64", 60_000),
				new Manager(0, "Александр", "Разработка", "+7-100-369-23-56", 80_000),
				new Manager(0, "Пётр", "Разработка", "+7-100-258-45-78", 70_200),
				new Manager(0, "Вениамин", "Логистика", "+7-200-627-47-63", 55_400)));
	}

	private static void initSalespersons(DbTable<Salesperson> salespersons) {
		salespersons.addAll(Arrays.asList(
				new Salesperson(0, "Мария", "Магазин А", "+7-100-100-10-20", 30_000, "Игры"),
				new Salesperson(0, "Фёкла", "Магазин А", "+7-200-200-30-40", 30_000, "Канцелярский"),
				new Salesperson(0, "Юлия", "Магазин Б", "+7-200-600-50-40", 40_000, "Игры")));
	}

}
