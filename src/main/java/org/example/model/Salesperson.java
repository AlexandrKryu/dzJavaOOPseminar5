package org.example.model;

public class Salesperson extends AbstractWorker {

	private Integer salespersonId;
	private String section;

	public Salesperson(Integer salespersonId, String name, String department, String tel, Integer salary,
			String section) {
		super(name, department, tel, salary);
		this.salespersonId = salespersonId;
		this.section = section;
	}

	@Override
	public String toString() {
		return String.format("%d: %s Секция: %s", salespersonId, super.toString(), section);
	}

	public Integer getSalespersonId() {
		return salespersonId;
	}

	public void setSalespersonId(Integer salespersonId) {
		this.salespersonId = salespersonId;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
