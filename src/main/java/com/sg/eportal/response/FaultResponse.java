package com.sg.eportal.response;

import org.springframework.context.annotation.Scope;

@Scope("request")
public class FaultResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6498567540064192801L;

	public FaultResponse() {
		super();
		this.setSuccess(false);
	}

	private String faultDescription;

	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}
	
}
