package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobseeker_languages")
@EqualsAndHashCode(callSuper = false)
public class JobseekerLanguage {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;

	@Column(name = "language_level")
	@CollectionTable()
	@Max(value = 5)
	@Min(value = 1)
	private int[] level;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "language_id")
	private Language language;
	
	@OneToMany(mappedBy = "jobseekerLanguage", targetEntity = CV.class, cascade = CascadeType.DETACH)
	private List<CV> cvs;
}
