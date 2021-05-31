package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.EmailValidationService;
import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobSeekerDao;
import kodlamaio.hrms.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao = userDao;

	}

	private EmailValidationService emailValidationService = new EmailValidationService() {

		@Override
		public boolean isEmailConfirmed() {

			return false;
		}
	};
	private MernisValidationService mernisService = new MernisValidationService() {

		@Override
		public boolean isMernisConfirmed() {

			return false;
		}
	};

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		if (mernisService.isMernisConfirmed()) {
			return new ErrorResult("Mernis Doğrulma Başarısız"); // Mernis Simule Edildi
		}
		if (!userDao.findByEmail(jobSeeker.getEmail()).isEmpty()) {
			return new ErrorResult("Email zaten kayıtlı.");
		}
		if (!jobSeekerDao.findByNationalId(jobSeeker.getNationalId()).isEmpty()) {
			return new ErrorResult("National id zaten mevcut.");
		}
		if (emailValidationService.isEmailConfirmed()) {
			return new ErrorResult("Email Doğrulma Başarısız"); // Email doğrulama Simule edildi
		}

		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Email Doğrulama Başarılı, Data Eklendi");
	}

}
