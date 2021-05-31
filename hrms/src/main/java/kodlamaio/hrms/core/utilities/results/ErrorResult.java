package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false);
		// TODO Auto-generated constructor stub
	}
	public ErrorResult(String massage) {
		super(false, massage);
	}

}
