package in.nit.pawan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.pawan.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
