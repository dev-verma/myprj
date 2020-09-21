package in.nit.pawan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.nit.pawan.model.Student;

@Service
public interface IStudentService {
	public String saveStudent(Student s);
	public List<Student> getAllStudent();
	public void deleteStudent(String id);
	public void updateStudent(Student s);
	public Optional<Student> findOneStudent(String id);

}
