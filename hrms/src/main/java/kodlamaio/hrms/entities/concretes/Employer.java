package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")

public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_site")
	private String webSite;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "email_number")
	private boolean emailVerify;

	public Employer(String email, String password, String companyName, String webSite, String phoneNumber,
			boolean emailVerify) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.emailVerify = emailVerify;
	}

}
