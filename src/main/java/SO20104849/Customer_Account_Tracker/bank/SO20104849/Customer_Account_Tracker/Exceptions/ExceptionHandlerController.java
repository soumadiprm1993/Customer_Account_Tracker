package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionHandlerController {
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	ExceptionResponse handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request)
	{
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestURI(request.getRequestURI());
		
		return response;
		
	}
	
	@ExceptionHandler(ResourceNotCreatedException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	ExceptionResponse handleResourceNotCreatedException(ResourceNotCreatedException exception, HttpServletRequest request)
	{
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestURI(request.getRequestURI());
		
		return response;
		
	}
}
