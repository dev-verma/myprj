package in.nit.pawan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.pawan.model.Student;
import in.nit.pawan.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService service;
	
	//1.Register student
	@GetMapping("/register")
	public String regStudent() {
		
		return "StudentRegistration";
		
	}
	//2.save student
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student,Model model) {
		String id=service.saveStudent(student);
		model.addAttribute("message", "Student  '"+id+"'save successfully");
		return "StudentRegistration" ;
		
	}
	//3.find all Student
	@GetMapping("/all")
	public String getAllStudent(Model model) {
		List<Student> list=service.getAllStudent();
		model.addAttribute("list", list);
		return "StudentData";
	}
	//4.delete student
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam String id ,Model model) {
		service.deleteStudent(id);
		model.addAttribute("message", "Student'"+id+"' Deleted");
		model.addAttribute("list", service.getAllStudent());
		return "StudentData";
	}
	
	//5.edit student 
	@GetMapping("/edit")
	public String stdEdit(@RequestParam String id,Model model) {
		Optional<Student> s=service.findOneStudent(id);
		model.addAttribute("student", s);
		return "StudentEdit";
		
	}
	//6.update student
	@PostMapping("/update")
	public String stdUpdate( @ModelAttribute Student student,Model model) {
		service.updateStudent(student);
		return "redirect:all";
	}
	

}
