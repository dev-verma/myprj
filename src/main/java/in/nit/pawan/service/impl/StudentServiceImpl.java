package in.nit.pawan.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.nit.pawan.model.Student;
import in.nit.pawan.repo.StudentRepository;
import in.nit.pawan.service.IStudentService;
@Component
public class StudentServiceImpl  implements IStudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public String saveStudent(Student s) {
		s=repo.save(s);
		return s.getId();
	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
		
	}

	@Override
	public void deleteStudent(String id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
		
	}

	@Override
	public Optional<Student> findOneStudent(String id) {
		Optional<Student> s=repo.findById(id);
		return s;
	}

}
