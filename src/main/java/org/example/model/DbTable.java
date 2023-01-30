package org.example.model;

import java.util.ArrayList;
import java.util.List;

public interface DbTable<T> {
	void add(T entry);

	void addAll(List<T> entries);

	T get(int id);

	List<T> getAll();

	boolean update(T entry);

	T delete(int id);
}

abstract class AbstractDbTable<T> implements DbTable<T> {

	protected List<T> list;
	private int lastId;

	public AbstractDbTable() {
		list = new ArrayList<>();
		lastId = 0;
	}

	protected abstract Integer getId(T t);

	protected abstract void setId(T t, int id);

	@Override
	public void add(T entry) {
		if (entry == null) {
			return;
		}

		lastId++;
		setId(entry, lastId);
		list.add(entry); // доделать -- добавление клонированного вместо переданного!
	}

	@Override
	public void addAll(List<T> entries) {
		if (entries == null) {
			return;
		}

		for (T entry : entries) {
			add(entry);
		}
	}

	@Override
	public T delete(int id) {
		T t = get(id);
		if (t != null) {
			list.remove(t);
		}
		return t;
	}

	@Override
	public T get(int id) {
		for (T t : list) {
			if (id == getId(t)) {
				return t; // надо клона
			}
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		return List.copyOf(list); // надо список клонов
	}

	@Override
	public boolean update(T entry) {
		T t = get(getId(entry));
		if (t == null) {
			return false;
		}

		int listIndex = list.indexOf(t);
		list.set(listIndex, entry); // клонированного надо
		return true;
	}
}