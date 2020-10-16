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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Daniel Krentzlin
 *
 */
class DepartmentManagerTest {

	DepartmentManager departmentManager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		departmentManager = new DepartmentManager(2,
				"Mr. Department");
	}

	@Test
	final void constructorTest() {
		// given
		DepartmentManager expectedDepartmentManager = new DepartmentManager(
				2, "Mr. Department");

		// when

		// then
		assertThat(departmentManager).usingRecursiveComparison()
				.isEqualTo(expectedDepartmentManager);
	}

	@Test
	final void sendSaleryTest() {
		// given

		// when

		// then
		assertTrue(departmentManager.sendSalery());
	}

	@Test
	final void nameGetterTest() {
		// given
		String name = "Mr. Department";

		// when

		// then
		assertEquals(departmentManager.getName(), name);
	}

	@Test
	final void nameIdTest() {
		// given
		int id = 2;

		// when

		// then
		assertEquals(departmentManager.getId(), id);
	}

	@Test
	final void addEmployeeTest() {
		// given
		Employee employee = new EmployeeImpl(1, "Test Employee");

		// when
		departmentManager.add(employee);

		// then
		assertTrue(departmentManager.getEmployees()
				.get(employee.getId()).equals(employee));

	}

	@Test
	final void removeEmployeeTest() {
		// given
		Employee employee = new EmployeeImpl(1, "Test Employee");
		departmentManager.add(employee);

		// when
		departmentManager.remove(employee.getId());

		// then
		assertFalse(departmentManager.getEmployees()
				.containsKey(employee.getId()));

	}
	
	@Test
	final void getEmployeeTest() {
		// given
		Employee employee = new EmployeeImpl(1, "Test Employee");
		departmentManager.add(employee);
		
		// when
		Employee actualEmployee = departmentManager.getEmployee(employee.getId());
		
		// then
		assertEquals(employee, actualEmployee);
	}

}
