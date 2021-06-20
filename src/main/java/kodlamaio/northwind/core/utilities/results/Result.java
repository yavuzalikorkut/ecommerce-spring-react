package kodlamaio.northwind.core.utilities.results;

public class Result { // super type(en soyut interfa gibi gorev goruyo) :soyut olarak gorev goruyor aslında, normalde c#da olsa interface yapılabilirdi ama java communitysi bunu bir obje olarak goruyor ve interface olarak adlandırılmasını sevmıyor 
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
} 
