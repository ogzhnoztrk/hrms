package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);

	Result deleteByAdvertisementId(int advertisementId);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive);

	DataResult<List<JobAdvertisement>> findByIsActiveAndApplicationDeadline(boolean isActive, Date deadLine);

	DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);

	Result setValue(int id, boolean value);

}
