package com.sandeep.beans;

public class Employee {
	int id;
	String name;
	String email;
	String password;
	float salary;
	String permission = "user";

	public Employee() {
	}

	public Employee(int id, String name, String email, float salary) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public Employee(int id, String name, String email, String password, float salary, String permission) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", salary="
				+ salary + ", permission=" + permission + "]";
	}

}
