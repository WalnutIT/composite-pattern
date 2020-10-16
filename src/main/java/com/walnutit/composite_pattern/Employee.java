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
public abstract class Employee {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public abstract boolean sendSalery();

}
