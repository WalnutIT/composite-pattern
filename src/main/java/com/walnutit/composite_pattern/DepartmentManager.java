/**
 * Copyright 2020 - 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walnutit.composite_pattern;

import java.util.HashMap;

/**
 * @author Daniel Krentzlin
 *
 */
public class DepartmentManager extends Employee {

	private HashMap<Integer, Employee> employees = new HashMap<>();

	public HashMap<Integer, Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param id
	 * @param name
	 */
	public DepartmentManager(int id, String name) {
		super(id, name);
	}

	@Override
	public boolean sendSalery() {
		// Business Logic what triggers the salery payment for this specific
		// department manager
		return true;
	}

	/**
	 * @param employee
	 * @return
	 */
	public void add(Employee employee) {

		employees.put(employee.getId(), employee);
	}

	/**
	 * @param id
	 * @return
	 */
	public void remove(int id) {
		employees.remove(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public Employee getEmployee(int id) {
		return employees.get(id);
	}

}
