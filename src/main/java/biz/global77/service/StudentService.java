package biz.global77.service;

import java.util.List;
import java.util.Optional;

import biz.global77.model.Student;

public interface StudentService {
	
	List<Student> getStudents();
	Optional<Student> getStudentById(Integer id);
	Student addStudent(Student student);
	Student updateStudentById(Integer id, Student updatedStudent);
	void deleteStudentById(Integer id);

}
