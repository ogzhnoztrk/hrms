package kodlamaio.hrms.dataAccess;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findByIsActive(boolean isActive);
	List<JobAdvertisement> findByIsActiveAndApplicationDeadline(boolean isActive, Date deadline);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
	JobAdvertisement findByAdvertisementIdAndIsActiveTrue(int id);
}
