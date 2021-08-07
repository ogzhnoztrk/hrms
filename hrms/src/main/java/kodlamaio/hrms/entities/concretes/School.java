package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {
	
	@Id
	@NotNull
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int schoolId;
	
	@Column
	private String schoolName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "school", cascade = CascadeType.DETACH, targetEntity = EducationInformation.class)
	private List<EducationInformation> educationInformations;
	

}
