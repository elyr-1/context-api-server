package biz.global77.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.global77.model.Student;
import biz.global77.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		return Optional.empty();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudentById(Integer id, Student updatedStudent) {
		Optional<Student> student = studentRepo.findById(id);
		if (!updatedStudent.getFirstName().isBlank()) {
			student.get().setFirstName(updatedStudent.getFirstName());
		}
		if (!updatedStudent.getLastName().isBlank()) {
			student.get().setLastName(updatedStudent.getLastName());
		}
		if (!updatedStudent.getEmail().isBlank()) {
			student.get().setEmail(updatedStudent.getEmail());
		}
		studentRepo.save(student.get());
		return updatedStudent;
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
	}

}
