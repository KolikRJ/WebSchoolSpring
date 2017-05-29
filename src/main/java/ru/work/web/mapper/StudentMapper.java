package ru.work.web.mapper;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.work.web.object.Student;

public interface StudentMapper {
	
	@Transactional
	public Student getStudent(int id);
	
	@Transactional
	public void addStudent(Student student);
	
	@Transactional
	public void deleteStudent(int id);
	
	@Transactional
	public void updateStudent(Student student);
	
	@Transactional
	public List<Student> getAllStudent();
}
