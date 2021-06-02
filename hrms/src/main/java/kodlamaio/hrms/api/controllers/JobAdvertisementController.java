package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService advertisementService;
	
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return advertisementService.add(jobAdvertisement);
		
	}
	
	@DeleteMapping("/delete")
	Result deleteByAdvertisementId(@RequestBody int advertisementId) {
		return this.advertisementService.deleteByAdvertisementId(advertisementId);
		
	}
	
	@GetMapping("/getall")
	DataResult<List<JobAdvertisement>> getAll(){
		return this.advertisementService.getAll();
		
	}
	@GetMapping("/getActiveJobAdvertisements")
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive){
		return this.advertisementService.findByIsActive(true);
	}
	@GetMapping("/getActiveJobAdvertisementsOrderedByDate")
	public DataResult<List<JobAdvertisement>> findByIsActiveAndApplicationDeadline(boolean isActive, Date deadLine){
		return this.advertisementService.findByIsActiveAndApplicationDeadline(true, deadLine);
	}
	@GetMapping("/getActiveJobAdvertisementsWithCompanyName")
	public DataResult<List<JobAdvertisement>>findByIsActiveAndEmployer_CompanyName(boolean status, String companyName){
		return this.advertisementService.findByIsActiveAndEmployer_CompanyName(true, companyName);
	}
	
	
}
