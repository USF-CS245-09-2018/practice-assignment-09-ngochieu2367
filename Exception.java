public class Exception extends RuntimeException{

	public Exception(String message){
		super(message);
	}
}

//Usage: .... throw new Exception("Value is not set");  in source code