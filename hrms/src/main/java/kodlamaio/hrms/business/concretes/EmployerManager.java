package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailValidationService;
import kodlamaio.hrms.core.abstracts.EmployeeValidationService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.EmployerDao;
import kodlamaio.hrms.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}

	private EmployeeValidationService employeeValidationService = new EmployeeValidationService() {

		@Override
		public boolean isEmplooyeConfirmed() {
			// TODO Auto-generated method stub
			return false;
		}
	};
	private EmailValidationService emailValidationService = new EmailValidationService() {

		@Override
		public boolean isEmailConfirmed() {

			return false;
		}
	};

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data getirildi.");
	}

	@Override
	public Result register(Employer employer) {
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		if (!isEmailandWebsiteDomainSame(employer)) {	//Email Domain uyumu kontrolü
			return new ErrorResult("Email adresiniz ile domaniniz aynı olmalıdır");
		}
		if (!userDao.findByEmail(employer.getEmail()).isEmpty()) {
			return new ErrorResult("Email zaten kayıtlı.");
		}
		if (employeeValidationService.isEmplooyeConfirmed()) {
			return new ErrorResult("Hrms Doğrulma Başarısız"); // Hrms doğrulama Simule edildi
		}
		if (emailValidationService.isEmailConfirmed()) {
			employer.setEmailVerify(false);
			return new ErrorResult("Email Doğrulma Başarısız"); // Email doğrulama Simule edildi
		}
		
		employer.setEmailVerify(true);
		this.employerDao.save(employer);
		return new SuccessResult("Employer Added.");
	}


	private boolean isEmailandWebsiteDomainSame(Employer employer) {
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if (employer.getWebSite().contains(emailSplit[0]))
			return true;
		return false;
	}

}
