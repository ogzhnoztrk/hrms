package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "education_informations")
public class EducationInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int educationId;

	@Column(name = "start_date")
	@NotNull
	@NotBlank
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "school_id")
	private School school;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne(mappedBy = "educationInformation", targetEntity = CV.class, cascade = CascadeType.DETACH)
	private List<CV> cv;

}
