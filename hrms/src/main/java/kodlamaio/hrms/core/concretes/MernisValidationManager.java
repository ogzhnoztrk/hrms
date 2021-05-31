package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.MernisValidationService;

public class MernisValidationManager implements MernisValidationService{

	@Override
	public boolean isMernisConfirmed() {
		
		return true;
	}

}
