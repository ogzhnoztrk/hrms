package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan Ekleme Başarılı.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İlanlar Listelendi");
	}

	@Override
	public Result deleteByAdvertisementId(int advertisementId) {
		this.jobAdvertisementDao.deleteById(advertisementId);
		return new SuccessResult("İlan Silindi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(isActive),
				"Veriler getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndApplicationDeadline(boolean isActive, Date deadLine) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByIsActiveAndApplicationDeadline(isActive, deadLine));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive,
			String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(isActive, companyName));
	}

	@Override
	public Result setValue(int id, boolean value) {
		JobAdvertisement job = this.jobAdvertisementDao.findByAdvertisementIdAndIsActiveTrue(id);
        job.setActive(value);
        this.jobAdvertisementDao.save(job);
        return new SuccessResult("Aktiflik durumu başarıyla değiştirildi.");
	}

	

}
