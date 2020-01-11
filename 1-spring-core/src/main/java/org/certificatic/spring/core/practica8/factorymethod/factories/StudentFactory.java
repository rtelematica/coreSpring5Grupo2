package org.certificatic.spring.core.practica8.factorymethod.factories;

import org.certificatic.spring.core.practica8.factorymethod.bean.Student;

public class StudentFactory {
	
	public Student buildStudent(String name, String materia) {
		return Student.constructStudent(name, materia);
	}
}
