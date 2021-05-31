package kodlamaio.hrms.core.utilities.results;

public class Result {
	private boolean success;
	private String massage;
	
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success, String massage) {
		this(success);
		this.massage = massage;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMassage() {
		return massage;
	}
	
}
