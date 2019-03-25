package com.sg.eportal.response;

import java.io.Serializable;


import org.springframework.context.annotation.Scope;

@Scope("request")
public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3860024730620330721L;
	
	private long modelExecutionId;
	
	private String executionStatus;
	
	private String code;

	private String message;

	private boolean success;
	
	public long getModelExecutionId() {
		return modelExecutionId;
	}

	public void setModelExecutionId(long modelExecutionId) {
		this.modelExecutionId = modelExecutionId;
	}

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
}