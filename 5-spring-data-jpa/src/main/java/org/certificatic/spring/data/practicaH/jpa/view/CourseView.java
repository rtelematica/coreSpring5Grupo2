package org.certificatic.spring.data.practicaH.jpa.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CourseView {
	private String name;
	private String instructorFullName;
	private String deptName;

	public CourseView() {
	}

	public CourseView(String name, String instructorFirstName, 
					  String instructorLastName, String deptName) {
		super();
		this.name = name;
		this.instructorFullName = instructorFirstName + " " + instructorLastName;
		this.deptName = deptName;
	}

}