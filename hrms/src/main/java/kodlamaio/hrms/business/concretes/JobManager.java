package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobPositionDao;

import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobManager(JobPositionDao jobDao) {
		super();
		this.jobPositionDao = jobDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job getirildi");
	}

	@Override
	public Result add(JobPosition job) {
		if (!jobPositionDao.findByName(job.getName()).isEmpty()) {
			return new ErrorResult("Bu iş pozisyonu zaten eklenmiş");
		}
		this.jobPositionDao.save(job);
		return new SuccessResult("Job Added");
	}

}
