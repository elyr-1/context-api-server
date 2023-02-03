package biz.global77.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biz.global77.model.Student;
import biz.global77.service.StudentServiceImpl;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok().body(studentService.getStudents());
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok().body(studentService.addStudent(student));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
		return ResponseEntity.ok().body(studentService.updateStudentById(id, updatedStudent));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}

}
