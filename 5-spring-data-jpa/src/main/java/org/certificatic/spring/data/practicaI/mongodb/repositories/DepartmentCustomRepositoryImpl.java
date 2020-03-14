package org.certificatic.spring.data.practicaI.mongodb.repositories;

import java.util.ArrayList;
import java.util.List;

import org.certificatic.spring.data.practicaI.mongodb.document.Department;
import org.certificatic.spring.data.practicaI.mongodb.document.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

public class DepartmentCustomRepositoryImpl implements DepartmentCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Department> getDepartmentByChairId(Integer id) {
		CriteriaDefinition criteria = Criteria.where("chair.$id").is(id);
		Query query = new Query(criteria);
		return mongoTemplate.find(query, Department.class);
	}

	@Override
	public List<Department> getDepartmentByChairLastName(String lastName) {
		CriteriaDefinition criteria = Criteria.where("member.lastName")
															.is(lastName);
		Query query = new Query(criteria);
		List<Staff> staffList = mongoTemplate.find(query, Staff.class);

		List<Department> departments = new ArrayList<>();

		if (staffList.size() > 0) {
			Staff staff = staffList.get(0);

			departments = getDepartmentByChairId(staff.getId());
		}

		return departments;
	}

}
