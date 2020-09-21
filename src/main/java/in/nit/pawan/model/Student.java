package in.nit.pawan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="student_tab")
public class Student {
	@Id
	@GeneratedValue(generator="student")
	@GenericGenerator(name="student" ,strategy="in.nit.pawan.id.StudentGenerator")
	@Column(name="std_id_col")
	private String id;
	private String username;
	private String password;
	private String stdName;
	private Integer stdAge;
	private Double stdFee;

}
