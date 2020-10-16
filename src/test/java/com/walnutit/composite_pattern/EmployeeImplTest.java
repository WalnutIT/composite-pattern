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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Daniel Krentzlin
 *
 */
class EmployeeImplTest {

	Employee employee;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		employee = new EmployeeImpl(1,"John Doe");
	}
	
	@Test
	final void constructorTest() {
		// given
		Employee excpectedEmployee = new EmployeeImpl(1, "John Doe");
		// when 
		
		// then
		assertThat(employee).usingRecursiveComparison()
		.isEqualTo(excpectedEmployee);
		
	}
	
	@Test
	final void constructorTestNegative() {
		// given
		Employee excpectedEmployee = new EmployeeImpl(2, "Test Doe");
		// when 
		
		// then
		assertThat(employee).usingRecursiveComparison()
		.isNotEqualTo(excpectedEmployee);
		
	}
	
	@Test
	final void nameGetterTest() {
		// given
		String name = "John Doe";
		
		// when
		
		// then
		assertEquals(employee.getName(), name);
	}
	
	@Test
	final void nameIdTest() {
		// given
		int id = 1;
		
		// when
		
		// then
		assertEquals(employee.getId(), id);
	}
	
	

	@Test
	final void sendSaleryTest() {
		// given

		// when
		

		// then
		assertTrue(employee.sendSalery());
	}

}
