package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "cv")
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int cvId;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "picture_url")
	private String pictureUrl;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "education_information_id")
	private EducationInformation educationInformation;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "link_id")
	private Link link;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "job_experience_id")
	private JobExperience jobExperience;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ability_id")
	private Ability ability;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "jobseeker_language_id")
	private JobseekerLanguage jobseekerLanguage;
	
}
