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

/**
 * @author Daniel Krentzlin
 *
 */
public class Client {

	private Employee departmentManager;

	public void startClient() {
		departmentManager = new DepartmentManager(1,
				"Max Mustermann");
		Employee employee1 = new EmployeeImpl(2, "Sabine Musterfrau");
		Employee employee2 = new EmployeeImpl(3, "Sherlock Holmes");

		if (employee1 instanceof EmployeeImpl) {
			((DepartmentManager) departmentManager).add(employee1);
		}

		if (employee2 instanceof EmployeeImpl) {
			((DepartmentManager) departmentManager).add(employee2);
		}
	}
	
	public Employee getDeparmentManager() {
		return departmentManager;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("The employees of the department leader"
				+ departmentManager.getName() + " are: ");

		if (departmentManager instanceof DepartmentManager) {
			for (Employee employee : ((DepartmentManager) departmentManager)
					.getEmployees().values()) {
				sb.append( employee.getName()+ ", ");
			}

		}
		return sb.toString();
	}

}
