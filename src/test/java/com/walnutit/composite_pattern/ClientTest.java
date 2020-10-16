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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

/**
 * @author Daniel Krentzlin
 *
 */
class ClientTest {

	private static Logger LOG = null;
	private static MemoryAppender memoryAppender;
	private static final String LOGGER_NAME = "com.walnutit.composite_pattern.Client";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		LOG = (Logger) LoggerFactory.getLogger(LOGGER_NAME);
		memoryAppender = new MemoryAppender();
		memoryAppender.setContext(
				(LoggerContext) LoggerFactory.getILoggerFactory());
		LOG.setLevel(Level.INFO);
		LOG.addAppender(memoryAppender);
		memoryAppender.start();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		memoryAppender.reset();
		memoryAppender.stop();
	}

	Client client;

	Employee expectedDepartmentManager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		client = Client.getClient();
		expectedDepartmentManager = new DepartmentManager(1,
				"Max Mustermann");
		Employee employee1 = new EmployeeImpl(2, "Sabine Musterfrau");
		Employee employee2 = new EmployeeImpl(3, "Sherlock Holmes");

		if (employee1 instanceof EmployeeImpl) {
			((DepartmentManager) expectedDepartmentManager)
					.add(employee1);
		}

		if (employee2 instanceof EmployeeImpl) {
			((DepartmentManager) expectedDepartmentManager)
					.add(employee2);
		}
	}

	@Test
	final void startClientTest() {
		// given

		// when
		client.startClient();

		// then
		assertThat(client.getDeparmentManager())
				.usingRecursiveComparison()
				.isEqualTo(expectedDepartmentManager);
	}

	@Test
	public void toStringTest() {
		// given
		String expected = getExpectedTestString();

		// when
		client.startClient();
		String actual = client.toString();
		// test

		assertEquals(expected, actual);
	}

	private String getExpectedTestString() {

		StringBuilder sb = new StringBuilder();

		sb.append("The employees of the department leader "
				+ expectedDepartmentManager.getName() + " are: ");

		if (expectedDepartmentManager instanceof DepartmentManager) {
			for (Employee employee : ((DepartmentManager) expectedDepartmentManager)
					.getEmployees().values()) {
				sb.append(employee.getName() + ", ");
			}

		}
		return sb.toString();
	}

	@Test
	public void runTest() throws Exception {
		// given
		String[] args = new String[] {};

		// when
		client.run(args);

		// then
		assertTrue(memoryAppender.contains(
				"The employees of the department leader Max Mustermann are: Sabine Musterfrau, Sherlock Holmes, ",
				Level.INFO));
	}

}
