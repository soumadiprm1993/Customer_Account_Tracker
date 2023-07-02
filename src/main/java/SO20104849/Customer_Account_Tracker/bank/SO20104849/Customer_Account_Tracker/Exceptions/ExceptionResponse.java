package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Exceptions;

public class ExceptionResponse {

	String errorMessage;
	String requestURI;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
}
