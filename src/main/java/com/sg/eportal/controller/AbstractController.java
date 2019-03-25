package com.sg.eportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sg.eportal.response.FaultResponse;
import com.sg.eportal.response.Response;



public class AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

	/**
	 * Throws illegal argument exception with messages in case of invalid bindings
	 * 
	 * @param bindingResult
	 */
	protected void checkBindingResults(BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
		StringBuilder errorMessages = new StringBuilder();	
			for(ObjectError error : bindingResult.getAllErrors())
			{
				DefaultMessageSourceResolvable defaultMessageSourceResolvable = (DefaultMessageSourceResolvable)error.getArguments()[0];
				errorMessages.append(defaultMessageSourceResolvable.getDefaultMessage()).append(" ").append(error.getDefaultMessage()).append("\n");
			}
			throw new IllegalArgumentException(errorMessages.toString());
		}
	}
	/**
	 * Creates and and returns 400 fault response for binding errors
	 * 
	 * @param e
	 * @return fault response
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Response handleIllegalArgumentException(Exception e) {

		FaultResponse faultResponse = new FaultResponse();
		faultResponse.setFaultDescription(e.getMessage());		
		faultResponse.setCode(HttpStatus.BAD_REQUEST.toString());
		faultResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
		return faultResponse;
	}

	/**
	 * Creates and returns 500 fault response for other exceptions
	 * 
	 * @param e
	 * @return fault response
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Response handleException(Exception e) {
		logger.error("exception occured"+e.getMessage());
		FaultResponse faultResponse = new FaultResponse();
		faultResponse.setFaultDescription(e.getMessage());		
		faultResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		faultResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		return faultResponse;
	}
	
	/**
	 * Use 200 Response to a successful GET, PUT, PATCH or DELETE. Can also be used for a POST that doesn't result in a creation.
	 * 201 Created - Response to a POST that results in a creation. 
	 * Should be combined with a Location header pointing to the location of the new resource
	 * @param response
	 * @return
	 */
	protected Response setAndReturnResponse(Response response, String code, String message, boolean success)
	{

		response.setCode(code);
		response.setMessage(message);
		response.setSuccess(success);
		
		return response;
	}

	protected Response setAndReturnSuccessResponse(Response response)
	{
		response.setCode(HttpStatus.OK.toString());
		response.setMessage(HttpStatus.OK.getReasonPhrase());
		response.setSuccess(true);
		
		return response;
	}
}
