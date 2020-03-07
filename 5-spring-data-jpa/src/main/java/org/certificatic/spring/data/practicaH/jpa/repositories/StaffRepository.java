package org.certificatic.spring.data.practicaH.jpa.repositories;

import java.util.List;

import org.certificatic.spring.data.practicaH.jpa.entity.Course;
import org.certificatic.spring.data.practicaH.jpa.entity.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

// Extiende de PagingAndSortingRepository, despues extiende de StaffCustomRepository
public interface StaffRepository extends PagingAndSortingRepository<Staff, Long>, StaffCustomRepository {

	// Define los metodos conforme la practica lo requiera (guiado por instructor)
	
	@Query(value="SELECT s.* FROM STAFF_MEMBER_TBL AS s, COURSE_TBL AS c "
			+ "WHERE c.COURSE_NAME = :courseName AND s.ID = c.INSTRUCTOR_ID", nativeQuery = true)
	Iterable<Staff> findInstructorByCourseName(@Param("courseName") String courseName);

	@Query(value="SELECT s.* FROM STAFF_MEMBER_TBL AS s, COURSE_TBL AS c "
			+ "WHERE c.COURSE_NAME IN :courseNames AND s.ID = c.INSTRUCTOR_ID", nativeQuery = true)
	List<Staff> findInstructorByCourseNames(@Param("courseNames") List<String> courseNames);

	@Query("SELECT s FROM Staff s WHERE s.member.firstName = :first "
			+ "AND s.member.lastName = :last")
	List<Staff> selectStaffByFullname(@Param("first") String firstName, 
									  @Param("last") String lastName);

	@Query(value = "SELECT * FROM STAFF_MEMBER_TBL AS s "
			+ "WHERE s.STUDENT_FIRST_NAME = :first "
			+ "AND s.STUDENT_LAST_NAME = :last", nativeQuery = true)
	List<Staff> selectNativeStaffByFullname(@Param("first") String firstName, 
											@Param("last") String lastName);
	
}